package user.details;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testinsertion {


	@Test
	public void testname()
	{
		insert h1 = new insert();
		assertEquals("saishanmukhi",h1.selectdb("shanmukhi"));
		assertEquals("music,books,travel",h1.selectdb1("shanmukhi"));
	}

}
