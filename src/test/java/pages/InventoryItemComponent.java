package pages;

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
    //------------------------------Lokatori--------------------------

    WebElement addToCartButton = root.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    WebElement linkName = root.findElement(By.className("inventory_item_label"));

    //------------------------------Metode za testiranje------------------------------------

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }
}
