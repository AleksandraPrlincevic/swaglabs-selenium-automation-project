package tests;

import base.BaseTest;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class LoginTest  extends BaseTest {


    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);

    }
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";
    String invalidUsername = "strange_user";
    String  invalidPassword = "wrong_sauce";

@Test
public void validLoginTest(){

    Assert.assertEquals(loginPage.logoText.getText(), "Swag Labs");

    loginPage.inputInUsernameField(validUsername);
    loginPage.inputInPasswordField(validPassword);
    loginPage.clickLoginButton();

    shortWait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

    String actualURL = driver.getCurrentUrl();
    String expectedURL = "https://www.saucedemo.com/inventory.html"; // neku vrstu ove asertacije smo vec imali u waitu
    Assert.assertEquals(actualURL, expectedURL);





}
    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

}