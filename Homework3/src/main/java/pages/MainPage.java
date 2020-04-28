package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;

    private final By username = By.xpath("//*[@id=\"PH_user-email\"]");

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    public  String getUsername(){
        String useN = driver.findElement(username).getText();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(useN.contains("miq.mir.93@mail.ru"));
        return useN;

    }
}
