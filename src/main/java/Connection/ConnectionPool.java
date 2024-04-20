package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionPool {
private static String userName ="root";
private static String userPass = "haha4540";
private static String driverName = "com.mysql.jdbc.Driver";
private static String connectionUrl="jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false";
public static Connection getConnection() throws ClassNotFoundException, SQLException
{
	Connection con ;
	
	Class.forName(driverName);
	con=DriverManager.getConnection(connectionUrl,userName,userPass);
	return con;
}
public static void close(Connection con)
{
	try
	{
		con.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
public static void rollBack(Connection con)
{
	try
	{
		con.rollback();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

public static void main(String[] args) {
	try {
		Connection con = ConnectionPool.getConnection();
		System.out.println("Ket noi ok ");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
