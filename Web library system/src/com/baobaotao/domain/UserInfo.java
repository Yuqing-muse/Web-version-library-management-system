package com.baobaotao.domain;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {

	private String userName;
	private String password;
	private String sex;
	private int borrowNum;
	private int borrowNumNow;
	private int dayLimit;
	private double arrearageMoney;
	private String remark;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getBorrowNum() {
		return borrowNum;
	}

	public void setBorrowNum(int borrowNum) {
		this.borrowNum = borrowNum;
	}

	public int getDayLimit() {
		return dayLimit;
	}

	public void setDayLimit(int dayLimit) {
		this.dayLimit = dayLimit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getBorrowNumNow() {
		return borrowNumNow;
	}

	public void setBorrowNumNow(int borrowNumNow) {
		this.borrowNumNow = borrowNumNow;
	}

	public double getArrearageMoney() {
		return arrearageMoney;
	}

	public void setArrearageMoney(double arrearageMoney) {
		this.arrearageMoney = arrearageMoney;
	}

}
