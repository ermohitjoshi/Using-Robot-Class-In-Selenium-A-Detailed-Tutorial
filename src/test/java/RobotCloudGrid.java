import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import static setup.DriverManager.getDriver;
import static setup.DriverManager.status;

import java.awt.AWTException;
import java.awt.Robot;

public class RobotCloudGrid extends BaseTest {
    private WebDriverWait webDriverWait;
    private Actions actionChains;
    JavascriptExecutor jsExecutor;
    int ELEM_TIMEOUT_DUR = 10;

    Robot robot;
    int xcord;
    int ycord;

    @BeforeClass
    @Parameters({"testurl"})
    public void navigateToWebsite(final String testURL) throws AWTException, InterruptedException
    {
        WebDriver driver = getDriver();

        webDriverWait = new WebDriverWait(driver,
                Duration.ofSeconds(ELEM_TIMEOUT_DUR));
        jsExecutor = (JavascriptExecutor) driver;
        /* Not a good practice, used for testing */
        actionChains = new Actions(driver);
        driver.get(testURL);
        driver.manage().window().maximize();
        /* Recommend using explicit wait */
        /* Blocking wait used only for testing */
        robot = new Robot();
        System.setProperty("java.awt.headless", "true");
        Thread.sleep(2000);
    }

    @Test(description = "Test 1: Sign in In Demo Website",
            enabled=true)
    public void sign_in_demo() throws InterruptedException
    {
        WebDriver driver = getDriver();
        try
        {
            driver.get("https://the-internet.herokuapp.com/basic_auth");
            Thread.sleep(10000);

            // Put the value of username against admin
            ((JavascriptExecutor) driver).executeScript("lambda-set-clipboard:admin");

            ((JavascriptExecutor) driver).executeScript("lambda-perform-keyboard-events:^v");
            Thread.sleep(2000);

            //TAB to switch cursor from username to password
            ((JavascriptExecutor) driver).executeScript("lambda-perform-keyboard-events:{TAB}");

            // Put the password value against the admin.
            ((JavascriptExecutor) driver).executeScript("lambda-set-clipboard:admin");
            Thread.sleep(2000);

            ((JavascriptExecutor) driver).executeScript("lambda-perform-keyboard-events:^v");
            Thread.sleep(2000);

            // Press sign in
            ((JavascriptExecutor) driver).executeScript("lambda-perform-keyboard-events:{ENTER}");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            status = "failed";
        }
        Thread.sleep(2000);
    }
}
