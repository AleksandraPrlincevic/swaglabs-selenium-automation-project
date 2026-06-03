package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCorrectIcon(){
        return driver.findElement(By.cssSelector("img[alt='Pony Express']"));
    }

    public WebElement getBackHomeButton(){
        return driver.findElement(By.id("back-to-products"));
    }


    //------------------------------metode za testiranje---------------------------

    public void clickBackHomeButton(){
        getBackHomeButton().click();
    }
}
