package seleniumrobot;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MouseHover {
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		// Configuring WebDriver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit\\eclipse-workspace\\seleniumrobot\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\mohit\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		// Launching URL 
		driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");
		Thread.sleep(4000);
		
		
		// Initializing Robot Class
		Robot robot = new Robot();
		
		// Command to move the mouse across the screen using x and y coordinates as inputs
		robot.mouseMove(104, 33);
	}
}
