import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeRegisteration extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String company = request.getParameter("company");
		String email = request.getParameter("email");
		int userID =Integer.parseInt(request.getParameter("uname"));
		String password = request.getParameter("psw");
		long phoneNumber =Long.parseLong(request.getParameter("phonenumber"));
		int scrtno=1;
		PrintWriter out=response.getWriter();
		//out.println(firstname+"--"+lastname+"--"+dob+"--"+company+"--"+email+"--"+userID+"--"+password+"--"+phoneNumber);
		int c=0;
		
		try
		{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String un="system";
		String pwd="navya";
		
		//connection establishment
		Class.forName("oracle.jdbc.OracleDriver");
		java.sql.Connection con=DriverManager.getConnection(url,un,pwd);
		//String status = dbBean.EmpRegistration(userID,password,firstname,lastname,dob,company,email,phoneNumber,1);
		String s="insert into emp(userid,password,firstname,lastname,dob,company,mailid,phno,secretno) values('"+userID+"','"+password+"','"+firstname+"','"+lastname+"','"+dob+"','"+company+"','"+email+"','"+phoneNumber+"','"+scrtno+"')";	
		PreparedStatement st=con.prepareStatement(s);
		c=st.executeUpdate();
		if(c==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("employee.html");
				rd.forward (request,response);
			}
			else
			{
				out.println("<b style=color:red>Invalid Crdentials</b><br>Please check ur details.");
				
				RequestDispatcher rd=request.getRequestDispatcher("/register.html");
				rd.include(request,response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
