package user.details.testcases;

import static org.junit.Assert.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import user.details.search;

public class testsearchavailableusers {
	ArrayList<String> listp = new ArrayList<String>();

		@Test
	public void testsearchuser() {
		search h1 = new search();
		String time1 = "17:00";
		String time2 = "19:00";

		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		Date date1=null,date2=null;
		try {
			date1 = format.parse(time1);
			date2 = format.parse(time2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Time t=new Time(date1.getTime());
		Time t1=new Time(date2.getTime());
		listp= h1.searchuser("2017-04-09",t,t1);
		assertFalse(listp.isEmpty());
		assertTrue(listp.contains("lwhite"));
		assertEquals(listp.get(0),"lwhite");
	}

}
