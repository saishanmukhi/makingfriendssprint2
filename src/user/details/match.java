package user.details;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class match {

	public void matchinterest()
	{
		
	 try
        {
		 	dbconnect db = new dbconnect();
			Connection con = db.connect();
            Statement st = con.createStatement();
            String q1 = "select username from userdata where username != 'shanmukhi'";
            ResultSet rs = st.executeQuery(q1);
            while(rs.next())
            {
            	System.out.println(rs.getString(1));
            }
            st.close();
            con.close();
        }
	 catch(SQLException e)
        {
            System.out.println(e.getMessage());    
        }
	}
}
