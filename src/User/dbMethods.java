package User;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbMethods
{
	static String conStr = "jdbc:sqlserver://h4java2.database.windows.net:1433;database=Java2Project;user=H4Admin@h4java2;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	
	public static void main(String[] args)
	{
		System.out.print("Indtast brugernavn: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.print("Indtast adgangskode: ");
		String pass = sc.nextLine();
		
		if (login(name, pass))
		{
			System.out.println("Der er logget ind");
		}
		else
		{
			System.out.println("Der er ikke logget ind");
		}
	}
	
	public static boolean login(String name, String pass)
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(conStr);
			
			String query = "Select * from Person WHERE Username = ? AND Pass = ?";
			PreparedStatement prepStmt = con.prepareStatement(query);
			
			prepStmt.setString(1, name);
			prepStmt.setString(2, pass);
			
			ResultSet rs = prepStmt.executeQuery();
			
			if (rs.next() == true)
			{
				con.close();
				return true;
			}
			con.close();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static void getNames()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(conStr);
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("Select * from Person");
			
			while(rs.next())
			{
				System.out.println(rs.getString("Name"));
			}
			con.close();
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
	
	public static void addUser()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(conStr);
			
			String query = "Insert into person values (?, ?, ?, ?, ?)";
			
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setString (1, "Bruger4");
			prepStmt.setString (2, "Fjerde bruger");
			prepStmt.setString (3, "Password4");
			prepStmt.setInt (4, 0);
			prepStmt.setString (5, "Bruger oprettet via Java.");
			
			prepStmt.execute();
			
			con.close();
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
	
	public static void updateUser()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(conStr);
			
			String query = "UPDATE person SET Bio = ? WHERE Username = ?";
			
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setString (1, "Bruger rettet via Java");
			prepStmt.setString (2, "Bruger4");
			
			prepStmt.execute();
			
			con.close();
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