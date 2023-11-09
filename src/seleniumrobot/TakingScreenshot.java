package seleniumrobot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TakingScreenshot {
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		// Configuring WebDriver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit\\eclipse-workspace\\seleniumrobot\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\mohit\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		// Launching URL 
		driver.get("https://www.lambdatest.com/selenium-playground/virtual-dom");
		
		// Initializing Robot Class
		Robot robot = new Robot();			
		
		// Initializing Rectangle Class 
		Rectangle rec = new Rectangle(0,0,1024,1980);
		
		// Command to Capture Screenshot 
		BufferedImage capturedScreenshot = robot.createScreenCapture(rec);
		
		//Creating destination for the output file 
		  File destination = new File("C:\\Users\\mohit\\eclipse-workspace\\seleniumrobot\\Screenshots");
		  
		// Configuring image format, and destination 
		ImageIO.write(capturedScreenshot, "png", destination);

	}
}
