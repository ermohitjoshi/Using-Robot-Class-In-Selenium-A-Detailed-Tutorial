package seleniumrobot;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class keypressandrelease {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		// Configuring WebDriver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit\\eclipse-workspace\\seleniumrobot\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\mohit\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		// Launching URL 
		driver.get("https://ecommerce-playground.lambdatest.io/");
		
		// Finding the Search Bar and entering the search text
		driver.findElement(By.name("search")).sendKeys("iphone");
		
		// Delaying using normal selenium method
		Thread.sleep(4000);
		
		// Initializing Robot Class
		Robot robot = new Robot();
		
		// Command to press the key  
		robot.keyPress(KeyEvent.VK_ENTER);
		
		// Command to release the key after it has been pressed
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
