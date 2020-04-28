package base;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;

import event.EventReporter;
import pages.LoginPage;


public class BaseTest {

    private static  WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/miqayelmiqayel/Downloads/JUnit Project/CS230_AUA_JUnit/Driver/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        loginPage = new LoginPage(driver);
    }



    @AfterClass
    public static void tearDown() {

        driver.quit();
    }

}
