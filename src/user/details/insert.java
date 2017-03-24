package user.details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import user.details.reg;
public class insert 
{
	
	public void insertdb(String name,String email,String dateofbirth,String address,String username,String password,String cpassword,int sports,int animation,int music,int books,int videogames,int travel,int fitness,int boardgames,int food,int tvmovies,int youtubemedia,int arts)
	{
		try
		{
		dbconnect db = new dbconnect();
		Connection con = db.connect();
		Statement st = con.createStatement();
        String q1 = "insert into userdata values('"+name+"','"+email+"','"+dateofbirth+"','"+address+"','"+username+"','"+password+"','"+cpassword+"')";
        st.executeUpdate(q1);
        String q2 ="insert into interest values('"+username+"',"+sports+","+animation+","+music+","+books+","+videogames+","+travel+","+fitness+","+boardgames+","+food+","+tvmovies+","+youtubemedia+","+arts+")";
        st.executeUpdate(q2);
        System.out.println("inserted");
        st.close();
        con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
    }

}
