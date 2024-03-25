import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Point;
import java.time.Duration;

import javax.imageio.ImageIO;

import static setup.DriverManager.getDriver;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RobotLocalGrid extends BaseTest {
    private WebDriverWait webDriverWait;
    private Actions actionChains;
    JavascriptExecutor jsExecutor;
    int ELEM_TIMEOUT_DUR = 10;

    Robot robot;
    int xcord;
    int ycord;
    

    @BeforeClass
    public void navigateToWebsite() throws AWTException, InterruptedException
    {
        WebDriver driver = getDriver();

        webDriverWait = new WebDriverWait(driver,
                Duration.ofSeconds(ELEM_TIMEOUT_DUR));
        jsExecutor = (JavascriptExecutor) driver;

        actionChains = new Actions(driver);


        driver.manage().window().maximize();
        robot = new Robot();
        System.setProperty("java.awt.headless", "true");
    }

    @Test(priority = 1, description = "Test 1: Using Keyboard Keys", enabled=true)
    @Parameters({"testurl1"})
    public void pressing_keyboard_keys(final String testurl1) throws InterruptedException
    {
         WebDriver driver = getDriver();
   		 driver.get(testurl1);
   		 driver.findElement(By.name("search")).sendKeys("iphone");
   		 robot.keyPress(KeyEvent.VK_ENTER);
   		 robot.keyRelease(KeyEvent.VK_ENTER);
   		 robot.delay(2000);
}
    @Test(priority = 2, description = "Test 2: Using Scrolling Page", enabled=true)
    @Parameters({"testurl1"})
	 public void scrollingPage(final String testurl1) throws AWTException, InterruptedException {
    	WebDriver driver = getDriver();
		 driver.get(testurl1);
		 Thread.sleep(2000);
		 robot.mouseWheel(30);
		 robot.delay(2000);
		 robot.mouseWheel(-8);
		 robot.delay(2000);
    }

	 @Test(priority = 3, description = "Test 3: Using Mouse Keys", enabled=true)
	 @Parameters({"testurl2"})
	 public void pressMouseKeys(final String testurl2) {
		 WebDriver driver = getDriver();
		 driver.get(testurl2);
		 WebElement clickButton = driver.findElement(By.id("isAgeSelected"));
		 Point c = clickButton.getLocation();
		 xcord = c.getX();
		 ycord = c.getY();
		 robot.mouseMove(xcord,ycord);
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.delay(2000);
	 }
    
	 @Test(priority = 4, description = "Test 4: Downloading a File", enabled=true)
	 @Parameters({"testurl3"})
	 public void downloadFile(final String testurl3) throws AWTException {
		 WebDriver driver = getDriver();
		 driver.get(testurl3);
		 robot.delay(2000);
		 driver.findElement(By.linkText("Download File")).click();
		 robot.delay(5000);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 @Test(priority =5, description = "Test 5: Uploading a File", enabled=true)
	 @Parameters({"testurl4"})
	 public void uploadFile(final String testurl4) throws AWTException{
		 WebDriver driver = getDriver();
		 driver.get(testurl4);	 
	 	 robot.delay(2000);
	 	// Path of the file to be uploaded 
			StringSelection file = new StringSelection("C:\\Users\\mohit\\OneDrive\\Desktop\\demofile.png");
			
			// Copying the path to the clipboard 
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file,null); 				

			// Clicking on the Upload Button 
			driver.findElement(By.id("file")).click();
		    
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
		    
		    robot.delay(2000);
		    
//	 		Alternate way of doing it without using the Robot Class
//			uploadButton.sendKeys("C:\\\\Users\\\\mohit\\\\OneDrive\\\\Desktop\\\\demofile.jpg");
	 }
	 
	 @Test (priority = 6, description = "Test 5: Taking a Screenshot", enabled=true)
	 @Parameters({"testurl5"})
	 public void takingScreenshot(final String testurl5) throws IOException, HeadlessException, AWTException {
		 WebDriver driver = getDriver();
		 driver.get(testurl5);	
			
			// Command to Capture Screenshot 
			BufferedImage capturedScreenshot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			//Creating a destination for the output file 
			  File destination = new File("C:\\Users\\mohit\\eclipse-workspace\\using-robot-class-in-selenium\\Screenshots\\currentScreenshot.jpg");
			  
			// This will store screenshots on Specific locations with a specific extension of the image
			ImageIO.write(capturedScreenshot, "jpg", destination);
	 }
	 
 }
