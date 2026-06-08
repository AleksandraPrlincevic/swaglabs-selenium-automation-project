package tests;

import base.BaseTest;
import components.Header;
import components.InventoryItemComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;
import utils.TestData;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddingItemsTest extends BaseTest {

    @BeforeMethod
    public void testSetUp() throws InterruptedException {
        driver = new FirefoxDriver();
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");  //VIDI MANUELNI ODAKLE KRECE

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        singleItemPage = new SingleItemPage(driver);
        headerPage = new Header(driver);
        cartPage = new CartPage(driver);

        loginPage.login(TestData.validUsername, TestData.validPassword);
 }
    @Test(priority = 1)
    public void addOneItemFromInventoryPage() throws InterruptedException {

           Assert.assertFalse(inventoryPage.getInventoryItems().isEmpty());
           Assert.assertFalse(headerPage.isCartBadgeVisible());
         WebElement randomItem = inventoryPage.getRandomItem();
         inventoryItemComponent = new InventoryItemComponent(driver, randomItem);
           String itemName = inventoryItemComponent.getItemName();
           String itemPrice =inventoryItemComponent.getItemPrice();
         inventoryItemComponent.clickAddToCartButton();
           Assert.assertTrue(headerPage.isCartBadgeVisible());
           Assert.assertEquals(headerPage.getNumberInBadge(), 1);
        headerPage.clickCartIcon();
           Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
           System.out.println("EXPECTED: " + itemName);
           System.out.println("ACTUAL: " + cartPage.getItemInCartName());
           Assert.assertEquals(cartPage.getItemInCartName(), itemName);
           Assert.assertEquals(cartPage.getItemInCartPrice(), itemPrice);
    }

    @Test(priority = 2)
    public void addThreeItemsFromInventoryPage() throws InterruptedException {

        Assert.assertFalse(inventoryPage.getInventoryItems().isEmpty());
        Assert.assertFalse(headerPage.isCartBadgeVisible());

        WebElement randomItem = inventoryPage.getRandomItem();
        inventoryItemComponent = new InventoryItemComponent(driver, randomItem);
        String itemName = inventoryItemComponent.getItemName();
        String itemPrice =inventoryItemComponent.getItemPrice();
        inventoryItemComponent.clickAddToCartButton();

        WebElement randomItem2;
        do {
            randomItem2 = inventoryPage.getRandomItem();
        } while (randomItem2.equals(randomItem));
        inventoryItemComponent = new InventoryItemComponent(driver, randomItem2);
        String itemName2 = inventoryItemComponent.getItemName();
        String itemPrice2 =inventoryItemComponent.getItemPrice();
        inventoryItemComponent.clickAddToCartButton();

        WebElement randomItem3;
        do {
            randomItem3 = inventoryPage.getRandomItem();
        } while (randomItem3.equals(randomItem) || randomItem3.equals(randomItem2));
        inventoryItemComponent = new InventoryItemComponent(driver, randomItem3);
        String itemName3 = inventoryItemComponent.getItemName();
        String itemPrice3 =inventoryItemComponent.getItemPrice();
        inventoryItemComponent.clickAddToCartButton();

           Assert.assertTrue(headerPage.isCartBadgeVisible());
           Assert.assertEquals(headerPage.getNumberInBadge(), 3);
        headerPage.clickCartIcon();
           Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
           System.out.println("EXPECTED: " + itemName + ", " +itemName2+", "+ itemName3);
           System.out.println("ACTUAL: " + cartPage.getItemInCartName());

           Assert.assertTrue(cartPage.getItemNamesText().contains(itemName) &&
        cartPage.getItemNamesText().contains(itemName2) && cartPage.getItemNamesText().contains(itemName3));
           Assert.assertTrue(cartPage.getItemPricesText().contains(itemPrice)&& cartPage.getItemPricesText().contains(itemPrice2)&& cartPage.getItemPricesText().contains(itemPrice3));
    }

      @Test(priority = 5)
       public void addItemFromSingleItemPage(){
           Assert.assertFalse(inventoryPage.getInventoryItems().isEmpty());
        WebElement randomItem = inventoryPage.getRandomItem();
        InventoryItemComponent inventoryItemComponent = new InventoryItemComponent(driver, randomItem);
           String itemName = inventoryItemComponent.getItemName();
           String itemPrice =inventoryItemComponent.getItemPrice();
        inventoryItemComponent.clickItemNameLink();
        shortWait.until(ExpectedConditions.elementToBeClickable(singleItemPage.addToCartButton));
           Assert .assertEquals(singleItemPage.getSingleItemName(), itemName);
           Assert .assertEquals(singleItemPage.getSingleItemPrice(), itemPrice);
        singleItemPage.clickAddToCartButton();
           Assert.assertEquals(headerPage.getNumberInBadge(), 1);
        headerPage.clickCartIcon();
           Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
           Assert.assertEquals(cartPage.getItemInCartName(), itemName);
           Assert.assertEquals(cartPage.getItemInCartPrice(), itemPrice);
     }

    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

}
