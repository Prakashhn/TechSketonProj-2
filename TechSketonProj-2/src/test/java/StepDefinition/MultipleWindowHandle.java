package StepDefinition;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class MultipleWindowHandle {
	WebDriver driver;
	String singlewindow ="";
	String childwindow = "";
@Given("user is on Window tab of the Demoqa website")
public void user_is_on_window_tab_of_the_demoqa_website() {
   System.setProperty("WebDriver.chrome.driver","C:\\chromedriver_win32");
   driver=new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://demoqa.com/browser-windows");
}


@When("user click on the New window")
public void user_click_on_the_new_window() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, 600);");
	driver.findElement(By.id("windowButton")).click();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
  singlewindow = driver.getWindowHandle();
  Set<String> multiwindow = driver.getWindowHandles();
  Iterator<String> itr = multiwindow.iterator();
  itr.next();

  childwindow = itr.next();
  Thread.sleep(4000);
}

@Then("user can get the childwindow")
public void user_can_get_the_childwindow() {
  
	
driver.switchTo().window(childwindow);
driver.close();
driver.switchTo().window(singlewindow);
driver.close();
}

}
