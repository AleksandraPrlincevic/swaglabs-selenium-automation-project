package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        driver.navigate().to("https://www.saucedemo.com/");  //PROMENITI I VIDI MANUELNI ODAKLE JE NAJBOLJE KRENUTI

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        singleItemPage = new SingleItemPage(driver);
        headerPage = new Header(driver);
        cartPage = new CartPage(driver);

        loginPage.login(TestData.validUsername, TestData.validPassword);
 }
    @Test
    public void addingItemFromInventoryPage() throws InterruptedException {

        Assert.assertTrue(!inventoryPage.inventoryItems.isEmpty());
        WebElement randomItem = inventoryPage.getRandomItem();
        InventoryItemComponent inventoryItemComponent = new InventoryItemComponent(driver, randomItem);
        String itemName = inventoryItemComponent.getItemName();
        String itemImageSrc = inventoryItemComponent.getItemImageSrc();
        inventoryItemComponent.clickAddToCartButton();

        Assert.assertTrue(headerPage.isCartBadgeVisible());
        Assert.assertEquals(headerPage.getNumberInBadge(), 1);
        headerPage.clickCartIcon();
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
        System.out.println("EXPECTED: " + itemName);
        System.out.println("ACTUAL: " + cartPage.getItemInCartName());
        Assert.assertEquals(cartPage.getItemInCartName(), itemName);


        /*inventoryPage.clickRandomAddToCartButton();
        Assert.assertTrue(headerPage.isCartBadgeVisible());
        Assert.assertEquals(headerPage.getNumberInBadge(), 1);
        headerPage.clickCartIcon();
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());*/
    }

   /*  @Test
       public void userCanAddItemsFromSingleItemPage(){
        shortWait.until(ExpectedConditions.elementToBeClickable(singleItemPage.addToCartButton));
        singleItemPage.clickAddToCartButton();
        headerPage.clickCartIcon();
         Assert.assertEquals(headerPage.getNumberInBadge(), 1);
     }*/

    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

}
