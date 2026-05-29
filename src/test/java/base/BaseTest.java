package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HeaderPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.SingleItemPage;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait shortWait;

    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public HeaderPage headerPage;
    public SingleItemPage singleItemPage;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

 /*   @AfterClass
    public void tearDown(){
        driver.quit();
    }*/
}
