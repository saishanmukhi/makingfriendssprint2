package user.details;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList arrayList = new ArrayList();
		uname = (String) session.getAttribute("uname");
		
		try
		{
	        dbconnect db = new dbconnect();
			Connection con = db.connect();
	        Statement st1 = con.createStatement();  
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
                ") from interest where username='"+uname+"' ";
            
            ResultSet rs1 = st1.executeQuery(q2);
            while(rs1.next())
            {
            	String value =rs1.getString(1);
        	
            	System.out.println(value);
        	StringTokenizer str = new StringTokenizer(value,",");
        	while(str.hasMoreTokens())
        	{
        		String interestValues = str.nextToken();
        		System.out.println(interestValues);
                arrayList.add(interestValues);
               
                System.out.println(arrayList);    

        	}
        	session.setAttribute("arrayList", arrayList);
            }
            Statement st = con.createStatement();
            String q1 = "select name,email,dob,address,ppassword,cpassword from userdata where username ='"+uname+"'";
            ResultSet rs = st.executeQuery(q1);
            while(rs.next())
            {
            	String name1 = rs.getString("name");
            	System.out.println(name1);
            	session.setAttribute("pname",name1);
            	String email1 = rs.getString("email");
            	session.setAttribute("pemail",email1);
            	String dob1 = rs.getString("dob");
            	session.setAttribute("pdob",dob1);
            	String address1 = rs.getString("address");
            	session.setAttribute("paddress",address1);
            	String password1 = rs.getString("ppassword");
            	session.setAttribute("ppassword",password1);
            	String cpassword1 = rs.getString("cpassword");
            	session.setAttribute("cpassword",cpassword1);
            }
            st.close();
            st1.close();
	        con.close();       
	    }
	 	catch(SQLException e)
	    {
	        System.out.println(e.getMessage());    
	    }
		session.setAttribute("uname",uname);
	 RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
     dispatcher.forward(request, response);
	     // session.setAttribute("uname",uname);
		System.out.println("username in profile" + uname);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String returnPage="default.jsp";
		//HttpSession session1 = request.getSession();
		//response.setContentType("text/html");
		//String username = request.getParameter("username").toString();
		//System.out.println(username);
		String name,email,address,password,cpassword;
		name = request.getParameter("name").toString();
		email = request.getParameter("email").toString();
		address = request.getParameter("address").toString();
		password = request.getParameter("password").toString();
		cpassword = request.getParameter("confirmpassword").toString();
		int count = 0;
		int sports,animation,music,books,videogames,travel,fitness,boardgames,food,tvmovies,youtubemedia,arts;
		if(request.getParameter("sports") == null)
		{
		   //handle unchecked case
		   sports = 0;
		}
		else
		{
		   //handle checked case
		   sports = 1;
		   count++;
		}
		if(request.getParameter("animation") == null)
		{
		   //handle unchecked case
		   animation = 0;
		}
		else
		{
		   //handle checked case
		   animation = 1;
		   count++;
		}
		if(request.getParameter("music") == null)
		{
		   //handle unchecked case
		   music = 0;
		}
		else
		{
		   //handle checked case
		   music = 1;
		   count++;
		}
		if(request.getParameter("books") == null)
		{
		   //handle unchecked case
		   books = 0;
		}
		else
		{
		   //handle checked case
		   books = 1;
		   count++;
		}
		if(request.getParameter("videogames") == null)
		{
		   //handle unchecked case
			videogames = 0;
		}
		else
		{
		   //handle checked case
			videogames = 1;
			count++;
		}
		if(request.getParameter("travel") == null)
		{
		   //handle unchecked case
			travel = 0;
		}
		else
		{
		   //handle checked case
			travel = 1;
			count++;
		}
		if(request.getParameter("fitness") == null)
		{
		   //handle unchecked case
			fitness = 0;
		}
		else
		{
		   //handle checked case
			fitness = 1;
			count++;
		}
		if(request.getParameter("boardgames") == null)
		{
		   //handle unchecked case
			boardgames = 0;
		}
		else
		{
		   //handle checked case
			boardgames = 1;
			count++;
		}
		if(request.getParameter("food") == null)
		{
		   //handle unchecked case
			food = 0;
		}
		else
		{
		   //handle checked case
			food = 1;
			count++;
		}
		if(request.getParameter("tvmovies") == null)
		{
		   //handle unchecked case
			tvmovies = 0;
		}
		else
		{
		   //handle checked case
			tvmovies = 1;
			count++;
		}
		if(request.getParameter("youtubemedia") == null)
		{
		   //handle unchecked case
			youtubemedia = 0;
		}
		else
		{
		   //handle checked case
			youtubemedia = 1;
			count++;
		}
		if(request.getParameter("arts") == null)
		{
		   //handle unchecked case
			arts = 0;
		}
		else
		{
		   //handle checked case
			arts = 1;
			count++;
		}
		String wemail="",wname="",winterest="",waddress="",wpassword="";
		int checkcount = 0;
		System.out.println(count);
		System.out.println(name);
		System.out.println(uname);
		System.out.println(email);
		System.out.println(sports);
		System.out.println("password is " + password);
		validate p = new validate();
		if(p.validateEmail(email)==true)
		{
			System.out.println("email validated");
			wemail="";
			checkcount++;
		}
		else
		{
			wemail = "Invalid Email";
		}
		if(p.validateName(name)==true)
		{
			System.out.println("name validated");
			wname="";
			checkcount++;	
		}
		else
		{
			wname = "Invalid Name.";
		}
		if(address.equals(""))
		{
			waddress = "Address Required";
		}
		else
		{
			waddress = "";
			checkcount++;
			System.out.println("Address Validated");
		}
		boolean userpass = p.validatePassword(password);
		if(userpass == true)
		{
			System.out.println( "Password okay");
			if(password.equals(cpassword))
			{
				wpassword="";
				checkcount++;
				System.out.println("Password Validated");
			}
			else
			{
				wpassword="Password Mismatch";
			}
		}
		else
		{
			wpassword="Password Criteria not met Must Contain alphabet digit special character";
		}
		if(checkcount == 4)
		{
		if(count != 0)
		{
		update u = new update();
		u.updatedb(name, email,address, uname, password,cpassword, sports, animation, music, books, videogames, travel, fitness, boardgames, food, tvmovies, youtubemedia, arts);
		String pq = "Profile saved";
		request.setAttribute("updatedmessage",pq);
		request.setAttribute("uname", uname);
		response.sendRedirect("/home"); 
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
		}
		else
		{
			update u = new update();
			u.updatedb1(name,email,address,uname,password,cpassword);
			String pq = "Profile saved";
			request.setAttribute("updatedmessage",pq);
			request.setAttribute("uname", uname);
			response.sendRedirect("/home"); 
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
		    //dispatcher.forward(request, response);
		}
		}
		else
		{
			
			String error = wname + "\n" + wemail + "\n" + waddress + "\n" + wpassword;
            request.setAttribute("loginError",error);
           // RequestDispatcher dispatcher = request.getRequestDispatcher("/profile1.jsp");
    		//dispatcher.forward(request, response);
		}
		
	}

}
