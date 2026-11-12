package ar.org.icaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrimerTestSelenium {

    private WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup(); // descarga la version compatible del driver con mi chrome personal
        driver = new ChromeDriver(); //abre el navegador
        driver.manage().window().maximize();
    }


    @Test
    public void VerificarTitulo(){

        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getTitle(),"Swag Labs","El titulo es incorrecto");

    }

    @AfterMethod
    public void TearDown(){

        if (driver !=null){
            driver.quit();
        }
    }


}
