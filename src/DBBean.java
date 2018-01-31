import java.sql.*;
public class DBBean
{
Connection con;
Statement st;
ResultSet rs;
String status=" ";
int rowCount;
public DBBean()
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","navya");
st=con.createStatement();
}
catch(Exception e)
{
e.printStackTrace();
}	
}

public String ManagerLoginCheck(String ulogin,String upwd)
{
try
{
rs=st.executeQuery("select * from manager where id='"+ulogin+"' and password='"+upwd+"'");
boolean b=rs.next();
if(b==true)
{
status="success";
}
else
{
status="failure";
}
}
catch(Exception e)
{
e.printStackTrace();
}
return status;
}
public String BCheckLogin(String ulogin,String upwd)
{
try
{
rs=st.executeQuery("select * from BankingOfficers where name='"+ulogin+"' and password='"+upwd+"'");
boolean b=rs.next();
if(b==true)
{
status="success";
}
else
{
status="failure";
}
}
catch(Exception e)
{
e.printStackTrace();
}
return status;
}
public String registration(String ulogin,String upwd,String uemail,long uphonenumber,String udob,String uaddress,int ubranchcode, String ubranchname)
		{
			try
			{
				rs=st.executeQuery("select * from BankingOfficers where name='"+ulogin+"' and  password='"+upwd+"'");
				boolean b=rs.next();
				if(b==true)
				{
					status="existed";
				}
				else
				{
					int rowCount=st.executeUpdate("insert into BankingOfficers(name,password,emailid,phonenumber,dob,address,branchcode,branchname) values('"+ulogin+"','"+upwd+"','"+uemail+"','"+uphonenumber+"','"+udob+"','"+uaddress+"','"+ubranchcode+"','"+ubranchname+"')");
					if(rowCount==1)
					{
						status="success";
					}
					else
					{
						status="failure";
					}
				}
			}
			catch(Exception e)
			{
				status="failure";
				e.printStackTrace();
			}
			return status;
		}

public String EmpRegistration(int userid,String pass,String fname,String lname,String dob, String company,String mailid,long phonenumber,int scrtno)
		{
			try
			{

					 rowCount=st.executeUpdate("insert into emp(userid,password,firstname,lastname,dob,company,mailid,phno,secretno) values('"+userid+"','"+pass+"','"+fname+"','"+lname+"','"+dob+"','"+company+"','"+mailid+"','"+phonenumber+"','"+scrtno+"')");
					if(rowCount==1)
					{
						status="success";
					}
					else
					{
						status="failure";
					}
				
			}
			catch(Exception e)
			{
				status="failure";
				e.printStackTrace();
			}
			return status;
		}

public ResultSet getManagerDetails()

{

	try
	{ 			
		rs=st.executeQuery("select * from manager");
		

	}
	catch(Exception e)
	{
		status="failure";
		e.printStackTrace();
	}
	return rs;
}
}