package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;
 
class NewTest {
    WebDriver driver;
    @BeforeTest
    void setup() {
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
 
    @Test
    void checkTheUrl() {
        
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }
 
    @AfterTest
    void teardown() {
       
        driver.quit();
    }}