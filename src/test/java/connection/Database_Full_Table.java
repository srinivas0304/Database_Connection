package connection;

import java.sql.*;
import org.testng.annotations.Test;

public class Database_Full_Table 
{
	@Test
	public void test() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/college";
		String userName = "root";
		String password = "password";
		String query = "select * from student";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection(url,userName,password);
//			System.out.println("connection is successful"+url);
//			Statement st = connection.createStatement();
//			ResultSet rs = st.executeQuery(query);
//			ResultSetMetaData rsmd =  rs.getMetaData();
//			int columnsNumber = rsmd.getColumnCount();
//			while(rs.next())
//			{
//				for (int i = 1; i<=columnsNumber; i++)
//				{
//					System.out.print(rs.getString(i) + "|");
//				}
//				System.out.println();
//			}
//			st.close();
//			connection.close();
//		} 
//		catch (ClassNotFoundException e) 
//		{
//			e.printStackTrace();
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url,userName,password);
		System.out.println("Connection is successful "+url);
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		String userData = "";
		while(rs.next())
		{
			userData = rs.getInt(1) + ":" + rs.getString(2);
			System.out.println(userData);
		}
		st.close();
		connection.close();
	}
}
