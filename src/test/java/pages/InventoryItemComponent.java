package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.plaf.PanelUI;

public class InventoryItemComponent extends BasePage {
    private WebElement root;

    public InventoryItemComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }
    //------------------------------Lokatori--------------------------

    WebElement addToCartButton = root.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    WebElement itemNameLink = root.findElement(By.className("inventory_item_name"));
    WebElement itemImage =root.findElement(By.className("inventory_item_img"));
    WebElement itemPrice = root.findElement(By.className("inventory_item_price"));
    //------------------------------Metode za testiranje------------------------------------

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }
    public void clickItemNameLink(){
        wait.until(ExpectedConditions.elementToBeClickable(itemNameLink));
        itemNameLink.click();
    }
    public String getItemName(){
        //wait.until(ExpectedConditions.elementToBeClickable(itemNameLink));
        return itemNameLink.getText();
    }
   /*public String getItemImageSrc(){     //ovo mi ne treba za asertaciju ovde
        return itemImage.getAttribute("src");
    }*/

    public String getItemPrice(){
        return itemPrice.getText();
    }

}
