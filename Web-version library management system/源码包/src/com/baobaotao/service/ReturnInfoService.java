package com.baobaotao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.ReturnInfoDao;
import com.baobaotao.domain.ReturnInfo;

@Service
public class ReturnInfoService {
	@Autowired
	private ReturnInfoDao returnInfoDao;

	public boolean insertReturn(ReturnInfo returninfo) {
		return returnInfoDao.insertReturnInfo(returninfo);
	}

	public ReturnInfo getByBorrowId(String borrowId) {
		return returnInfoDao.getByBorrowId(borrowId);
	}
}
