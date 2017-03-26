package user.details;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class validateUsername {

	@Before

	@Test
	public void testValidateUsername() 
    {
		validate h1 = new validate();
        assertTrue("Username already exists",h1.validateusername("shanmukhi"));
        assertFalse("Username Does not exist", h1.validateusername("loriwhite"));
        assertFalse("Username Does not exist", h1.validateusername("saisusheel"));
    }
}
