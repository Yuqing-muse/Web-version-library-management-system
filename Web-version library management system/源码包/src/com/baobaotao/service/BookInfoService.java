package com.baobaotao.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.BookInfoDao;
import com.baobaotao.domain.BookInfo;

@Service
public class BookInfoService {
	@Autowired
	private BookInfoDao bookDao;
	
	public boolean insertBookInfo(BookInfo bookInfo){
		return bookDao.insertBookInfo(bookInfo);
	}
	public List<BookInfo> queryBookInfo(String name,String type) throws UnsupportedEncodingException{
		return bookDao.queryBookInfo(name,type);
	}
	public boolean updateQuantityNow(BookInfo bookInfo) {
		return bookDao.updateQuantityNow(bookInfo);
	}
	public BookInfo findBook(String bookId) throws UnsupportedEncodingException {
		return bookDao.findBook(bookId);
	}
	
}
