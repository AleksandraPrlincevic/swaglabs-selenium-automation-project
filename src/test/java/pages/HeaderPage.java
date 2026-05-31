package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeaderPage extends BasePage {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    List <WebElement> cartBadge;
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
        cartIcon.click();
    }

    public void clickBurgerMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenu));
        burgerMenu.click();
    }

    public boolean isCartBadgeVisible(){
        cartBadge = driver.findElements(By.className("shopping_cart_badge"));
        return !cartBadge.isEmpty();
    }

    public int getNumberInBadge(){
        int integer;
        cartBadge = driver.findElements(By.className("shopping_cart_badge")); // Pravimo ga kao listu uz findElementssssss
        if(isCartBadgeVisible()){
            return integer = Integer.parseInt(cartBadge.get(0).getText());
        } else{
            return 0;
        }
    }

}
