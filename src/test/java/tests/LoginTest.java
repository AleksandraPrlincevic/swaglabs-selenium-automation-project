package tests;

import base.BaseTest;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class LoginTest  extends BaseTest {




    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }



    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

}