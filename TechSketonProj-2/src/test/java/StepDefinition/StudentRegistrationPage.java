package StepDefinition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import BasePackage.DbConnection;
import BasePackage.Student;
import io.cucumber.java.en.*;
public class StudentRegistrationPage {
	

	public WebDriver driver;
	
	public static int val = 0;

	public static Student student = new Student();
		
	
	
	 
	@Given("student is in the registration form")
	public void student_is_in_the_registration_form	() {
		String query = "Select * from studentdetails";
		Connection con = DbConnection.createconnection();
		try {
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			List<Student>  list = new LinkedList<Student>();
				
			while(rs.next()) {
				Student std=new Student();
				std.setS_no(rs.getInt(1));
				std.setFirst_name(rs.getString("first_name"));
				std.setLast_name(rs.getString(3));
				std.setEmail(rs.getString(4));
			    std.setPhone_num(rs.getString(5));
			    std.setGender(rs.getString(6));
			    std.setDob(rs.getString(7));
			    std.setHobby(rs.getString(8));
			    std.setAddress(rs.getString(9));
			    std.setCity(rs.getString(10));
			    std.setUsername(rs.getString(11));
			    std.setPassword(rs.getString(12));
				
			list.add(std);
			}student = list.get(val);
			
			val++;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	

		   System.setProperty("WebDriver.chrome.driver","C:\\chromedriver_win32");
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		  driver.get("https://demoqa.com/automation-practice-form");
		 
	}
	

	@When("student enter all the data to text field")
	public void student_enter_all_the_data_to_text_field() throws InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys(student.getFirst_name());
		driver.findElement(By.id("lastName")).sendKeys(student.getLast_name());
		driver.findElement(By.id("userEmail")).sendKeys(student.getEmail());
		driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
	driver.findElement(By.id("userNumber")).sendKeys(student.getPhone_num());
		// select the date of birth
		WebElement cal=driver.findElement(By.id("dateOfBirthInput"));cal.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebElement sel=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
	    Select sele= new Select(sel);
        sele.selectByValue("1992");
        WebElement sel1=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        sel1.click();
       Select sele1=new Select(sel1);
       sele1.selectByIndex(11);
        WebElement ele4=driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--008']"));
		ele4.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//  	driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys("nhfgjfgsjfgsfhd");
		WebElement checkboxesContainer = driver.findElement(By.xpath("//div[@class='col-md-9 col-sm-12']"));
		 List<WebElement> checkboxes = checkboxesContainer.findElements(By.xpath("//div[@class='custom-control custom-checkbox custom-control-inline']"));
         System.out.println(checkboxes.size());
		 JavascriptExecutor Executor = (JavascriptExecutor) driver;
		 Executor.executeScript("window.scrollBy(0, 2000);");
		 for (WebElement checkbox : checkboxes) {
             // Scroll the checkbox into vie


             // Select the checkbox if it is not already selected
             if (!checkbox.isSelected()) {
                 checkbox.click();
             }
         }
		 driver.findElement(By.id("currentAddress")).sendKeys(student.getAddress());
			
	       driver.findElement(By.xpath("//div[@id='state']")).click();
	       driver.findElement(By.xpath("//div[@id='react-select-3-option-1']")).click();
	       WebElement elements=driver.findElement(By.xpath("//div[@id='city']"));
	       elements.isEnabled();elements.click();
	       driver.findElement(By.xpath("//div[@id='react-select-4-option-1']")).click();
	     
		
				
		  driver.findElement(By.id("submit")).click();
	      Thread.sleep(15000);
//			driver.quit();
         // Optionally, you can add a delay to observe the selections
         
     } 
	
	
	@When("student should click on the Submit button")
	public void student_should_click_on_the_submit_button() {
		System.out.println("Test");
	}

	@Then("student should be get the register details window")
	public void student_should_be_get_the_register_details_window() {
	   System.out.println("Test1");
	}



}