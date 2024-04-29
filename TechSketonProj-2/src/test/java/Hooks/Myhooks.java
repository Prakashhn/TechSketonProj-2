package Hooks;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;

public class Myhooks {
	public WebDriver driver;

	public void setup(Scenario scenario) {
	
		System.out.println("This begining Scenario"+scenario.getName());
		
	}
	
	public void tearDown(Scenario scenario) {
		System.out.println("This Ending Scenario"+scenario.getName());
	}
}
