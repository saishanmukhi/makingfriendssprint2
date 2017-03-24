package user.details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import user.details.reg;
public class update
{
	
	public void updatedb(String name,String email,String address,String uname,String password,String cpassword,int sports,int animation,int music,int books,int videogames,int travel,int fitness,int boardgames,int food,int tvmovies,int youtubemedia,int arts)
	{
	
	try
    {
        Class.forName("com.mysql.jdbc.Driver");
    }
    catch(ClassNotFoundException e)
    {
        System.out.println(e.getMessage());
    }
 try
    {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","mylife@123");
        String query = "update userdata set name = ?,email = ?,address = ?,ppassword = ?,cpassword = ? where username = ?";
        java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1,name);
        preparedStmt.setString(2,email);
        preparedStmt.setString(3,address);
        preparedStmt.setString(4,password);
        preparedStmt.setString(5,cpassword);
        preparedStmt.setString(6,uname);
        preparedStmt.executeUpdate();
        preparedStmt.close();
        String query1 = "update interest set sports = ?,animation = ?,music = ?,books = ?,videogames = ?,travel = ?,fitness = ?,boardgames = ?,food = ?,tvmovies = ?,youtubemedia = ?,arts = ? where username = ?";
        java.sql.PreparedStatement preparedStmt1 = con.prepareStatement(query1);
        preparedStmt1.setInt(1,sports);
        preparedStmt1.setInt(2,animation);
        preparedStmt1.setInt(3,music);
        preparedStmt1.setInt(4,books);
        preparedStmt1.setInt(5,videogames);
        preparedStmt1.setInt(6,travel);
        preparedStmt1.setInt(7,fitness);
        preparedStmt1.setInt(8,boardgames);
        preparedStmt1.setInt(9,food);
        preparedStmt1.setInt(10,tvmovies);
        preparedStmt1.setInt(11,youtubemedia);
        preparedStmt1.setInt(12,arts);
        preparedStmt1.setString(13,uname);
        preparedStmt1.executeUpdate();
        System.out.println("updated interest");
        preparedStmt1.close();
        con.close();
    }
 catch(SQLException e)
    {
        System.out.println(e.getMessage());    
    }
	}

}