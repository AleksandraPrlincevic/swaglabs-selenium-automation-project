package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutStepOnePage extends BasePage {


    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    //---------------------Lokatori i geteri za elemente-------------------------

    @FindBy(id="checkout_info_container")
    WebElement checkoutInfoContainer;

   public WebElement getFirstnameField(){
       return driver.findElement(By.id("first-name"));
   }

    public WebElement getLastnameField(){
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getPostalCodeField(){
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton(){
       return driver.findElement(By.id("continue"));
    }
//----------------------metode za testiranje ------------------------------

    public  boolean isCheckoutInfoContainer(){
        return checkoutInfoContainer.isDisplayed();
    }

    public void inputFirstnameField(){
       wait.until(ExpectedConditions.elementToBeClickable(getFirstnameField()));
       getFirstnameField().clear();
       getFirstnameField().sendKeys("Ana");
    }

    public void inputLastnameField(){
       getLastnameField().clear();
        getLastnameField().sendKeys("Anic");
    }

    public void inputPostalCodeField(){
       getPostalCodeField().clear();
        getPostalCodeField().sendKeys("11000");
    }

    public void  clickContinueButton(){
       getContinueButton().click();
    }
}
