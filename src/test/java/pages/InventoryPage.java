package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    //-----------------------------------Metode za testiranje---------------
    //----metode za pronalazanje randomItem(sada randomAddToCartButton,ostale elemente, metode vezane uz njih pravimo u novoj klasi InventoryItemComponent-----

      WebElement randomItem;
      WebElement randomItemLink;

      public  List<WebElement> getInventoryItems(){

          return driver.findElements(By.className("inventory_item"));
      }

      public WebElement getRandomItem(){
          Random randomIndex = new Random();
          int index = randomIndex.nextInt(getInventoryItems().size());
          System.out.println("RANDOM INDEX = " + index);
          System.out.println("SIZE = " + getInventoryItems().size());
          randomItem = getInventoryItems().get(index);
          return  randomItem;
     }



    /* public WebElement getRandomAddToCartButton(){
         randomItem = getRandomItem();
         return randomItem.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
     }
     public void clickRandomAddToCartButton(){
         WebElement button = getRandomAddToCartButton();
         wait.until(ExpectedConditions.elementToBeClickable(button));
       button.click();
     }
     public WebElement getRandomItemLink(){  // pokusavam da izvucem i link sa nazivom itema ali nije ovo najbolje resenje
          if(randomItem==null) {
              throw new IllegalStateException("RandomItem IS NOT initialized");
          } else{
              randomItemLink = randomItem.findElement(By.className("inventory_item_label"));
          }return randomItemLink;
     }*/
}
