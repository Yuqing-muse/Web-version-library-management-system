package com.baobaotao.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtil {
	public static Date dateUp(Date date, int day) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		calendar.add(Calendar.DAY_OF_YEAR, day);// 30为增加的天数，可以改变的
		// calendar的time转成java.util.Date格式日期
		java.util.Date utilDate = (java.util.Date) calendar.getTime();
		// calendar.add(calendar.DATE, 6);
		utilDate = (java.util.Date) calendar.getTime();
		// java.util.Date日期转换成转成java.sql.Date格式
		Date newDate = new Date(utilDate.getTime());
		// Date d = new Date(calendar.getTime().getYear(),
		// calendar.getTime().getMonth(), calendar.getTime().getDay());
		return newDate;
	}

	public static int getSub(Date date1, Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
		return days;
	}

	public static void main(String[] args) {
		System.out.println("aa");
	}
}
