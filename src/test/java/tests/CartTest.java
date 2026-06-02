package tests;

import base.BaseTest;
import components.Header;
import components.InventoryItemComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutStepOnePage;
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
        inventoryPage= new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);

        loginPage.login(TestData.validUsername, TestData.validPassword);
        // inventoryPage.getRandomItem();

        headerPage.clickCartIcon();
    }

   /* @Test
    public void deleteAllItemsFromCart(){
        cartPage.removeAllItemsFromCart();
    }*/

    @Test
    public void checkoutWithEmptyCart() {  // Ocekujemo da test padne jer ne bi smelo da se nakon klika na Checkout nadjemo na CheckoutStepTwoPage
        cartPage.removeAllItemsFromCart();
        Assert.assertFalse(headerPage.isCartBadgeVisible());
        cartPage.clickCheckoutButton();
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
        Assert.assertFalse(checkoutStepOnePage.isCheckoutInfoContainer());
    }

    @AfterMethod
    public void deleteCokkies(){
        driver.manage().deleteAllCookies();
    }
}