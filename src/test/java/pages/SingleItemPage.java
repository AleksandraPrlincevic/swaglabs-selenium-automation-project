package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class SingleItemPage extends BasePage {
    public SingleItemPage(WebDriver driver) {
        super(driver);
    }

    //-----------------------------Lokatori-------------------------

    @FindBy(id="add-to-cart")
    public WebElement addToCartButton;

    @FindBy(id="remove")
    public WebElement removeButton;

    @FindBy(id="back-to-products")
    public WebElement backToProductsLink;

    @FindBy(className = "inventory_item_name")
    WebElement singleItemName;

    @FindBy(className ="inventory_item_price")
    WebElement singleItemPrice;

 //---------------------------------Metode za testiranje--------------------

    public void clickAddToCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void clickRemoveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();
    }
    public String getSingleItemName(){
        return singleItemName.getText();
    }

    public String getSingleItemPrice(){
        return singleItemPrice.getText();
    }
}
