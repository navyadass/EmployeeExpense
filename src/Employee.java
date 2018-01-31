package in.ac.vce;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Employee
 */
@WebServlet("/mm")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee() {
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
		String n=request.getParameter("uname");
		String p=request.getParameter("pass");
		PrintWriter o=response.getWriter();
		response.setContentType("text/html");
		//o.println(n);
		//o.println(p);
		
		try{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			String un="system";
			String pwd="amma414";
			//connection establishment
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection con=DriverManager.getConnection(url,un,pwd);
			//o.println(con);
			
			
			ServletContext cx=getServletContext();
			
			String selectSQL = "SELECT * FROM emporig WHERE userid= ? and password=?";
			PreparedStatement pq = con.prepareStatement(selectSQL);
			int net=Integer.parseInt(n);
			pq.setInt(1, net);
			pq.setString(2,  p);
			
			ResultSet rs = pq.executeQuery();
			
			/*while (rs.next()) 
			{
				int us = rs.getInt("userid");
				String pss = rs.getString("password");
				String fn=rs.getString("firstn");
				String ln=rs.getString("lastn");
				String dobb=rs.getString("dob");
				String com=rs.getString("company");
				String mid=rs.getString("mailid");
				float pno=rs.getFloat("phno");
				int sno=rs.getInt("secretno");
				o.println("USERID"+us);
				o.println("PASSWORD"+pss);
				o.println("FIRSTNAME"+fn);
				o.println("LASTNAME"+ln);
				o.println("DATE OF BIRTH"+dobb);
				o.println("COMPANY"+com);
				o.println("MAIL ID"+mid);
				o.println("PHONE NO>"+pno);
				o.println("SECRET NO>"+sno);
				
			}*/
			boolean h=rs.next();
			
			if(h!=false)
			{
				int sno=rs.getInt("secretno");
				HttpSession session=request.getSession(true);  
		        session.setAttribute("user",n);
		        o.println("<br><b style=color:black>EMPLOYEE ID:</b>"  + n);
		        o.println("<br><b style=color:black>SERIAL NO:</b>"+ sno);
		        
		        RequestDispatcher rd=cx.getRequestDispatcher("/table.html");
				rd.include(request,response);
			}
			else
			{
				RequestDispatcher rd1=cx.getRequestDispatcher("/index.html");
				rd1.include(request, response);
			}
		          
		        

		      

		      // Clean-up environment
		      rs.close();
		      
		      con.close();

			
			
		}catch(Exception e)
		{
			o.println("My exception"+e);
		}
	}

}
