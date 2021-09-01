package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.BookInfo;
import com.baobaotao.domain.BorrowInfo;

@Repository
public class BorrowInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertBorrowInfo(BorrowInfo borrowInfo) {
		String sqlStr = "INSERT INTO borrowInfo(borrid,borrbookid,username,borrowdate,borrowlimit,state ,arrearagemoney,remark) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		Object[] args = { borrowInfo.getBorrid(), borrowInfo.getBorrbookid(), borrowInfo.getUsername(),
				borrowInfo.getBorrowdate(), borrowInfo.getBorrowlimit(), "doing", 0.0, borrowInfo.getRemark() };
		jdbcTemplate.update(sqlStr, args);
	}

	public boolean updateBorrowInfoLimit(BorrowInfo borrowInfo) {
		String sqlStr = " UPDATE borrowInfo SET borrowlimit=?" + " WHERE borrId =?";
		if (jdbcTemplate.update(sqlStr, new Object[] { borrowInfo.getBorrowlimit(), borrowInfo.getBorrid() }) < 1)
			return false;
		return true;
	}

	public void updateBorrowInfoState(BorrowInfo borrowInfo) {
		String sqlStr = " UPDATE borrowInfo SET state=?" + " WHERE borrId =?";
		jdbcTemplate.update(sqlStr, new Object[] { borrowInfo.getState(), borrowInfo.getBorrid() });
	}

	public List<BorrowInfo> queryBorrowList(String username) {
		String sqlStr = " select * from borrowinfo where username='" + username
				+ "' and state='doing' or state is null";
		List<BorrowInfo> borrowlist = jdbcTemplate.query(sqlStr, new BorrowInfo());
		return borrowlist;
	}

	public List<BorrowInfo> queryAllBorrowList() {
		String sqlStr = " select * from borrowinfo";
		List<BorrowInfo> borrowlist = jdbcTemplate.query(sqlStr, new BorrowInfo());
		return borrowlist;
	}
}
