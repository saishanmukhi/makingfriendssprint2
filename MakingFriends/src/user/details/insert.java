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
	public String selectdb(String username2)
	{
		String testname="";
		dbconnect db = new dbconnect();
		Connection con = db.connect();
		try
		{
		Statement st1 = con.createStatement();
		String q2 = "select name from userdata where username = '"+username2+"'";
		ResultSet rs = st1.executeQuery(q2);
		while(rs.next())
		{
			testname = rs.getString("name");
			System.out.println(testname);
			return testname;
		}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return testname;
		
	}
	public String selectdb1(String username1)
	{
		String testinterest="";
		dbconnect db = new dbconnect();
		Connection con = db.connect();
		try
		{
		Statement st2 = con.createStatement();
		String q2 = "select concat_ws(\",\", (case when sports = 1 then 'sports' end),\n" +
                " (case when animation = 1 then 'animation' end),\n" +
                " (case when music = 1 then 'music' end),\n" +
                 " (case when books = 1 then 'books' end)," +
                 " (case when videogames = 1 then 'videogames' end)," +
                 " (case when travel = 1 then 'travel' end),"+
                 " (case when fitness = 1 then 'fitness' end),"+
                 " (case when boardgames = 1 then 'boardgames' end),"+
                 " (case when food = 1 then 'food' end),"+
                 " (case when tvmovies = 1 then 'tvmovies' end),"+
                 " (case when youtubemedia = 1 then 'youtubemedia' end),"+
                 " (case when arts = 1 then 'arts' end)"+
                ") from interest where username='"+username1+"' ";
		ResultSet rs1 = st2.executeQuery(q2);
		while(rs1.next())
		{
			testinterest = rs1.getString(1);
			System.out.println(testinterest);
			return testinterest;
		}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return testinterest;
		
	}
	

}
