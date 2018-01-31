package in.ac.vce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manag
 */
@WebServlet("/ma")
public class Manag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manag() {
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
		PrintWriter o=response.getWriter();
		
		response.setContentType("text/html");
		
		ServletContext cx=getServletContext();
        
		try{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			String un="system";
			String pwd="amma414";
			
			//connection establishment
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection con=DriverManager.getConnection(url,un,pwd);
			String dq="SELECT * FROM status8";
		PreparedStatement po1 = con.prepareStatement(dq);
		ResultSet rs=po1.executeQuery();
		String title="MANAGER";
		o.println("<html>");
		o.println("<head>");
	    o.println("<title>" + title + "</title>");
	    o.println("</head>");
		o.println("<body>");
		o.println("<form action=s method=post>");
		o.println("<pre>EMPLOYEE ID     SERIALNO.    AMOUNT    STATUS</pre>");
		int i=1;
		int j=11;
		int k=21;
		int r=31;
		String a="ACCEPT";
		String re="REJECT";
		String di="DONE";
		int a1=0, b=0, c=0;
		while(rs.next() && i!=0 && j!=0 && k!=0 && r!=0)
		{	i++;
		j++;
		k++;
		r++;
			a1=rs.getInt(1);
			b=rs.getInt(2);
			c=rs.getInt(3);
			
			o.println("<input type=text  name=" +i+ "  id=" +i+ " value=" +a1+ ">");
			o.println("&nbsp&nbsp&nbsp");
			o.println("<input type=text  name=" +j+ "  id=" +j+ " value=" +b+ ">");
			o.println("&nbsp&nbsp&nbsp");
			o.println("<input type=text  name=" +k+ "  id=" +k+ " value=" +c+ ">");
			o.println("&nbsp&nbsp&nbsp");
			o.println("<input type=radio id=" +r+ " name=" +r+ " value=" +a+ ">ACCEPT&nbsp");
			o.println("<input type=radio id=" +r+ " name=" +r+ " value=" +re+ ">REJECT<br>");
			
			}
		String x="t1";
		String y="t2";
		String z="t3";
		String v="t4";
		
		o.println("<input type=hidden name=" +x+ " value=" +i+ " >");
		o.println("<input type=hidden name=" +y+ " value=" +j+ " >");
		o.println("<input type=hidden name=" +z+ " value=" +k+ " >");
		o.println("<input type=hidden name=" +v+ " value=" +r+ " >");
		
		o.println("<input type=submit value=" +di+ ">");
		
		}catch(Exception e)
		{
			o.println("MyException" +e);
		}
		}
	}


