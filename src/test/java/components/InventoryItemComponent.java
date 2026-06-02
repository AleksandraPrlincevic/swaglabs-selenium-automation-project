package components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryItemComponent extends BasePage {
    private WebElement root;

    public InventoryItemComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }
    //------------------------------get metode sa Lokatorima--------------------------

    public WebElement getAddToCartButton(){
        return root.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    }
    public WebElement getItemNameLink(){
        return root.findElement(By.className("inventory_item_name"));
    }
    WebElement itemImage =root.findElement(By.className("inventory_item_img"));

    public WebElement getItemPriceBox(){
        return root.findElement(By.className("inventory_item_price"));
    }
    //------------------------------Metode za testiranje------------------------------------

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(getAddToCartButton()));
        getAddToCartButton().click();
    }
    public void clickItemNameLink(){
        wait.until(ExpectedConditions.elementToBeClickable(getItemNameLink()));
        getItemNameLink().click();
    }
    public String getItemName(){
        //wait.until(ExpectedConditions.elementToBeClickable(itemNameLink));
        return getItemNameLink().getText();
    }
   /*public String getItemImageSrc(){     //ovo mi ne treba za asertaciju ovde
        return itemImage.getAttribute("src");
    }*/

    public String getItemPrice(){
        return getItemPriceBox().getText();
    }

}
