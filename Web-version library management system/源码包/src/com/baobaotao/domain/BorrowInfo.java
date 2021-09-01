package com.baobaotao.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BorrowInfo implements Serializable, RowMapper<BorrowInfo> {
	private String borrid;
	private String username;
	private Date borrowdate;
	private Date borrowlimit;
	private String remark;
	private String state;
	private double arrearagemoney;
	private String borrbookid;

	public String getBorrid() {
		return borrid;
	}

	public void setBorrid(String borrid) {
		this.borrid = borrid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Date getBorrowlimit() {
		return borrowlimit;
	}

	public void setBorrowlimit(Date borrowlimit) {
		this.borrowlimit = borrowlimit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBorrbookid() {
		return borrbookid;
	}

	public void setBorrbookid(String borrbookid) {
		this.borrbookid = borrbookid;
	}

	@Override
	public BorrowInfo mapRow(ResultSet arg0, int arg1) throws SQLException {
		BorrowInfo borrowInfo = new BorrowInfo();
		borrowInfo.setBorrid(arg0.getString("borrid"));
		borrowInfo.setBorrbookid(arg0.getString("borrbookid"));
		borrowInfo.setBorrowdate(arg0.getDate("borrowdate"));
		borrowInfo.setBorrowlimit(arg0.getDate("borrowlimit"));
		borrowInfo.setRemark(arg0.getString("remark"));
		borrowInfo.setUsername(arg0.getString("username"));
		
		return borrowInfo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getArrearagemoney() {
		return arrearagemoney;
	}

	public void setArrearagemoney(double arrearagemoney) {
		this.arrearagemoney = arrearagemoney;
	}
}
