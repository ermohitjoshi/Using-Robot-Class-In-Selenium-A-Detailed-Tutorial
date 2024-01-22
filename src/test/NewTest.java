package test;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import org.openqa.selenium.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebElement;

 
class NewTest {
    WebDriver driver;
    Robot robot;
    Actions actions;
	int xcord;
	int ycord;
    
    @BeforeTest
    void setup() throws AWTException {
    	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohit\\eclipse-workspace\\usingSeleniumRobotClass\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\mohit\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		robot = new Robot();
		actions = new Actions(driver);
    }
    
    // Using Keyboard Keys
	 @Test(priority = 0)
	 public void pressingKeyboardKeys() throws AWTException {
		 driver.get("https://ecommerce-playground.lambdatest.io/");
		 driver.findElement(By.name("search")).sendKeys("iphone");
		 System.setProperty("java.awt.headless", "true");
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 robot.delay(2000);
	 }
	 
	 // Using Mouse for Scrolling 
	 @Test(priority = 1)
	 public void scrollingPage() throws AWTException, InterruptedException {
		 driver.get("https://ecommerce-playground.lambdatest.io/");
		 Thread.sleep(2000);
		 
		 robot.mouseWheel(30);
		 robot.delay(2000);
		 robot.mouseWheel(-8);
		 robot.delay(2000);
	 }
	 
	 // Using mouse to hover 
	 @Test (priority = 2)
	 public void mouseHover() {
		 driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");
		 
		 //calculating coordinates of the element to be hovered
		 WebElement hoverButton = driver.findElement(By.className("border-green-100"));
		 Point p = hoverButton.getLocation();
		 xcord = p.getX();
		 ycord = p.getY();
		 robot.delay(2000);
		
		 //robot class to hover
		 robot.mouseMove(xcord,ycord);
		 robot.delay(2000);
	 }
	 
	 // Using mouse to press Keys
	 @Test(priority = 3)
	 public void pressMouseKeys() {
		 driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
		 WebElement clickButton = driver.findElement(By.id("isAgeSelected"));
		 Point c = clickButton.getLocation();
		 xcord = c.getX();
		 ycord = c.getY();
		 robot.mouseMove(xcord,ycord);
		 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 robot.delay(2000);
	 }
	 
	 // Managing the OS dialogue box that appears while downloading
	 @Test(priority = 4)
	 public void downloadFile() throws AWTException {
		 driver.get("https://www.lambdatest.com/selenium-playground/download-file-demo");
		 robot.delay(2000);
		 driver.findElement(By.linkText("Download File")).click();
		 robot.delay(5000);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 // Uploading File 
	 @Test(priority =5)
	 public void uploadFile() throws AWTException{
		 driver.get("https://www.lambdatest.com/selenium-playground/upload-file-demo");	 
	 	 robot.delay(2000);
	 	// Path of the file to be uploaded 
			StringSelection file = new StringSelection("C:\\Users\\mohit\\OneDrive\\Desktop\\demofile.png");
			
			// Copying the path to the clipboard 
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file,null); 		
			
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
		    
		    robot.delay(2000);
		    
//	 		Alternate way of doing it without using the Robot Class
//			uploadButton.sendKeys("C:\\\\Users\\\\mohit\\\\OneDrive\\\\Desktop\\\\demofile.jpg");
	 }
	 
	 // Taking Screenshot 
	 @Test (priority = 6)
	 public void takingScreenshot() throws IOException, HeadlessException, AWTException {
		 driver.get("https://www.lambdatest.com/selenium-playground/virtual-dom");	
			
			// Command to Capture Screenshot 
			BufferedImage capturedScreenshot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			//Creating destination for the output file 
			  File destination = new File("C:\\Users\\mohit\\eclipse-workspace\\usingSeleniumRobotClass\\Screenshot\\currentScreenshot.jpg");
			  
			// This will store screenshot on Specific location with a specific extension of image
			ImageIO.write(capturedScreenshot, "jpg", destination);
	 }
	 
	 
    @AfterTest
    void teardown() {
        driver.quit();
    }}
