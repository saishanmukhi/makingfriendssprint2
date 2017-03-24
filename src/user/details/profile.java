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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		ArrayList arrayList = new ArrayList();
		uname = (String) session.getAttribute("uname");
		
		//String pname="";
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
            {String value =rs1.getString(1);
        	
        	System.out.println(value);
        	StringTokenizer str = new StringTokenizer(value,",");
        	while(str.hasMoreTokens()){
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
	 RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
     dispatcher.forward(request, response);
	      session.setAttribute("uname",uname);
		System.out.println("username in profile" + uname);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session1 = request.getSession();
		response.setContentType("text/html");
		//String username = request.getParameter("username").toString();
		//System.out.println(username);
		String name,email,address,password,cpassword;
		String[] hobbies = new String[20];
		name = request.getParameter("name").toString();
		email = request.getParameter("email").toString();
		address = request.getParameter("address").toString();
		password = request.getParameter("password").toString();
		cpassword = request.getParameter("confirmpassword").toString();
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
		}
		System.out.println(name);
		System.out.println(email);
		System.out.println(sports);
		System.out.println("password is " + password);
		update u = new update();
		u.updatedb(name, email,address, uname, password,cpassword, sports, animation, music, books, videogames, travel, fitness, boardgames, food, tvmovies, youtubemedia, arts);
		
	}

}
