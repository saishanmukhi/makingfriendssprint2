package user.details;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class validate {

		public  boolean validateEmail(String email)
	    {
			String front;
			String end;
			boolean check = false;
			int index = 0;
			if(email.contains("@"))
			{
				index = email.indexOf("@");
				end = email.substring(index, email.length());
				if(end.equals("@uncc.edu"))
				{
					front = email.substring(0, index);
					if(front.matches("[a-zA-Z_0-9]+"))
					{
						check = true;
					}
				}
			}
			return check;
	    }
		public boolean validateName(String name)
		{
			boolean check = false;
			if(name.matches("[a-zA-Z]+"))
				check = true;
			return check;
		}
		public boolean validateBirthDate(String birthDate)
		{
			boolean check = false;		
			
			if(birthDate.matches("\\d{2}/\\d{2}/\\d{4}"))
			{
				int m = Integer.parseInt(birthDate.substring(0, 2));
				int d = Integer.parseInt(birthDate.substring(3, 5));
				int y = Integer.parseInt(birthDate.substring(6, birthDate.length()));
				if(m >= 1 && m <= 12 && y >= 1900 && y <= 2000)
				{
					if(d >= 1 && d <= dayInMonth(y, m))
						check = true;
				}
			}
			return check;
		}
		private static int dayInMonth(int year, int month)
		{
			int day = 31;
			if(year % 4 == 0)
			{
				if(month == 2)
					day = 29;
			}
			else
			{
				if(month == 2)
					day = 28;
			}
			if(month ==  4 || month == 6 || month ==  9 || month == 11)
				day = 30;
			return day;
		}
		public boolean validateusername(String uname)
		{
			String uname1 =uname;
			
		 try
	        {
			 	dbconnect db = new dbconnect();
				Connection con = db.connect();
	           // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","mylife@123");
	            Statement st = con.createStatement();
	            String q1 = "select username from userdata where username ='"+uname1+"'";
	            ResultSet rs = st.executeQuery(q1);
	            while(rs.next())
	            {
	            	return true;
	            }
	            st.close();
	            con.close();
	        }
		 catch(SQLException e)
	        {
	            System.out.println(e.getMessage());    
	        }
		 return false;
		}
		public boolean validatePassword(String password)
		{
			Pattern regex1 = Pattern.compile("[$&!+,:;=?@#|]");
			Pattern regex2 = Pattern.compile("[a-z]");
			Pattern regex3 = Pattern.compile("[0-9]");
			Matcher matcher1 = regex1.matcher(password);
			Matcher matcher2 = regex2.matcher(password);
			Matcher matcher3 = regex3.matcher(password);
			
			boolean check = false;
			if(password.length() >= 7 && password.length() <= 12)
			{
				if(matcher1.find() && matcher2.find() && matcher3.find() && password.matches("[^\\s]+"))
				{
					check = true;
				}
			}
			return check;
		}
}
