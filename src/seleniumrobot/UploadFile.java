package seleniumrobot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class UploadFile {
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		// Configuring WebDriver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit\\eclipse-workspace\\seleniumrobot\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\mohit\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		// Launching URL 
		driver.get("https://www.lambdatest.com/selenium-playground/upload-file-demo");
		Thread.sleep(4000);
		
		// Path of the file to be uploaded 
		StringSelection file = new StringSelection("C:\\Users\\mohit\\OneDrive\\Desktop\\demofile.jpg");
		
		// Copying the path to the clipboard 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file,null); 
		
		// Initializing Robot Class
		Robot robot = new Robot();		
		
		// Initializing Actions to interact with input file type on the webpage
		Actions actions = new Actions(driver);
		
		// Initializing the Upload button 
		WebElement uploadButton = driver.findElement(By.id("file"));		

		// Clicking on the Upload Button 
		actions.moveToElement(uploadButton).click().perform();	
		robot.delay(2000);
	    
		// Pressing the CTRL + V command 
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    
	    // Releasing the CTRL + V command
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    
	    // Delaying for 2 seconds
	    robot.delay(2000);
	    
	    // Hitting the enter key which will ultimately upload the file 
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
// 		Alternate way of doing it without using the Robot Class
//		uploadButton.sendKeys("C:\\\\Users\\\\mohit\\\\OneDrive\\\\Desktop\\\\demofile.jpg");
	}
}
