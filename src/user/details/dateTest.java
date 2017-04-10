package user.details;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class dateTest {

	@Test
	public void dateTest() 
	{
		validate r = new validate();
		assertTrue(r.validateDate("2017-04-09"));
		assertFalse("the year is before the current year", r.validateDate("2016-04-08"));
		assertFalse("the month is before the current month", r.validateDate("2017-03-08"));
		assertFalse("the month is out of bounds", r.validateDate("2017-13-08"));
		assertFalse("the day is before the current day", r.validateDate("2017-04-07"));
		assertFalse("the day is out of bounds", r.validateDate("2017-04-33"));
	}
	@Test
	public void fromTest() 
	{
		validate r = new validate();
		assertTrue(r.validateFromTime("12:00", "2017-04-09"));
		assertFalse("the time is out of bounds", r.validateFromTime("23:35", "2017-04-08"));
		assertFalse("the hour is before the current hour", r.validateFromTime("04:45", "2017-04-08"));
		assertFalse("the hour is out of bounds", r.validateFromTime("24:45", "2017-04-08"));
		assertFalse("the minute is before the current minute", r.validateFromTime("23:01", "2017-04-08"));
		assertFalse("the minute is out of bounds", r.validateFromTime("23:60", "2017-04-08"));
		assertFalse("the minute is out of bounds", r.validateFromTime("23:60", "2017-04-09"));
		assertFalse("the hour is out of bounds", r.validateFromTime("24:45", "2017-04-09"));
	}
	@Test
	public void toTest() 
	{
		validate r = new validate();
		assertTrue(r.validateToTime("10:25", "2017-04-09"));
		assertFalse("the time is out of bounds", r.validateToTime("00:00", "2017-04-08"));
		assertFalse("the hour is before the current hour", r.validateToTime("04:45", "2017-04-08"));
		assertFalse("the hour is out of bounds", r.validateToTime("24:45", "2017-04-08"));
		assertFalse("the minute is before the current minute", r.validateToTime("10:10", "2017-04-08"));
		assertFalse("the minute is out of bounds", r.validateToTime("10:60", "2017-04-09"));
		assertFalse("the hour is out of bounds", r.validateToTime("24:45", "2017-04-09"));
	}

}
