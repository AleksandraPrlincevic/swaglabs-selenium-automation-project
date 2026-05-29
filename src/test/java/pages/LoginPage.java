package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    String username;
    String password;

//-----------------------Lokatori-----------------------------------

    @FindBy(id="user-name")
    WebElement usernameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="login-button")
    WebElement loginButton;

// ---------------------jos Lokatora za Asertacije --------------------------

    @FindBy(className = "login_logo")
    public WebElement logoText;


    //----------------------------Metode za testiranje----------------------------

    public void inputInUsernameField(String username){
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys(username);
    }

    public void inputInPasswordField(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
}
