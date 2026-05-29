package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //-----------------------Lokatori--------------------


   //indBy(id="add-to-cart-sauce-labs-backpack")
    //public  WebElement addToCartButtonBackpack;  //sta kad taj backpack prestane da se prodaje?

    @FindBy(css=".btn.btn_primary.btn_small.btn_inventory")
    public WebElement addToCartButton;

    @FindBy(css="select[className='product_sort_container']")
    public WebElement productSortButton;

    @FindBy(id = "inventory_container")
    public WebElement inventoryContainer;

    @FindBy(className = "inventory_item")
    public List<WebElement> inventoryItems;

    //-----------------------------------Metode za testiranje------------------




}
