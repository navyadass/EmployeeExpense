import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class validation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u="navya";
		String p="a022";
		PrintWriter out=response.getWriter();
		try{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String uname="system";
			String pwd="navya";
			//connection establishment
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,uname,pwd);
			//Retrieve Username and Password from Database
			PreparedStatement ps=con.prepareStatement("select * from manager where username=? and password=?");
			ps.setString(1, u);
			ps.setString(2,p);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				out.println("<h2><b>Login Successful</b></h2>");
				out.println("<br>Welcome "+rs.getString("username"));
			}
			else
			{
				out.println("<b style=color:red>Invalid Crdentials</b><br>Please check ur details.");
				ServletContext cx=getServletContext();
				RequestDispatcher rd=cx.getRequestDispatcher("/home.html");
				rd.include(request,response);
			}
		}catch(Exception e)
		{
			out.println("My Exception:"+e);
		}
	}

}
