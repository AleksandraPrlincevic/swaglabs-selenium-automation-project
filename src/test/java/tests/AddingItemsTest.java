package tests;

import base.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.SingleItemPage;

import java.time.Duration;

public class AddingItemsTest extends BaseTest {

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");  //PROMENITI I VIDI MANUELNI ODAKLE JE NAJBOLJE KRENUTI

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        singleItemPage = new SingleItemPage(driver);
        headerPage = new HeaderPage(driver);


    }

     @Test
     public void userCanAddItemsFromSingleItemPage(){
        singleItemPage.clickAddToCartButton();
        headerPage.clickCartIcon();
         Assert.assertEquals(headerPage.getNumberInBadge(), 1);
     }

    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

}
