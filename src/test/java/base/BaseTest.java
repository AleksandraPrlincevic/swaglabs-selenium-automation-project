package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HeaderPage;
import pages.InventoryPage;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait shortWait;

    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public HeaderPage headerPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

 /*   @AfterClass
    public void tearDown(){
        driver.quit();
    }*/
}
