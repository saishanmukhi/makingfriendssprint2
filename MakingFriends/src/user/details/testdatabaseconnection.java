package user.details;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testdatabaseconnection {


	@Test
	public void databaseConnectionTest()
	{
		dbconnect h1 = new dbconnect();
		assertNotNull(h1.connect());
		
	}
}
