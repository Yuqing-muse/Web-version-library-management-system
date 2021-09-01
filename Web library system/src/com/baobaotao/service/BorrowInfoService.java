package com.baobaotao.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.BorrowInfoDao;
import com.baobaotao.domain.BorrowInfo;

@Service
public class BorrowInfoService {
	@Autowired
	private BorrowInfoDao borrowInfoDao;

	public boolean isCanBorrow(String username) {
		List<BorrowInfo> borrList = borrowInfoDao.queryBorrowList(username);
		for (int i = 0; i < borrList.size(); i++) {
			java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
			if (borrList.get(i).getBorrowlimit().before(currentDate)) {
				return false;
			}
		}
		return true;
	}

	public void insertBorrowInfo(BorrowInfo borrowInfo) {
		borrowInfoDao.insertBorrowInfo(borrowInfo);
	}

	public List<BorrowInfo> queryBorrowList(String username) {
		return borrowInfoDao.queryBorrowList(username);
	}

	public List<BorrowInfo> queryAllBorrowList() {
		return borrowInfoDao.queryAllBorrowList();
	}

	public boolean updateBorrLimit(BorrowInfo borrowInfo) {
		return borrowInfoDao.updateBorrowInfoLimit(borrowInfo);
	}

	public void updateBorrState(BorrowInfo borrowInfo) {
		borrowInfoDao.updateBorrowInfoState(borrowInfo);
	}
}
