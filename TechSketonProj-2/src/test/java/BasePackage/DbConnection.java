package BasePackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
  
	public static Connection createconnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection( 
			        "jdbc:mysql://localhost:3306/mydb", "root", 
			        "TechSkeleton@2025");
			    
		return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 

	}
}
