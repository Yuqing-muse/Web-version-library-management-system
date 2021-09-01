package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.LmInfo;
import com.baobaotao.domain.UserInfo;

@Repository
public class LmInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getMatchCount(String userName, String password) {
		String sqlStr = " SELECT count(*) FROM lminfo " + " WHERE lmusername =? and password=? ";
		return jdbcTemplate.queryForInt(sqlStr, new Object[] { userName, password });
	}

	public LmInfo findUserByUserName(String userName) {
		String sqlStr = " SELECT lmusername" + " FROM lminfo WHERE lmusername =? ";
		final LmInfo user = new LmInfo();
		jdbcTemplate.query(sqlStr, new Object[] { userName }, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				user.setLmusername(userName);

			}
		});
		return user;
	}
}
