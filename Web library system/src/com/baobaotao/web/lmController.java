package com.baobaotao.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
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
import com.baobaotao.service.BookInfoService;
import com.baobaotao.service.BorrowInfoService;
import com.baobaotao.service.ReturnInfoService;
import com.baobaotao.service.UserService;
import com.baobaotao.util.DateUtil;

@Controller
public class lmController {

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

	@RequestMapping(value = "/addBookMain.do")
	public ModelAndView addBookMain(HttpServletRequest request, BookInfo bookInfo, HttpServletResponse response)
			throws IOException {
		ModelAndView model = new ModelAndView();
		model.addObject("username", request.getParameter("username"));
		model.setViewName("addBook");
		return model;

	}

	@RequestMapping(value = "/addBook.do")
	public void addBook(HttpServletRequest request, BookInfo bookInfo, HttpServletResponse response)
			throws IOException {
		try {
			bookInfo.setName(new String(bookInfo.getName().getBytes("ISO-8859-1"), "utf-8"));
			bookInfo.setAuthor(new String(bookInfo.getAuthor().getBytes("ISO-8859-1"), "utf-8"));
			bookInfo.setKeywords(new String(bookInfo.getKeywords().getBytes("ISO-8859-1"), "utf-8"));
			bookInfo.setLocation(new String(bookInfo.getLocation().getBytes("ISO-8859-1"), "utf-8"));
			bookInfo.setType(new String(bookInfo.getType().getBytes("ISO-8859-1"), "utf-8"));
			bookInfo.setRemark(new String(bookInfo.getRemark().getBytes("ISO-8859-1"), "utf-8"));
			bookInfo.setBookId(UUID.randomUUID().toString());
			bookInfo.setQuantityNow(bookInfo.getQuantity());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (bookInfoService.insertBookInfo(bookInfo)) {
			out.print(
					"<script language=\"javascript\">alert('录入成功！');window.location.href='/chapter2/addBook.jsp'</script>");
		}
		out.print(
				"<script language=\"javascript\">alert('录入失败！');window.location.href='/chapter2/addBook.jsp'</script>");

	}

	@RequestMapping(value = "/getAllBorrowList.do")
	public ModelAndView getAllBorrowList(HttpServletRequest request, HttpServletResponse response) throws IOException {

		borrList = borrowInfoService.queryAllBorrowList();

		List<String> returnList = new ArrayList<>();
		List<BookInfo> bookList = new ArrayList<>();
		for (int i = 0; i < borrList.size(); i++) {
			bookList.add(bookInfoService.findBook(borrList.get(i).getBorrbookid()));
			if (borrList.get(i).getBorrowlimit().before(new java.sql.Date(System.currentTimeMillis()))) {
				int delayDays = DateUtil.getSub(borrList.get(i).getBorrowlimit(),
						new java.sql.Date(System.currentTimeMillis()));
				borrList.get(i).setArrearagemoney(delayDays * 0.1);
			}
			ReturnInfo returninfo = returnInfoService.getByBorrowId(borrList.get(i).getBorrid());
			if (returninfo.getReturndate() == null)
				returnList.add("未还");
			else
				returnList.add(returninfo.getReturndate().toString());
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("getAllBorrowList");
		modelAndView.addObject("bookList", bookList);
		modelAndView.addObject("borrList", borrList);
		modelAndView.addObject("returnList", returnList);
		return modelAndView;
	}

}
