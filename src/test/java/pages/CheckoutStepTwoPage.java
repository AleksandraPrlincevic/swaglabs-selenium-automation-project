package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }
   WebElement randomItem;
    //---------------------------geteri za elemente  s lokatorima------------------------

    public WebElement getFinishButton(){
        return driver.findElement(By.id("finish"));
    }

    public List<WebElement> getCartItems(){

        return driver.findElements(By.className("cart_item"));
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

    public WebElement getItemPriceFromTotal(){
        return driver.findElement(By.className("summary_subtotal_label"));
    }

    public String getItemPriceFromTotalText(){
        return getItemPriceFromTotal().getText();
    }
    //--------------------------metode za testiranje--------------------

    public void clickFinishButton(){
        getFinishButton().click();
    }



    public WebElement getRandomItem(){
        Random randomIndex = new Random();
        int index = randomIndex.nextInt(getCartItems().size());
        System.out.println("RANDOM INDEX = " + index);
        System.out.println("SIZE = " + getCartItems().size());
        randomItem = getCartItems().get(index);
        return  randomItem;
    }
}
