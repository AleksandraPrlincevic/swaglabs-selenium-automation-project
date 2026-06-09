package tests;

import base.BaseTest;
import components.Header;
import components.InventoryItemComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.TestData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartTest extends BaseTest {

    String itemName;
    String itemPrice;
    String itemName2;
    String itemPrice2;
    private List<WebElement> chosenRandomItems;

    @BeforeMethod
    public void testSetUp() throws InterruptedException {
        driver = new FirefoxDriver();
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        headerPage = new Header(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);

        loginPage.login(TestData.validUsername, TestData.validPassword);

        List<WebElement> chosenRandomItems = new ArrayList<>();
        InventoryItemComponent item = inventoryPage.getInventoryItemComponent(chosenRandomItems);
        itemName = item.getItemName();
        itemPrice = item.getItemPrice();
        item.clickAddToCartButton();

        InventoryItemComponent item2 = inventoryPage.getInventoryItemComponent(chosenRandomItems);
        itemName2 = item2.getItemName();
        itemPrice2 = item2.getItemPrice();
        item2.clickAddToCartButton();

        headerPage.clickCartIcon();
          Assert.assertTrue(headerPage.getPageTitle().contains("Cart"));
    }

    @Test
    public void deleteAllItemsFromCart(){
        cartPage.removeAllItemsFromCart();
          Assert.assertFalse(headerPage.isCartBadgeVisible());
          Assert.assertTrue(cartPage.getItemNames().isEmpty());
    }

    @Test
    public void finishOrderFromCartPageWithTwoItemsInCart(){
           Assert.assertTrue(headerPage.isCartBadgeVisible());
        cartPage.clickCheckoutButton();
           Assert.assertTrue(checkoutStepOnePage.isCheckoutInfoContainer());
           Assert.assertTrue(headerPage.getPageTitle().contains("Information"));
        checkoutStepOnePage.inputFirstnameField();
        checkoutStepOnePage.inputLastnameField();
        checkoutStepOnePage.inputPostalCodeField();
        checkoutStepOnePage.clickContinueButton();
           Assert.assertTrue(headerPage.getPageTitle().contains("Overview"));
           Assert.assertTrue(checkoutStepTwoPage.getItemNamesText().contains(itemName) && checkoutStepTwoPage.getItemNamesText().contains(itemName2));
           Assert.assertTrue(checkoutStepTwoPage.getItemPricesText().contains(itemPrice) && checkoutStepTwoPage.getItemPricesText().contains(itemPrice2));
           //Assert.assertTrue(checkoutStepTwoPage.getItemPriceFromTotalText().equals("$" + Double.parseDouble(itemPrice) + Double.parseDouble(itemPrice2)));
        checkoutStepTwoPage.clickFinishButton();
            Assert.assertTrue(checkoutCompletePage.getCorrectIcon().isDisplayed());
            Assert.assertTrue(headerPage.getPageTitle().contains("Complete"));
        checkoutCompletePage.clickBackHomeButton();
            Assert.assertFalse(inventoryPage.getInventoryItems().isEmpty());
            Assert.assertFalse(headerPage.isCartBadgeVisible());
    }

    @Test
    public void checkoutWithEmptyCart() {  // Test pada jer mozemo da kliknemo na Checkout i on nas vodi na CheckoutStepTwoPage, iako ne bi smelo jer je korpa prazna
        cartPage.removeAllItemsFromCart();
        Assert.assertFalse(headerPage.isCartBadgeVisible());
        cartPage.clickCheckoutButton();
        Assert.assertTrue(headerPage.getPageTitle().contains("Overview"));
        Assert.assertFalse(checkoutStepOnePage.isCheckoutInfoContainer());
    }
    /* @Test
     public void increaseCartItemQuantityByInput(){ //  Test pada jer ne moze da se promeni kolicina itema u Cartu, a trebalo bi da moze
        cartPage.changeCartQuantity();
        //DODATI ASERTACIJU
     }*/
    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }
}