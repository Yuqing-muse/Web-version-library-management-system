package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.UserInfo;

@Repository
public class UserInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean hasUsername(String userName) {
		String sqlStr = " SELECT count(*) FROM userinfo " + " WHERE username =? ";
		int i = jdbcTemplate.queryForInt(sqlStr, new Object[] { userName });
		if (i > 0)
			return true;
		return false;
	}

	public int getMatchCount(String userName, String password) {
		String sqlStr = " SELECT count(*) FROM userinfo " + " WHERE username =? and password=? ";
		return jdbcTemplate.queryForInt(sqlStr, new Object[] { userName, password });
	}

	public UserInfo findUserByUserName(final String userName) {
		String sqlStr = " SELECT username,sex,borrowNum,borrowNumNow,dayLimit,arrearageMoney "
				+ " FROM userinfo WHERE username =? ";
		final UserInfo user = new UserInfo();
		jdbcTemplate.query(sqlStr, new Object[] { userName }, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserName(userName);
				user.setSex(rs.getString("sex"));
				user.setBorrowNum(rs.getInt("borrowNum"));
				user.setDayLimit(rs.getInt("dayLimit"));
				user.setBorrowNumNow(rs.getInt("borrowNumNow"));
				user.setArrearageMoney(rs.getDouble("arrearageMoney"));
			}
		});
		return user;
	}

	public boolean updateUserInfo(UserInfo user) {
		String sqlStr = " UPDATE userinfo SET borrowNum=?,borrowNumNow=?,dayLimit=? ,arrearageMoney=?" + " WHERE username =?";
		return (jdbcTemplate.update(sqlStr,
				new Object[] { user.getBorrowNum(), user.getBorrowNumNow(), user.getDayLimit(),user.getArrearageMoney(),user.getUserName() }) > 0);
	}

	public void addUser(UserInfo user) {
		String sqlStr = "INSERT INTO userinfo VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate
				.update(sqlStr,
						new Object[] { user.getUserName(), user.getPassword(), user.getSex(), user.getBorrowNum(),
								user.getBorrowNumNow(), user.getDayLimit(), user.getArrearageMoney(),
								user.getRemark() });
	}
}
