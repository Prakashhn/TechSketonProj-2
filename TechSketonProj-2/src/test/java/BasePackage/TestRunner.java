package BasePackage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( 
		features="src/test/resources/features",
		glue={"StepDefinition","Hooks","Test"}, 
		plugin= {"pretty","html:target/CucumberReport.html",
				"junit:target/CucumberReport.xml", 
				"json:target/CucumberReport.json"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
	public static Student student = Fetchvalues();
	
	public static int CreateTable(String tablename, String field[]) {
		
		
		String query = "Create table StudentDetails(";
		for(int i =0; i<field.length-1;i++) {
           query += ""+field[i]+" varchar(255),"; 
		}
		
		query += ""+field[field.length-1]+" varchar(255));";
		
		System.out.print(query);
		Connection con = DbConnection.createconnection();
		try {
			PreparedStatement statement = con.prepareStatement(query);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	
	public static String Insertvalues(Student std) {
		
		
		 String query = "Insert into studentdetails values(?,?,?,?,?,?,?,?,?,?,?,?)";
		 
		 
		 
		 
		 Connection con = DbConnection.createconnection();
			try {
				PreparedStatement statement = con.prepareStatement(query);
				
				statement.setInt(1, std.getS_no());
				statement.setString(2, std.getFirst_name());
				statement.setString(3,std.getLast_name());
				statement.setString(4,std.getEmail());
				statement.setString(5,std.getPhone_num());
				statement.setString(6,std.getGender());
				statement.setString(7,std.getDob());
				statement.setString(8,std.getHobby());
				statement.setString(9,std.getAddress());
				statement.setString(10,std.getCity());
				statement.setString(11,std.getUsername());
				statement.setString(12,std.getPassword());
				
				
				 statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return "Values Inserted";
	}
	
	
	
	public static Student Fetchvalues() {
		
		String query = "Select * from studentdetails";
		Connection con = DbConnection.createconnection();
		try {
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			Student std = new Student();
				
			while(rs.next()) {
				
				std.setS_no(rs.getInt(1));
				std.setFirst_name(rs.getString("first_name"));
				std.setLast_name(rs.getString("last_name"));
				std.setEmail(rs.getString(4));
			    std.setPhone_num(rs.getString(5));
			    std.setGender(rs.getString(6));
			    std.setDob(rs.getString(7));
			    std.setHobby(rs.getString(8));
			    std.setAddress(rs.getString(9));
			    std.setCity(rs.getString(10));
			    std.setUsername(rs.getString(11));
			    std.setPassword(rs.getString(12));
				
			
			}
			 
			
			return std;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

	public static void main(String[] args) {
		try {
//			 String arr[] = new String[2];
			 
//			 String query = "Create table studentdetails(s_no int, first_name varchar(255), last_name varchar(255), email varchar(255), phone_num varchar(255), gender varchar(255), dob varchar(255), hobbies varchar(255), address varchar(255), city varchar(255), username varchar(255), password varchar(255))";
//			 
//			 Connection con = DbConnection.createconnection();
//				try {
//					PreparedStatement statement = con.prepareStatement(query);
//					statement.executeUpdate();
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			    arr[0] = "Username";
//			    arr[1] = "Password";
//			    arr[2]="Mail_Id";
//			    int val = TestRunner.CreateTable("RegisterUser", arr);
//			    
//			    System.out.print(val);
			     
			    
//			    System.out.println("table is created");
		
			
			//Inserting values;
//			    Student student = new Student();
//			    
//			    student.setS_no(1);
//			    student.setFirst_name("11");
//			    student.setLast_name("22");
//			    student.setEmail("abc@gmail.com");
//			    student.setPhone_num("9087654321");
//			    student.setGender("male");
//			    student.setDob("12/03/2000");
//			    student.setHobby("chess");
//			    student.setAddress("Bengaluru");
//			    student.setCity("Bengaluru");
//			    student.setUsername("111");
//			    student.setPassword("111");
//			    
//			    String res = TestRunner.Insertvalues(student);
//			    
//			    System.out.println(res);
			    
//			    Student student = Fetchvalues();
//			    
//			    System.out.println(student.getUsername());
//			    System.out.println(student.getAddress());
			    
			    
		}
		catch (Exception e) { 
		    e.printStackTrace(); 
		}
			} 

	}



