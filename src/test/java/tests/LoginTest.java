package tests;

import base.BaseTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.TestData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import components.Header;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest  extends BaseTest {

    @BeforeMethod
    public void testSetUp() {
        driver = new FirefoxDriver();
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        headerPage = new Header(driver);
    }


@Test(priority = 1)
public void validLoginTest() {

    Assert.assertEquals(headerPage.logoText.getText(), "Swag Labs");

    loginPage.inputInUsernameField(TestData.validUsername);
    loginPage.inputInPasswordField(TestData.validPassword);
    loginPage.clickLoginButton();

    shortWait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

    String actualURL = driver.getCurrentUrl();
    String expectedURL = "https://www.saucedemo.com/inventory.html"; // neku vrstu ove asertacije smo vec imali u waitu
    Assert.assertEquals(actualURL, expectedURL);

    Assert.assertTrue(headerPage.cartIcon.isDisplayed());

    Assert.assertEquals(inventoryPage.addToCartButton.getText(), "Add to cart");
}
    @Test(priority = 10)
    public void invalidUsernameLoginTest() {

        Assert.assertEquals(headerPage.logoText.getText(), "Swag Labs");

        loginPage.inputInUsernameField(TestData.invalidUsername);
        loginPage.inputInPasswordField(TestData.validPassword);
        loginPage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test(priority = 20)
    public void invalidPasswordLoginTest() {

        Assert.assertEquals(headerPage.logoText.getText(), "Swag Labs");

        loginPage.inputInUsernameField(TestData.validUsername);
        loginPage.inputInPasswordField(TestData.invalidPassword);
        loginPage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test(priority = 22)
    public void emptyUsernameLoginTest() {

        Assert.assertEquals(headerPage.logoText.getText(), "Swag Labs");

        loginPage.inputInUsernameField("");
        loginPage.inputInPasswordField(TestData.validPassword);
        loginPage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test(priority = 24)
    public void emptyPasswordLoginTest() {

        Assert.assertEquals(headerPage.logoText.getText(), "Swag Labs");

        loginPage.inputInUsernameField(TestData.validUsername);
        loginPage.inputInPasswordField("");
        loginPage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test(priority = 26)
    public void emptyUsernameAndPasswordLoginTest() {

        Assert.assertEquals(headerPage.logoText.getText(), "Swag Labs");

        loginPage.inputInUsernameField("");
        loginPage.inputInPasswordField("");
        loginPage.clickLoginButton();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

}