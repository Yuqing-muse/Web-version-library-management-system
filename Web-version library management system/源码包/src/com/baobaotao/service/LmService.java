package com.baobaotao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.LmInfoDao;
import com.baobaotao.domain.LmInfo;
import com.baobaotao.domain.UserInfo;

@Service
public class LmService {

	@Autowired
	private LmInfoDao LmDao;

	public boolean hasMatchUser(String userName, String password) {
		int matchCount = LmDao.getMatchCount(userName, password);
		return matchCount > 0;
	}

	public LmInfo findUserByUserName(String userName) {
		return LmDao.findUserByUserName(userName);
	}

}
