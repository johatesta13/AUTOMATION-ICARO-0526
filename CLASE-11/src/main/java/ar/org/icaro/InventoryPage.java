package ar.org.icaro;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage
{
    private WebDriver driver;
    private WebDriverWait wait;
    private By pageTitle = By.className("title");
    private By CartButton = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public boolean isInventoryPage(){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }

    public String GetTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    //METODOS DE INTERACCION PROXIMAMENTE
    // AGREGAR ELEMENTOS AL CARRITO IR A CARRITO LOGOUT Y REMOVER ELEMENTOS DEL CARRITO






}
