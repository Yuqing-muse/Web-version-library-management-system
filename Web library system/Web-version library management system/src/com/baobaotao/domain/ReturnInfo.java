package com.baobaotao.domain;

import java.io.Serializable;
import java.sql.Date;

public class ReturnInfo implements Serializable{
	private String reId;
	private String username;
	private Date returnDate;
	private String remark;
	private String borrId;
	public String getReId() {
		return reId;
	}
	public void setReId(String reId) {
		this.reId = reId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getReturndate() {
		return returnDate;
	}
	public void setReturndate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBorrId() {
		return borrId;
	}
	public void setBorrId(String borrId) {
		this.borrId = borrId;
	}
}
