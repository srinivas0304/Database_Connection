package connection;

import java.sql.*;

import org.testng.annotations.Test;

public class Database 
{
	@Test
	public void test()
	{
		String url = "jdbc:mysql://localhost:3306/college";
		String userName = "root";
		String password = "password";
		String query = "select * from student";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,userName,password);
			System.out.println("connection is successful"+url);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name = rs.getString("Name");
			System.out.println(name);
			st.close();
			connection.close();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
