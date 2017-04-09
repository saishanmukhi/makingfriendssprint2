package user.details.testcases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import user.details.dbconnect;
import user.details.timeinsert;

public class testtimeinsertion {

	
	@Test
	public void testtimeinsertion() {
		timeinsert ti= new timeinsert();
		boolean ip1;
		ip1 = ti.insertfreetime("shanmukhi","2017-04-10","16:00","18:00");
		assertTrue("inserted freetime",ip1);
		try
		{
			dbconnect db = new dbconnect();
			Connection con = db.connect();
			Statement st = con.createStatement();
			String q2 = "select from1 from freetime where username='shanmukhi' ";
			ResultSet rs1 = st.executeQuery(q2);
			String we="";
            while(rs1.next())
            {
            	we=rs1.getString(1);
            }
            assertEquals(we,"16:00:00");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
