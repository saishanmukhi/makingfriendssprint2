package user.details;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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
		validate v = new validate();
		if(v.validateDate(datex)==true)
		{
			System.out.println("date validated");
			if(v.validateFromTime(fromx, datex)==true)
			{
				System.out.println("from time validated");
				if(v.validateToTime(tox, datex)==true)
				{
					System.out.println("to time validated");
						Date d1=null,d2=null;
						SimpleDateFormat format = new SimpleDateFormat("hh:mm");
						try {
							d1 =format.parse(fromx);
							d2=format.parse(tox);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Long longNumber = (d1.getTime()-d2.getTime())/60;
						String strLong = Long.toString(longNumber);
						strLong.length();
						int p = Integer.parseInt(strLong.substring(1, (strLong.length()-3)));
						System.out.println(p);
						if(p>30)
						{
							
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
					            boolean up=false,ip=false;
					            if(insert==true)
					            {
					            	up = updatefreetime(uname,datex,fromx,tox);
					            	if(up)
					            	{
					            	System.out.println("updating time values");
					            	}
					           	
					            }
					            else
					            {
					            	ip=insertfreetime(uname,datex,fromx,tox);
					            	if(ip)
					            	{
					            	System.out.println("inserting time values");
					            	}
						       
					            }
					            
					            String pq = "Availability is set";
					    		session.setAttribute("available",pq);
					            session.setAttribute("uname", uname);
					    		RequestDispatcher dispatcher = request.getRequestDispatcher("/meet.jsp");
					    	    dispatcher.forward(request, response);
					    	    st1.close();
					  	        con.close();
							}
							catch(SQLException e)
							{
								System.out.println(e.getMessage());
							}
						}
						else
						{	System.out.println("value less than 30 min");
							String pq="Minimum time should be 30 minutes";
							session.setAttribute("mintime", pq);
							session.setAttribute("uname", uname);
							RequestDispatcher dispatcher = request.getRequestDispatcher("/settime.jsp");
						    dispatcher.forward(request, response);
						}
						
					}
					else
					{
						String pq="Set valid to time";
						session.setAttribute("totime", pq);
						session.setAttribute("uname", uname);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/settime.jsp");
					    dispatcher.forward(request, response);
					}
					
				}
			else
			{
				String pq="Set valid From time";
				session.setAttribute("fromtime", pq);
				session.setAttribute("uname", uname);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/settime.jsp");
			    dispatcher.forward(request, response);
			}
		}
		else
		{
			String pq="Select Valid Date";
			session.setAttribute("datetime", pq);
			session.setAttribute("uname", uname);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/settime.jsp");
		    dispatcher.forward(request, response);
		}
		
	}
	public boolean updatefreetime(String uname,String datex,String fromx,String tox)
	{
		boolean up1=false;
		try{
		dbconnect db = new dbconnect();
		Connection con = db.connect();
		String query = "update freetime set date1 = STR_TO_DATE(?,'%Y-%m-%d'),from1 = TIME_FORMAT(?,'%H:%i'),to1 = TIME_FORMAT(?,'%H:%i') where username = ?";
        java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1,datex);
        preparedStmt.setString(2,fromx);
        preparedStmt.setString(3,tox);
        preparedStmt.setString(4,uname);
        preparedStmt.executeUpdate();
        up1=true;
        preparedStmt.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return up1;
	}
	public boolean insertfreetime(String uname,String datex,String fromx,String tox)
	{
		boolean ip1=false;
		try{
			
			dbconnect db = new dbconnect();
			Connection con = db.connect();
			Statement st = con.createStatement();
	 	    String q1 = "insert into freetime values('"+uname+"',STR_TO_DATE('"+datex+"','%Y-%m-%d'),TIME_FORMAT('"+fromx+"','%H:%i'),TIME_FORMAT('"+tox+"','%H:%i'))";
	        st.executeUpdate(q1);
	        ip1=true;
            System.out.println("inserted freetime");
            st.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return ip1;
	}
}
