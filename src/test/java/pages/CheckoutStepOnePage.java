package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage {


    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    //---------------------Lokatori-------------------------

    @FindBy(id="checkout_info_container")
    WebElement checkoutInfoContainer;


    public  boolean isCheckoutInfoContainer(){
        return checkoutInfoContainer.isDisplayed();
    }
}
