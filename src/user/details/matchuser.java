package user.details;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class matchuser
 */
@WebServlet("/matchuser")
public class matchuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname;
	HashMap<String, Integer> hmap;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public matchuser() {
        super();
        hmap = new HashMap<String, Integer>();
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
		/*int count;
		String value = null;
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		 
		ArrayList<String> list2 = new ArrayList<String>();
		try
		{
			dbconnect db = new dbconnect();
			Connection con = db.connect();
			Statement st3 = con.createStatement();  
	        String q4 = "select concat_ws(\",\", (case when sports = 1 then 'sports' end),\n" +
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
	        ResultSet rs3 = st3.executeQuery(q4);
            while(rs3.next())
            {
           	 
            	value =rs3.getString(1);
            	StringTokenizer str = new StringTokenizer(value,",");
            	while(str.hasMoreTokens())
            	{
            		String interestValues = str.nextToken();
            		System.out.println(interestValues);
            		list1.add(interestValues);        
            	}
            	 System.out.println("list of user logged in " + list1);
            }
            st3.close();
           Statement st = con.createStatement();
            String q1 = "select count(username)from userdata where username != '"+uname+"'";
            ResultSet rs = st.executeQuery(q1);
            while(rs.next())
            {
            	count = rs.getInt(1);
            	System.out.println(count);
            	Statement st1 = con.createStatement();
                String q2 = "select username from userdata where username != '"+uname+"'";
                ResultSet rs1 = st1.executeQuery(q2);
                while(rs1.next())
                {
                	String pname = rs1.getString(1);
                 	//System.out.println(pname);
                 	Statement st2 = con.createStatement();  
         	        String q3 = "select concat_ws(\",\", (case when sports = 1 then 'sports' end),\n" +
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
                         ") from interest where username='"+pname+"' ";
         	         ResultSet rs2 = st2.executeQuery(q3);
         	         while(rs2.next())
         	         {
         	    	   		list = new ArrayList<String>();
         	    	   		value =rs2.getString(1);
         	    	   		StringTokenizer str = new StringTokenizer(value,",");
         	    	   		while(str.hasMoreTokens())
         	    	   		{
         	    	   			String interestValues = str.nextToken();
         	    	   			//System.out.println(interestValues);
         	    	   			list.add(interestValues); 
         	    	   		}
         	    	   		list2.addAll(list1);
         	    	   		//System.out.println("list of users is " + list);
         	    	   		list2.retainAll(list);
         	    	   		//System.out.println("list1 is" + list2.size());
         	    	   		if(list2.size()!=0)
         	    	   		{
         	    	   			hmap.put(pname, list2.size());
         	    	   		}
         	    	   		
         	            	list2.clear();
           	         	}
         	         	st2.close();
                	}
                	System.out.println(hmap);
                	st1.close();
            }
            st.close();
            
            con.close();*/
            hmap = getUser(uname);
            System.out.println("returned");
            Map<Integer, String> map = sortByValues(hmap); 
      	  	System.out.println("After Sorting:");
      	  	Set set2 = map.entrySet();
      	  	Iterator iterator2 = set2.iterator();
      	  	while(iterator2.hasNext()) 
      	  	{
                Map.Entry me2 = (Map.Entry)iterator2.next();
                System.out.print(me2.getKey() + ": ");
                System.out.println(me2.getValue());
                
           }
      	  if((map.isEmpty())==false)
      	  {
      	  session.setAttribute("map",map);
      	 session.setAttribute("uname",uname);
      	 RequestDispatcher dispatcher = request.getRequestDispatcher("/match.jsp");
	     dispatcher.forward(request, response);
      	  }
      	  else
      	  {
      		session.setAttribute("uname",uname);
      		RequestDispatcher dispatcher = request.getRequestDispatcher("/nomatch.jsp");
   	     dispatcher.forward(request, response);
      	  }
		
		//}
		/*catch(SQLException e)
        {
            System.out.println(e.getMessage());    
        }*/
		
	}
	private static HashMap sortByValues(HashMap map) { 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o2)).getValue())
	                  .compareTo(((Map.Entry) (o1)).getValue());
	            }
	       });
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	 }
	public HashMap<String, Integer> getUser(String uname)
	{
		System.out.println("inside hashmap");
		uname=uname;
		int count;
		String value = null;
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		 
		ArrayList<String> list2 = new ArrayList<String>();
		try
		{
			dbconnect db = new dbconnect();
			Connection con = db.connect();
			Statement st3 = con.createStatement();  
	        String q4 = "select concat_ws(\",\", (case when sports = 1 then 'sports' end),\n" +
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
	        ResultSet rs3 = st3.executeQuery(q4);
            while(rs3.next())
            {
           	 
            	value =rs3.getString(1);
            	StringTokenizer str = new StringTokenizer(value,",");
            	while(str.hasMoreTokens())
            	{
            		String interestValues = str.nextToken();
            		System.out.println(interestValues);
            		list1.add(interestValues);        
            	}
            	 System.out.println("list of user logged in " + list1);
            }
            st3.close();
           Statement st = con.createStatement();
            String q1 = "select count(username)from userdata where username != '"+uname+"'";
            ResultSet rs = st.executeQuery(q1);
            while(rs.next())
            {
            	count = rs.getInt(1);
            	System.out.println(count);
            	Statement st1 = con.createStatement();
                String q2 = "select username from userdata where username != '"+uname+"'";
                ResultSet rs1 = st1.executeQuery(q2);
                while(rs1.next())
                {
                	String pname = rs1.getString(1);
                 	//System.out.println(pname);
                 	Statement st2 = con.createStatement();  
         	        String q3 = "select concat_ws(\",\", (case when sports = 1 then 'sports' end),\n" +
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
                         ") from interest where username='"+pname+"' ";
         	         ResultSet rs2 = st2.executeQuery(q3);
         	         while(rs2.next())
         	         {
         	    	   		list = new ArrayList<String>();
         	    	   		value =rs2.getString(1);
         	    	   		StringTokenizer str = new StringTokenizer(value,",");
         	    	   		while(str.hasMoreTokens())
         	    	   		{
         	    	   			String interestValues = str.nextToken();
         	    	   			//System.out.println(interestValues);
         	    	   			list.add(interestValues); 
         	    	   		}
         	    	   		list2.addAll(list1);
         	    	   		//System.out.println("list of users is " + list);
         	    	   		list2.retainAll(list);
         	    	   		//System.out.println("list1 is" + list2.size());
         	    	   		if(list2.size()!=0)
         	    	   		{
         	    	   			hmap.put(pname, list2.size());
         	    	   		}
         	    	   		
         	            	list2.clear();
           	         	}
         	         	st2.close();
                	}
                	System.out.println(hmap);
                	st1.close();
            }
            st.close();
            
            con.close();
		}
		catch(SQLException e)
        {
            System.out.println(e.getMessage());    
        }
		return hmap ;
	}
}

