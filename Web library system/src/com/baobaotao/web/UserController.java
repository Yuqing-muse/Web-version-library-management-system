package com.baobaotao.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.BookInfo;
import com.baobaotao.domain.BorrowInfo;
import com.baobaotao.domain.ReturnInfo;
import com.baobaotao.domain.UserInfo;
import com.baobaotao.service.BookInfoService;
import com.baobaotao.service.BorrowInfoService;
import com.baobaotao.service.ReturnInfoService;
import com.baobaotao.service.UserService;
import com.baobaotao.util.DateUtil;

@Controller
public class UserController {
	@Autowired
	private BookInfoService bookInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private BorrowInfoService borrowInfoService;
	@Autowired
	private ReturnInfoService returnInfoService;
	List<BookInfo> dataLists = new ArrayList<>();
	List<BorrowInfo> borrList = new ArrayList<>();

	@RequestMapping(value = "/getQueryBooks.do")
	public ModelAndView getQueryBooks(HttpServletRequest request) throws UnsupportedEncodingException {
		if (dataLists.size() <= 0||request.getParameter("name")!=null)
			dataLists = bookInfoService.queryBookInfo(request.getParameter("name"), request.getParameter("type"));
		ModelAndView modelAndView = new ModelAndView();
		// 将数据放到request中
		modelAndView.addObject("datasList", dataLists);
		// 指定视图
		modelAndView.setViewName("userMain");

		return modelAndView;
	}

	@RequestMapping(value = "/checkCanBorrow.do")
	public ModelAndView checkCanBorrow(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		BookInfo bookInfo = new BookInfo();
		bookInfo.setName(request.getParameter("name"));
		bookInfo.setBookId(request.getParameter("bookId"));
		bookInfo.setAuthor(request.getParameter("author"));
		bookInfo.setQuantityNow(Integer.parseInt(request.getParameter("quantityNow")));
		UserInfo user = userService.findUserByUserName(request.getParameter("username"));
		if (user.getBorrowNum() - user.getBorrowNumNow() > 0 && user.getArrearageMoney() <= 0
				&& borrowInfoService.isCanBorrow(user.getUserName())) {
			model.addObject("result", "可借");
		}
		model.addObject("bookInfo", bookInfo);
		model.addObject("user", user);
		model.addObject("count", request.getParameter("count"));
		model.setViewName("checkBorrowBook");
		return model;
	}

	@RequestMapping(value = "/borrow.do")
	public void borrow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BookInfo bookInfo = new BookInfo();
		UserInfo user = userService.findUserByUserName(request.getParameter("username"));
		user.setBorrowNumNow(user.getBorrowNumNow() + 1);
		bookInfo.setBookId(request.getParameter("bookId"));
		bookInfo.setQuantityNow(Integer.parseInt(request.getParameter("quantityNow")) - 1);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (bookInfoService.updateQuantityNow(bookInfo)) {
			userService.updateUserInfo(user);
			BorrowInfo borrowInfo = new BorrowInfo();
			borrowInfo.setBorrbookid(bookInfo.getBookId());
			borrowInfo.setBorrid(UUID.randomUUID().toString());
			borrowInfo.setBorrowdate(new java.sql.Date(System.currentTimeMillis()));
			borrowInfo.setBorrowlimit(DateUtil.dateUp(borrowInfo.getBorrowdate(), user.getDayLimit()));
			String date = borrowInfo.getBorrowlimit().toString();
			borrowInfo.setUsername(user.getUserName());
			borrowInfoService.insertBorrowInfo(borrowInfo);
			dataLists.get(Integer.parseInt(request.getParameter("count"))).setQuantityNow(
					dataLists.get(Integer.parseInt(request.getParameter("count"))).getQuantityNow() - 1);

			out.print("<script language=\"javascript\">alert('借阅成功！请于" + date
					+ "前归还');window.location.href='getQueryBooks.do';</script>");

		} else
			out.print("<script language=\"javascript\">alert('借阅失败！');history.go(-2);</script>");

	}

	@RequestMapping(value = "/getAllReturnBooks.do")
	public ModelAndView getAllReturnBooks(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");

		if (username != null)
			borrList = borrowInfoService.queryBorrowList(username);
		List<BookInfo> bookList = new ArrayList<>();
		for (int i = 0; i < borrList.size(); i++) {
			bookList.add(bookInfoService.findBook(borrList.get(i).getBorrbookid()));
			if (borrList.get(i).getBorrowlimit().before(new java.sql.Date(System.currentTimeMillis()))) {
				int delayDays = DateUtil.getSub(borrList.get(i).getBorrowlimit(),
						new java.sql.Date(System.currentTimeMillis()));
				borrList.get(i).setArrearagemoney(delayDays * 0.1);
			}
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("checkReturnBook");
		modelAndView.addObject("bookList", bookList);
		modelAndView.addObject("borrList", borrList);
		modelAndView.addObject("username", username);
		return modelAndView;
	}

	@RequestMapping(value = "/returnBook.do")
	public void returnBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String borrid = request.getParameter("borrId");
		String bookId = request.getParameter("bookId");
		String username = request.getParameter("username");
		String arrearagemoney = request.getParameter("arrearagemoney");

		BorrowInfo borrInfo = new BorrowInfo();
		borrInfo.setBorrid(borrid);
		borrInfo.setState("finish");
		borrowInfoService.updateBorrState(borrInfo);
		borrList.remove(Integer.parseInt(request.getParameter("count")));

		UserInfo user = userService.findUserByUserName(username);
		user.setArrearageMoney(user.getArrearageMoney() + Double.parseDouble(arrearagemoney));
		user.setBorrowNumNow(user.getBorrowNumNow() - 1);
		userService.updateUserInfo(user);

		BookInfo bookinfo = bookInfoService.findBook(bookId);
		bookinfo.setQuantityNow(bookinfo.getQuantityNow() + 1);
		bookInfoService.updateQuantityNow(bookinfo);

		ReturnInfo returnInfo = new ReturnInfo();
		returnInfo.setReId(UUID.randomUUID().toString());
		returnInfo.setBorrId(borrid);
		returnInfo.setReturndate(new java.sql.Date(System.currentTimeMillis()));
		returnInfo.setUsername(username);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean f = returnInfoService.insertReturn(returnInfo);
		if (f && Double.parseDouble(arrearagemoney) != 0) {
			out.print(
					"<script language=\"javascript\">alert('还书成功,请及时缴费!');window.location.href='getAllReturnBooks.do?';</script>");
		}
		if (f && Double.parseDouble(arrearagemoney) == 0) {
			out.print(
					"<script language=\"javascript\">alert('还书成功!');window.location.href='getAllReturnBooks.do';</script>");
		} else
			out.print(
					"<script language=\"javascript\">alert('还书失败!');window.location.href='getAllReturnBooks.do';</script>");

	}

	@RequestMapping(value = "/checkRepay.do")
	public ModelAndView checkRepay(HttpServletRequest request) {
		String username = request.getParameter("username");

		ModelAndView model = new ModelAndView();
		model.addObject("username", username);
		model.addObject("arrearageMoney", userService.findUserByUserName(username).getArrearageMoney());
		model.setViewName("checkRepay");
		return model;

	}

	@RequestMapping(value = "/repay.do")
	public void repay(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		UserInfo user = userService.findUserByUserName(username);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (user.getArrearageMoney() == 0) {
			out.print("<script language=\"javascript\">alert('您无需缴费!');history.go(-2);</script>");
		}
		user.setArrearageMoney(0);

		if (userService.updateUserInfo(user)) {
			out.print("<script language=\"javascript\">alert('缴费成功!');history.go(-2);</script>");
		} else
			out.print("<script language=\"javascript\">alert('缴费失败!');history.go(-1);</script>");
	}

	@RequestMapping(value = "/getRenewBooks.do")
	public ModelAndView getRenewBooks(HttpServletRequest request) throws UnsupportedEncodingException {
		String username = request.getParameter("username");
		if (borrList.size() <= 0)
			borrList = borrowInfoService.queryBorrowList(username);
		List<BookInfo> bookList = new ArrayList<>();
		for (int i = 0; i < borrList.size(); i++)
			bookList.add(bookInfoService.findBook(borrList.get(i).getBorrbookid()));
		ModelAndView model = new ModelAndView();
		model.addObject("username", username);
		model.addObject("borrList", borrList);
		model.addObject("bookList", bookList);
		model.setViewName("getRenewBooks");
		return model;

	}

	@RequestMapping(value = "/renewBook.do")
	public void renewBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		BorrowInfo borrInfo = borrList.get(Integer.parseInt(request.getParameter("count")));
		borrInfo.setBorrowlimit(DateUtil.dateUp(borrInfo.getBorrowlimit(), 30));

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (borrowInfoService.updateBorrLimit(borrInfo)) {
			out.print("<script language=\"javascript\">alert('续借成功!');window.location.href='getRenewBooks.do';</script>");
		} else
			out.print("<script language=\"javascript\">alert('续借失败!');history.go(-1);</script>");
	}
}
