package in.ac.vce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manac
 */
@WebServlet("/s")
public class Manac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manac() {
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
		
		//ServletContext cx=getServletContext();
        
		try{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			String un="system";
			String pwd="amma414";
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection con=DriverManager.getConnection(url,un,pwd);
			String a1=request.getParameter("t1");
			String a2=request.getParameter("t2");
			String a3=request.getParameter("t3");
			String a4=request.getParameter("t4");
			
			int b1=Integer.parseInt(a1);
			int b2=Integer.parseInt(a2);
			int b3=Integer.parseInt(a3);
			int b4=Integer.parseInt(a4);
			o.println(b1);
			o.println(b2);
			o.println(b3);
			o.println(b4);
			
			/*int a=2, b=12, c=22, d=32; 
			String  x= Integer.toString(a);
		    String  y= Integer.toString(b);
		    String  z= Integer.toString(c);
		    String  v= Integer.toString(d);
		    
			String emp = request.getParameter(x);
			String ser= request.getParameter(y);
			String amt= request.getParameter(z);
			String stat= request.getParameter(v);
			o.println(emp);
			o.println(ser);
			o.println(amt);
			o.println(stat);
			if(stat.equals("ACCEPT"))
			{
			String df="UPDATE status SET statuss=? where userid=? and secretno=?";
			
			PreparedStatement po = con.prepareStatement(df);
			int s1=Integer.parseInt(emp);
			int s2=Integer.parseInt(ser);
			po.setString(1, "ACCEPT");
			po.setInt(2, s1);
			po.setInt(3,  s2);
			po.executeUpdate();
			}
			else if(stat.equals("REJECT"))
				
		{String df="UPDATE status SET statuss=? where userid=? and secretno=?";
		
		PreparedStatement po = con.prepareStatement(df);
		int s1=Integer.parseInt(emp);
		int s2=Integer.parseInt(ser);
		po.setString(1, "REJECT");
		po.setInt(2, s1);
		po.setInt(3,  s2);
		po.executeUpdate();
				
			}*/
			
			
			
			
			//connection establishment
			
			for(int a=2, b=12, c=22, d=32; (a<=b1 && b<=b2 && c<=b3 && d<=b4); a++, b++, c++, d++)
			{
			String  x= Integer.toString(a);
		    String  y= Integer.toString(b);
		    String  z= Integer.toString(c);
		    String  v= Integer.toString(d);
		    
			String emp = request.getParameter(x);
			String ser= request.getParameter(y);
			String amt= request.getParameter(z);
			String stat= request.getParameter(v);
			if(stat.equals("ACCEPT"))
			{
			String df="UPDATE status8 SET statuss=? where userid=? and secretno=?";
			
			PreparedStatement po = con.prepareStatement(df);
			int s1=Integer.parseInt(emp);
			int s2=Integer.parseInt(ser);
			po.setString(1, "ACCEPT");
			po.setInt(2, s1);
			po.setInt(3, s2);
			po.executeUpdate();
			}
			else if(stat.equals("REJECT"))
				
		{String df="UPDATE status8 SET statuss=? where userid=? and secretno=?";
		
		PreparedStatement po = con.prepareStatement(df);
		int s1=Integer.parseInt(emp);
		int s2=Integer.parseInt(ser);
		po.setString(1, "REJECT");
		po.setInt(2, s1);
		po.setInt(3,  s2);
		po.executeUpdate();
				
			}
			
			}
			
			
			}catch(Exception e)
			{o.println("My Exception"+e);
			}
		
	}

}
