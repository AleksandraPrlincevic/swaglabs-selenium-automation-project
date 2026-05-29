package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //-----------------------Lokatori--------------------

    @FindBy(className = "shopping_cart_link")
    public WebElement cartIcon;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    public  WebElement addToCartButtonBackpack;  //sta kad taj backpack prestane da se prodaje?

    @FindBy(css="select[className='product_sort_container']")
    public WebElement productSortButton;



}
