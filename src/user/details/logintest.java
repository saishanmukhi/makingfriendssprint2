package user.details;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class logintest {


	@Test
	public void testlogin() 
    {
		login h1 = new login();
        assertEquals("sai@1234",h1.logintest("shanmukhi"));
        assertNotEquals("sai123", h1.logintest("shanmukhi"));
        assertNotEquals("", h1.logintest("shanmukhi"));
    }

}
