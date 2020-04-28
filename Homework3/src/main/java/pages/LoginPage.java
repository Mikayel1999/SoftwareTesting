package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage
{
    private final WebDriver driver;

    private final By email = By.xpath("//*[@id=\"mailbox:login\"]");
    private final By pass = By.xpath("//*[@id=\"mailbox:password\"]");
    private final By clickButton = By.xpath("//*[@id=\"mailbox:submit\"]/input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setUsername(String username) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(email).sendKeys(username);
        driver.findElement(clickButton).click();

    }

    public void setPassword(String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(pass).sendKeys(password);
    }

    public MainPage clickBtn() {
        driver.findElement(clickButton).click();
        return new MainPage(driver);
    }

    public String getIncorrectText() {

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String actual_error= driver.findElement(By.xpath("//*[@id=\"mailbox:error\"]")).getText();
        Assert.assertTrue(actual_error.contains("Неверное имя или пароль"));
        return actual_error;


    }
}
