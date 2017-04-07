package user.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class timeinsert
 */
@WebServlet("/timeinsert")
public class timeinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timeinsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String datex = request.getParameter("date1").toString();
		String fromx = request.getParameter("from").toString();
		String tox = request.getParameter("to").toString();
		System.out.println(datex + fromx + tox);
		boolean insert=false;
		try
		{
			dbconnect db = new dbconnect();
			Connection con = db.connect();
			Statement st1 = con.createStatement();
			String q2 = "select username from freetime where username='"+uname+"'";
			ResultSet rs1 = st1.executeQuery(q2);
            while(rs1.next())
            {
            	insert=true;
            	
            }
            if(insert==true)
            {
            	System.out.println("updating time values");
           	 String query = "update freetime set date1 = STR_TO_DATE(?,'%Y-%m-%d'),from1 = TIME_FORMAT(?,'%H:%i'),to1 = TIME_FORMAT(?,'%H:%i') where username = ?";
                java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1,datex);
                preparedStmt.setString(2,fromx);
                preparedStmt.setString(3,tox);
                preparedStmt.setString(4,uname);
                preparedStmt.executeUpdate();
                preparedStmt.close();
            }
            else
            {
            	System.out.println("inserting time values");
	        Statement st = con.createStatement();
	 	    String q1 = "insert into freetime values('"+uname+"',STR_TO_DATE('"+datex+"','%Y-%m-%d'),TIME_FORMAT('"+fromx+"','%H:%i'),TIME_FORMAT('"+tox+"','%H:%i'))";
	        st.executeUpdate(q1);
            System.out.println("inserted freetime");
            st.close();
            }
            String pq = "Availability is set";
    		request.setAttribute("available",pq);
            request.setAttribute("uname", uname);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
    	    dispatcher.forward(request, response);
    	    st1.close();
  	        con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
