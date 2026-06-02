package tests;

import base.BaseTest;
import components.Header;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.TestData;

import java.time.Duration;

public class CartTest extends BaseTest {

    @BeforeMethod
    public void testSetUp() throws InterruptedException {
        driver = new FirefoxDriver();
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        headerPage = new Header(driver);
        cartPage = new CartPage(driver);

        loginPage.login(TestData.validUsername, TestData.validPassword);
        //shortWait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        headerPage.clickCartIcon();
    }

    @Test
    public void deleteAllItemsFromCart(){
        cartPage.removeAllItemsFromCart();
    }

    @Test
    public void checkoutWithEmptyCart() {
        cartPage.removeAllItemsFromCart();
    }

    @AfterMethod
    public void deleteCokkies(){
        driver.manage().deleteAllCookies();
    }
}