package user.details.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import user.details.dbconnect;

public class testdatabaseconnection {


	@Test
	public void databaseConnectionTest()
	{
		dbconnect h1 = new dbconnect();
		assertNotNull(h1.connect());
		
	}
}
