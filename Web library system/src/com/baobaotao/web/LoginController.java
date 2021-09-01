package com.baobaotao.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.LmInfo;
import com.baobaotao.domain.UserInfo;
import com.baobaotao.service.LmService;
import com.baobaotao.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private LmService lmService;

	@RequestMapping(value = "/lmLoginCheck.do")
	public ModelAndView lmLoginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		boolean isValidUser = lmService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("lmLogin", "error", "用户名或密码错误。");
		} else {
			LmInfo user = lmService.findUserByUserName(loginCommand.getUserName());
			request.getSession().setAttribute("user", user);
			ModelAndView model = new ModelAndView();
			model.addObject("username", loginCommand.getUserName());
			model.setViewName("lmMain");
			return model;
		}
	}

	@RequestMapping(value = "/userLoginCheck.do")
	public ModelAndView userLoginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("userLogin", "error", "用户名或密码错误。");
		} else {
			request.getSession().setAttribute("username", loginCommand.getUserName());
			ModelAndView model = new ModelAndView();
			model.setViewName("userMain");

			return model;
		}
	}

	@RequestMapping(value = "/userRegisterCheck.do")
	public ModelAndView userRegisterCheck(HttpServletRequest request, LoginCommand loginCommand) {
		boolean isValidUser = userService.hasUsername(loginCommand.getUserName());
		boolean isValidPass = loginCommand.getPassword().equals(loginCommand.getPasswords());

		if (isValidUser) {
			return new ModelAndView("userRegister", "error", "用户名已存在。");
		}
		if (!isValidPass) {
			return new ModelAndView("userRegister", "error", "两次密码不一致");
		} else {
			UserInfo user = new UserInfo();
			user.setUserName(loginCommand.getUserName());
			user.setPassword(loginCommand.getPassword());
			user.setSex(loginCommand.getSex());
			user.setBorrowNum(10);
			user.setBorrowNumNow(0);
			user.setArrearageMoney(0.0);
			user.setDayLimit(30);
			user.setRemark("");
			userService.addUser(user);
			return new ModelAndView("userLogin");
		}
	}
}
