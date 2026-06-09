package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //-----------------------Lokatori-------------------------------

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(className = "inventory_item_name")
    WebElement itemInCartName;

    @FindBy(className = "inventory_item_price") // Za CartPage ce morati takodje da se uradi lista ubacenih itema
    WebElement itemInCartPrice;

 //-------------get metode sa lokatorima---------------------------

    public List<WebElement> getRemoveButtons(){
      return  driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
    }

    public List<WebElement> getItemPrices(){
        return driver.findElements(By.className("inventory_item_price"));
    }

    public List<String> getItemPricesText(){
        List<String> prices = new ArrayList<>();
        for(WebElement e: getItemPrices()){
            prices.add(e.getText());
        } return prices;
    }
    public List<WebElement> getItemNames(){
        return driver.findElements(By.className("inventory_item_name"));
    }

    public List<String> getItemNamesText(){
        List<String> names = new ArrayList<>();
        for(WebElement e: getItemNames()){
            names.add(e.getText());
        } return names;
    }

    public WebElement getCartQuantityBox(){
        return driver.findElement(By.className("cart_quantity"));
    }

    //----------------------Metode za testiranje-----------------

    public boolean isCheckoutButtonDisplayed() {
        return checkoutButton.isDisplayed();
    }

    public String getItemInCartName() {
        return itemInCartName.getText();
    }

    public String getItemInCartPrice() {
        return itemInCartPrice.getText();
    }

    public String getCartQuantity(){
        return getCartQuantityBox().getText();
    }
    public void changeCartQuantity(){
        getCartQuantityBox().sendKeys("2");
    }

    public void removeAllItemsFromCart() {
        while(!getRemoveButtons().isEmpty()) {
                 getRemoveButtons().get(0).click();
        }
    }
    public void clickCheckoutButton(){
        checkoutButton.click();
    }
}