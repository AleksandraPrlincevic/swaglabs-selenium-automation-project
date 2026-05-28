package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
