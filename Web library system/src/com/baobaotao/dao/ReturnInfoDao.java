package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.BorrowInfo;
import com.baobaotao.domain.ReturnInfo;

@Repository
public class ReturnInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertReturnInfo(ReturnInfo returnInfo) {
		String sqlStr = "INSERT INTO returnInfo(returnid,borrowId,username,returndate,remark) " + "VALUES(?,?,?,?,?)";
		Object[] args = { UUID.randomUUID().toString(), returnInfo.getBorrId(), returnInfo.getUsername(),
				returnInfo.getReturndate(), returnInfo.getRemark() };
		if (jdbcTemplate.update(sqlStr, args) < 1) {
			return false;
		}
		return true;
	}

	public ReturnInfo getByBorrowId(String borrowId) {
		String sqlStr = " select * from returninfo where borrowId='" + borrowId + "'";
		ReturnInfo info = new ReturnInfo();
		jdbcTemplate.query(sqlStr, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				info.setReturndate(rs.getDate("returndate"));
			}
		});
		return info;
	}

}
