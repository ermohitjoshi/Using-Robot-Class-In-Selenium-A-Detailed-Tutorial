package seleniumrobot;

import java.awt.AWTException;
import java.awt.Robot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScrollingPage {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		// Configuring WebDriver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit\\eclipse-workspace\\seleniumrobot\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\mohit\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		// Launching URL 
		driver.get("https://ecommerce-playground.lambdatest.io/");
		Thread.sleep(4000);
		
		// Initializing Robot Class
		Robot robot = new Robot();
		
		// Command to scroll the mouse downwards using Wheel Amount as input 
		robot.mouseWheel(30);
		
		// Robot Class command to delay for 1 second
		robot.delay(2000);
		
		// Command to scroll the mouse upward using Wheel Amount as input
		robot.mouseWheel(-8);
	}
}
