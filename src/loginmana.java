


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginmana extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname=request.getParameter("uname");
		String psw=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		DBBean dbBean = new DBBean();
		String status = dbBean.ManagerLoginCheck(uname, psw);
		try{
			if(status.equalsIgnoreCase("success"))
			{
				ServletContext cx=getServletContext();
				RequestDispatcher rd=cx.getRequestDispatcher("/managerprofile.html");
				rd.include(request, response);
				ResultSet rs = dbBean.getManagerDetails();
				if(rs.next()){
				out.println("<br>Welcome "+rs.getInt("id"));
				out.println("<br>Name:"+rs.getString("name"));
				out.println("<br>Date Of Birth:"+rs.getDate("DOB"));
				out.println("<br>Mail Id:"+rs.getString("mailID"));
				out.println("<br>Phone Number:"+rs.getInt("phno"));
				out.println("<br>Phone Number:"+rs.getInt("salary"));
				}
				
			}
			else
			{
				out.println("<b style=color:red>Invalid Crdentials</b><br>Please check ur details.");
				
				RequestDispatcher rd=request.getRequestDispatcher("/manager.html");
				rd.include(request,response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
