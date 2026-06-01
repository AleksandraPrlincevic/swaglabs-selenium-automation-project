package base;

import components.Header;
import components.InventoryItemComponent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait shortWait;

    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public Header headerPage;
    public SingleItemPage singleItemPage;
    public CartPage cartPage;
    public InventoryItemComponent inventoryItemComponent;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
    }

 /*   @AfterClass
    public void tearDown(){
        driver.quit();
    }*/
}
