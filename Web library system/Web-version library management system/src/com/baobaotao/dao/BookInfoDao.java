package com.baobaotao.dao;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.BookInfo;
import com.baobaotao.domain.UserInfo;

@Repository
public class BookInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertBookInfo(BookInfo bookInfo) {
		String sqlStr = "INSERT INTO bookinfo() " + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		Object[] args = { bookInfo.getBookId(), bookInfo.getName(), bookInfo.getAuthor(), bookInfo.getType(),
				bookInfo.getPrice(), bookInfo.getKeywords(), bookInfo.getLocation(), bookInfo.getQuantity(),
				bookInfo.getQuantityNow(), bookInfo.getRemark(), bookInfo.getAddby() };
		if (jdbcTemplate.update(sqlStr, args) < 1)
			return false;
		else
			return true;
	}

	public boolean updateQuantityNow(BookInfo bookInfo) {
		String sqlStr = "update  bookinfo set quantityNow=? where bookid=? ";

		if (jdbcTemplate.update(sqlStr, new Object[] { bookInfo.getQuantityNow(), bookInfo.getBookId() }) < 1)
			return false;
		else
			return true;
	}

	// 返回name，type符合条件的bookinfo
	public List<BookInfo> queryBookInfo(String name, String type) throws UnsupportedEncodingException {
		String sqlStr = " SELECT *" + " FROM bookinfo WHERE name like '%" + name + "%' and type='" + type + "'";

		List<BookInfo> booklist = jdbcTemplate.query(sqlStr, new BookInfo());
		return booklist;
	}

	// 根据id查询bookinfo
	public BookInfo findBook(String bookId) throws UnsupportedEncodingException {
		String sqlStr = " SELECT *" + " FROM bookinfo WHERE bookid =? ";
		Object[] args = { new String(bookId.getBytes("ISO-8859-1"), "utf-8") };
		BookInfo bookInfo = new BookInfo();
		jdbcTemplate.query(sqlStr, args, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				bookInfo.setBookId(rs.getString("bookid"));
				bookInfo.setAuthor(rs.getString("author"));
				bookInfo.setKeywords(rs.getString("keywords"));
				bookInfo.setLocation(rs.getString("location"));
				bookInfo.setName(rs.getString("name"));
				bookInfo.setPrice(rs.getDouble("price"));
				bookInfo.setQuantity(rs.getInt("quantity"));
				bookInfo.setQuantityNow(rs.getInt("quantityNow"));
				bookInfo.setRemark(rs.getString("remark"));
				bookInfo.setType(rs.getString("type"));
			}
		});
		return bookInfo;
	}
}
