package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    //---------------------------------Lokatori------------------------------

    @FindBy(className = "login_logo")
    public WebElement logoText;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartIcon;

    @FindBy(id="react-burger-menu-btn")
    public WebElement burgerMenu;

 //-----------------------------------Metode za testiranja-----------------------



    public void clickCartIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
    }
    public void clickBurgerMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenu));
        burgerMenu.click();
    }

}
