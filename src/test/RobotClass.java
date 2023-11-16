package test;
import java.awt.AWTException;
import java.awt.Robot;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

public class RobotClass {
	
	 public RemoteWebDriver driver = null;
	 String username = "mohitjoshihere";
	 String accessKey = "NLdReivpECj38YMFFSP13fhjPsaAsPPt28YYeUg2HdnfNu9KRB";

	 @BeforeSuite
	 public void setUp() {
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 capabilities.setCapability("browserName", "Chrome");
	 capabilities.setCapability("version", "92.0");
	 capabilities.setCapability("platform", "Windows 10");
	 capabilities.setCapability("resolution", "1024x768");
	 capabilities.setCapability("build", "Selenium Robot Class Tutorial");
	 capabilities.setCapability("name", "Selenium Robot Class Tutorial");
 try {
	 driver = new RemoteWebDriver(
	 new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
	 } catch (MalformedURLException e) {
	 System.out.println("Invalid grid URL");
	 }
}
	 
	 @BeforeTest
	 public void maximizeBrowser() {
		 
	 driver.manage().window().maximize();
	 }
	 
	 @Test(priority = 0)
	 public void pressingKeyboardKeys() throws AWTException {
		 driver.get("https://ecommerce-playground.lambdatest.io/");
		 driver.findElement(By.name("search")).sendKeys("iphone");
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 @Test(priority = 1)
	 public void scrollingPage() throws AWTException, InterruptedException {
		 driver.get("https://ecommerce-playground.lambdatest.io/");
		 Thread.sleep(2000);
		 Robot robot = new Robot();
		 robot.mouseWheel(30);
		 robot.delay(2000);
		 robot.mouseWheel(-8);
	 }
	 
	 
	 @AfterTest
	 public void quittingBrowser() {
		 driver.quit();	 

	 }
	 
}
