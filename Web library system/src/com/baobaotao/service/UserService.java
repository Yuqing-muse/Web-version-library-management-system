package com.baobaotao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.UserInfoDao;
import com.baobaotao.domain.UserInfo;

@Service
public class UserService {

	@Autowired
	private UserInfoDao userDao;

	public boolean hasMatchUser(String userName, String password) {
		int matchCount = userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	public boolean hasUsername(String username){
		return userDao.hasUsername(username);
	}
	public UserInfo findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	public void addUser(UserInfo user) {
		userDao.addUser(user);
	}
	public boolean updateUserInfo(UserInfo user) {
		return userDao.updateUserInfo(user);
	}

}
