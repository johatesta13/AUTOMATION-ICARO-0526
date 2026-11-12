package ar.org.icaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginSauceDemoTest {

    private WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup(); // descarga la version compatible del driver con mi chrome personal
        driver = new ChromeDriver(); //abre el navegador
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    private void Login(String usuario, String contra){
        driver.findElement(By.id("user-name")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(contra);
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void ValidarLogin(){
        Login("standard_user","secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),"Deberia iniciar sesion de manera correcta");
        System.out.println( "Caso de login pass");

    }


}

