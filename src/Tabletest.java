package in.ac.vce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Tabletest
 */
@WebServlet("/ta")
public class Tabletest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tabletest() {
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
		String action = request.getParameter("action");
		response.setContentType("text/html");
		int ssn=0;
		ServletContext cx=getServletContext();
        
		try{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			String un="system";
			String pwd="amma414";
			
			//connection establishment
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection con=DriverManager.getConnection(url,un,pwd);
			if ("ADD VOUCHER".equals(action)) 
			{
				HttpSession session=request.getSession(false);
				Object ob=session.getAttribute("user");
				
				String us=ob.toString();
				int uk=Integer.parseInt(us);
				//o.println(uk);
				
				String selectSQL = "SELECT * FROM emporig WHERE userid= ?";
				PreparedStatement pq = con.prepareStatement(selectSQL);
				
				pq.setInt(1,uk);
				ResultSet rs = pq.executeQuery();
				
				if(rs.next())
				{ ssn=rs.getInt("secretno");
				//String  x= Integer.toString(ssn);
				//o.println(ssn);
				}
				
				
				
				
				
			for( int m=1, n=11, l=21, p=31, q=41; (m<=5 && n<=15&& l<=25&& p<=35&& q<=45) ; m++, n++, l++, p++, q++)
				{	String  x= Integer.toString(q);
				    String  y= Integer.toString(m);
				    String  z= Integer.toString(n);
				    String  v= Integer.toString(l);
				    String  w= Integer.toString(p);
					String seqno = request.getParameter(x);
					String vono= request.getParameter(y);
					String da= request.getParameter(z);
					String tp= request.getParameter(v);
					String a= request.getParameter(w);
					String selects = "INSERT INTO voucher88 (userid, secretno, " + 
	                    "sequenceno, voucherno,datee, typeofdbill,amount)" +
	                    " VALUES(?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(selects);
				int sq=Integer.parseInt(seqno);
				int vo=Integer.parseInt(vono);
				int amt=Integer.parseInt(a);
				
				ps.setInt(1, uk);
				ps.setInt(2,ssn);
				ps.setInt(3, sq);
				ps.setInt(4, vo);
				ps.setString(5, da);
				ps.setString(6, tp);
				ps.setInt(7, amt);
				ps.executeUpdate();
				}
			String tot=request.getParameter("agtotal");
			int t=Integer.parseInt(tot);
			String st="pending";
			String dq="INSERT INTO status8 (userid, secretno, " + 
	                    "amount, statuss)" +
	                    " VALUES(?,?,?,?)";
			PreparedStatement po1 = con.prepareStatement(dq);
			po1.setInt(1,uk);
			po1.setInt(2,ssn);
			po1.setInt(3,t);
			po1.setString(4,st);
			po1.executeUpdate();
			
			
				String d="update emporig set secretno=? where userid=?";
				int ss1=ssn+1;
				PreparedStatement po = con.prepareStatement(d);
				po.setInt(1, ss1);
				po.setInt(2,uk);
				o.println("<br><b style=color:black>EMPLOYEE ID:</b>"  + uk);
		        o.println("<br><b style=color:black>SERIAL NO:</b>"+ ss1);
		        po.executeUpdate();
		        
		        RequestDispatcher rd=cx.getRequestDispatcher("/table.html");
				rd.include(request,response);
				
				
				
				
				
				
				}
		
			    
			 else if ("SUBMIT".equals(action)) {
				 HttpSession session=request.getSession(false);
					Object ob=session.getAttribute("user");
					
					String us=ob.toString();
					int uk=Integer.parseInt(us);
					//o.println(uk);
					
					String selectSQL = "SELECT * FROM emporig WHERE userid= ?";
					PreparedStatement pq = con.prepareStatement(selectSQL);
					
					pq.setInt(1,uk);
					ResultSet rs = pq.executeQuery();
					
					if(rs.next())
					{ ssn=rs.getInt("secretno");
					//String  x= Integer.toString(ssn);
					//o.println(ssn);
					}
					
					
					
				for( int m=1, n=11, l=21, p=31, q=41; (m<=5 && n<=15&& l<=25&& p<=35&& q<=45) ; m++, n++, l++, p++, q++)
					{	String  x= Integer.toString(q);
					    String  y= Integer.toString(m);
					    String  z= Integer.toString(n);
					    String  v= Integer.toString(l);
					    String  w= Integer.toString(p);
						String seqno = request.getParameter(x);
						String vono= request.getParameter(y);
						String da= request.getParameter(z);
						String tp= request.getParameter(v);
						String a= request.getParameter(w);
						String selects = "INSERT INTO voucher88 (userid, secretno, " + 
		                    "sequenceno, voucherno,datee, typeofdbill,amount)" +
		                    " VALUES(?,?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(selects);
					int sq=Integer.parseInt(seqno);
					int vo=Integer.parseInt(vono);
					int amt=Integer.parseInt(a);
					
					ps.setInt(1, uk);
					ps.setInt(2,ssn);
					ps.setInt(3, sq);
					ps.setInt(4, vo);
					ps.setString(5, da);
					ps.setString(6, tp);
					ps.setInt(7, amt);
					ps.executeUpdate();
					}
				String tot=request.getParameter("agtotal");
				int t=Integer.parseInt(tot);
				String st="pending";
				String dq="INSERT INTO status8 (userid, secretno, " + 
		                    "amount, statuss)" +
		                    " VALUES(?,?,?,?)";
				PreparedStatement po1 = con.prepareStatement(dq);
				po1.setInt(1,uk);
				po1.setInt(2,ssn);
				po1.setInt(3,t);
				po1.setString(4,st);
				po1.executeUpdate();
				
				
					String d="UPDATE emporig SET secretno=? where userid=?";
					int ss1=ssn+1;
					PreparedStatement po = con.prepareStatement(d);
					po.setInt(1, ss1);
					po.setInt(2,uk);
					po.executeUpdate();
					/*String d="update emorig set secretno=? where userid=?";
					int ss1=ssn+1;
					PreparedStatement po = con.prepareStatement(d);
					po.setInt(1, ss1);
					po.setInt(2,uk);
					o.println("<br><b style=color:black>EMPLOYEE ID:</b>"  + uk);
			        o.println("<br><b style=color:black>SERIAL NO:</b>"+ ss1);*/
			        
			        RequestDispatcher rd=cx.getRequestDispatcher("/sum.html");
					rd.forward(request,response);
					
					
				 
			}
		}catch(Exception e)
		{ o.println("My Exception" +e);
		}

		
	}

}
