package user.details;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class profile1
 */
@WebServlet("/profile1")
public class profile1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String uname = (String) request.getAttribute("uname");
		//String uname = request.getParameter("username").toString();
		System.out.println("uname in profile 1 " + uname);
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
		request.setAttribute("updatedmessage", "Profile is edited and saved");
		request.setAttribute("uname", uname);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
	      dispatcher.forward(request, response);
		}
		else
		{
			update u = new update();
			u.updatedb1(name,email,address,uname,password,cpassword);
			request.setAttribute("updatedmessage", "Profile is edited and saved");
		request.setAttribute("uname", uname);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
		      dispatcher.forward(request, response);
		}
		}
		else
		{
			
			String error = wname + "\n" + wemail + "\n" + waddress + "\n" + wpassword;
            request.setAttribute("loginError",error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/profile1.jsp");
    		dispatcher.forward(request, response);
		}
	}

}
