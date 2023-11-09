# Using Robot Class In Selenium: A Detailed Tutorial

## 🔗 Prerequisites

- Any IDE to write the code. In this example, we are using Eclipse IDE.

 - Java should be installed in your system. 
    To check Java is installed in your system run the command. 
```bash
java --version
```

- Downoad [Selenium WebDriver](https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.15.0/selenium-java-4.15.0.zip) Language Bindings for Java. 

- Browser Driver for the browser you're performing the testing upon. 

## 🔗 Setup 

- Launch a workspace in Eclipse IDE and create a Java Project. 
- Right-click on Project from Package Explorer **->** Click on Build Path **->** Configure Build Path **->** Java Build Path **->** Click on Class Module **->** Click on Add External JARs **->** Select all the JARs file you have downloaded from the Selenium WebDriver Language Bindings. Now Selenium is successfully configured in your Java Project. 

## 🔗 Using Selenium Robot Classes
There are several predefined methods known as Robot class in Selenium that help in Simulating keyboard and mouse events on the screen. The purpose is to interact with native OS Windows, popups, and native applications of your machines. 

Important Predefined methods or Robot Classes are as follows. 

- KeyPress() and KeyRelease() to simulate keyboard actions. 
- mouseMove(), mousePress(), mouseWheel() and mouseRelease() to simulate mouse actions. 
- createScreenCapture() to capture screenshots which can be saved as a file. 

## 🔗 Using KeyPress() and KeyRelease() to control Keyboard through Selenium

The basic syntax for the KeyPress() and KeyRelease() methods is 

```java
.keyPress(KeyEvent.{event});
.keyRelease(KeyEvent.{event});
```

| **Keyboard Key** |  **Syntax** |
|:-----|:--------:|
| Number Keys   | `.keyPress(KeyEvent.VK_n);` where 'n' could be the number you want |
| Enter Key |  `.keyPress(KeyEvent.VK_ENTER);`  |
| Control Key   |`.keyPress(KeyEvent.VK_CONTROL);` |

While writing the syntax the IDE will display the list of possible options. 

<img width="444" alt="1" src="https://github.com/ermohitjoshi/Using-Robot-Class-In-Selenium-A-Detailed-Tutorial/assets/87078547/6c5e0503-6a49-414c-b2e2-b95942c1f897">

Let's automate a task using Selenium. It will navigate to an e-commerce application in our browser, search for a product and hit the enter key. 

Let's understand how we can do it with the help of Robot Class in Selenium. 

Launch the URL of the e-commerce application 

```java
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\eclipse-workspace\\seleniumrobot\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://ecommerce-playground.lambdatest.io/");
```

Find the Search Bar and type the search query 

		driver.findElement(By.name("search")).sendKeys("iphone");
		Thread.sleep(4000);

Initialize the Robot Class in Selenium 

		Robot robot = new Robot();

Use the Robot Class to Hit the Enter key and then release the key after it has been pressed. 

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

## 🔗 Using mousePress() and mouseRelease() to Click using mouse in Selenium on a webpage
The basic syntax for using the mousePress() method. 	
		
	.mousePress(InputEvent.{event});

The ```{event}``` can take several values such as. 

```BUTTON1_DOWN_MASK``` for left Click
```BUTTON2_DOWN_MASK``` for right Click

## 🔗 Using mouseWheel() to scroll in a page using Selenium 

The mouseWheel() syntax will be used to scroll in a webpage. This method takes some value, and that value is referred to as the Wheel Amount. The positive wheel amount indicates that the mouse will scroll downwards, however, the negative Wheel Amount will indicate that the mouse will scroll upwards. 

The basic syntax for the method is
	
		.mouseWheel(x);


For example, consider the following code. The value '30' depicts first it will scroll downwards and the value '-8' depicts it will scroll upwards after that. 

		Robot robot = new Robot();

		robot.mouseWheel(30);

		Thread.sleep(2000);

		robot.mouseWheel(-8);
    
An alternative option in the above script for the ```Thread.Sleep()``` method in Robot class is to use the **```robot.delay()```**

## 🔗 Using mouseMove() to hover the mouse on a webpage

The basic syntax for the method is
	
		.mouseMove(x,y);

This method takes the value of the x and y coordinates of the web element.

## 🔗 Capturing a Screenshot using Robot class in Selenium 
To take a Screenshot on any screen, first initialise a rectangle class in Selenium. 

	Rectangle rec = new Rectangle(0,0,1024,1980);

The syntax for the Rectangle class is as follows. 

	Rectangle(int x-coordinate, int y-coordinate, int height, int width);

or 

	Rectangle(Point p, Dimension d);

Then use the Buffered Image class to manipulate the captured screenshot data. 

	BufferedImage capturedScreenshot = robot.createScreenCapture(rec);

Then mark the destination for the screenshot to be stored. 

	File destination = new File("C:\\Users\\eclipse-workspace\\seleniumrobot\\Screenshots");

And finally use Java's ImageIO class 

	ImageIO.write(capturedScreenshot, "png", destination);

## 🔗 Uploading and Downloading using Robot Class in Selenium 

To upload a file on the web using Selenium follow these steps. 

Launch the URL where you want to upload the file.

	driver.get("https://www.lambdatest.com/selenium-playground/upload-file-demo");

Initialize the path where the file is stored on the system to a string format. 

	StringSelection file = new StringSelection "C:\\Users\\OneDrive\\Desktop\\demofile.jpg");

Copy the file path to the clipboard of the operating system 

	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file,null); 

Initializing the Action class because we are dealing with an input HTML tag 

	Actions actions = new Actions(driver);

Finding and Click the upload button to launch the dialog box which asks to select the file to upload. 

	WebElement uploadButton = driver.findElement(By.id("file"));	

	actions.moveToElement(uploadButton).click().perform();	

Pasting the path of the file from the clipboard to the search bar of the dialogue box 

	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);

Pressing the enter key to select the file and ultimately upload the file. 

	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);

An alternate way of doing it without using the Robot Class 

	uploadButton.sendKeys("C:\\Users\\OneDrive\\Desktop\\demofile.jpg");

