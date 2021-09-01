package com.baobaotao.domain;

import java.io.Serializable;

public class LmInfo implements Serializable {
	private String lmusername;
	private String password;
	private String remark;

	public String getLmusername() {
		return lmusername;
	}

	public void setLmusername(String username) {
		this.lmusername = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
