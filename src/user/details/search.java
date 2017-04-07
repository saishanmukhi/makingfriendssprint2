package user.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		uname = (String) session.getAttribute("uname");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try
		{
			dbconnect db = new dbconnect();
			Connection con = db.connect();
			Statement st = con.createStatement();
            String q1 = "select date1,from1,to1 from freetime where username = '"+uname+"'";
            ResultSet rs = st.executeQuery(q1);
            String date2="";
            Time from1=null,to1 = null;
            while(rs.next())
            {
            	date2 =rs.getString(1);
            	from1 = rs.getTime(2);
            	to1 = rs.getTime(3);
               // Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date2);
            }
            System.out.println(date2 + from1 + to1);
            Statement st1 = con.createStatement();
            String q2 = "select username from freetime where date1 = '"+date2+"' and ((from1 >= '"+from1+"' and to1 <= '"+to1+"') or (from1 > '"+from1+"' and from1 < '"+to1+"' and to1 > '"+to1+"') or (from1 < '"+from1+"' and to1 > '"+from1+"'))";
            ResultSet rs1 = st1.executeQuery(q2);
            while(rs1.next())
            {
            	//rs1.getString(1);
            	System.out.println(rs1.getString(1));
            }
		}
		catch(SQLException e)
        {
            System.out.println(e.getMessage());    
        }
	}

}
