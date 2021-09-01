package com.baobaotao.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookInfo implements Serializable, RowMapper<BookInfo> {
	private String bookId;
	private String author;
	private String keywords;
	private String name;
	private String remark;
	private String type;
	private String location;
	private double price;
	private int quantity;
	private int quantityNow;
	private String addby;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String string) {
		this.bookId = string;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantityNow() {
		return quantityNow;
	}

	public void setQuantityNow(int quantityNow) {
		this.quantityNow = quantityNow;
	}

	@Override
	public BookInfo mapRow(ResultSet arg0, int arg1) throws SQLException {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setAuthor(arg0.getString("author"));
		bookInfo.setBookId(arg0.getString("bookId"));
		bookInfo.setKeywords(arg0.getString("keywords"));
		bookInfo.setLocation(arg0.getString("location"));
		bookInfo.setName(arg0.getString("name"));
		bookInfo.setPrice(arg0.getDouble("price"));
		bookInfo.setQuantity(arg0.getInt("quantity"));
		bookInfo.setQuantityNow(arg0.getInt("quantityNow"));
		bookInfo.setRemark(arg0.getString("remark"));
		bookInfo.setType(arg0.getString("type"));
		return bookInfo;
	}

	public String getAddby() {
		return addby;
	}

	public void setAddby(String addby) {
		this.addby = addby;
	}
}
