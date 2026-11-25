package ar.org.icaro;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    //DRIVER Y WAIT
    private WebDriver driver;
    private WebDriverWait wait;

    //url
    private static final String url = "https://www.saucedemo.com/";
    //Localizadores
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By mensajeError = By.cssSelector("h3[data-test='error']");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Metodos

    public LoginPage goTO(){
        driver.get(url);
        return this;
    }

    public LoginPage enterUsername(String username){
        WebElement campoUser = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        campoUser.clear();
        campoUser.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        WebElement campoPass = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        campoPass.clear();
        campoPass.sendKeys(password);
        return this;
    }

    public InventoryPage clickBotonLogin(){
        WebElement botonLogin = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        botonLogin.click();
        return new InventoryPage(driver);
    }


    public InventoryPage LoginAs(String username, String password){
        enterUsername(username).enterPassword(password).clickBotonLogin();
        return new InventoryPage(driver);
    }


    public LoginPage loginExpectingError(String username, String password){
        enterUsername(username).enterPassword(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return this;
    }

    //Metodos de verificacion

    public boolean isOnLoginPage(){
        try {
            return  wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }

    public boolean isErrorMessageDisplayed(){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeError)).isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }

    public String getErrorMessage(){

        return  wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeError)).getText();
    }

    public  boolean areLoginFieldsDisplayed(){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).isDisplayed() &&
                    wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).isDisplayed() &&
                    wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }




}
