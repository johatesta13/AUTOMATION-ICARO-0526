package ar.org.icaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LoginPOM_SauceDemoTest {
    private static final Log log = LogFactory.getLog(LoginPOM_SauceDemoTest.class);
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();// descarga la version compatible del driver con mi chrome personal

        // desactiva el gestor de contraseñas para que no aparezca el popup "Cambia tu contraseña"
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-features=PasswordLeakDetection");
        // options.addArguments("--incognito"); // en incognito chrome no usa el gestor de contraseñas

        driver = new ChromeDriver(options); //abre el navegador
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.goTO();


    }

    @AfterMethod
    public void TearDown(){
        if (driver !=null){
            driver.quit();
        }
    }

    @Test(priority = 1, description = "Validar Login")
    public void ValidarLogin(){
        InventoryPage inventoryPage = loginPage.LoginAs("standard_user","secret_sauce");
        Assert.assertTrue(inventoryPage.isInventoryPage(),"Deberia estaer en la pagina principal (inventario)");
        Assert.assertEquals(inventoryPage.GetTitle(),"Products","El titulo no es el esperado (Products)");
        System.out.println("Login exitoso, estamos en la pagina de inventario");

    }

    @Test(priority = 2, description = "Validar Login Fallido")
    public void ValidarLoginFallido(){
        loginPage.loginExpectingError("standard_user","secret_sauce123");
        Assert.assertTrue(loginPage.isOnLoginPage(),"Deberia permanecer en la pagina de login");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "El mensaje no es el esperado");
        System.out.println("Login fallido, estamos en la pagina de login y se muestra el mensaje de error esperado");


    }


    @Test(priority = 3, description = "Validar Login con usuario bloqueado")
    public void ValidarLoginUserBloqueado(){
        loginPage.loginExpectingError("locked_out_user","secret_sauce");
        Assert.assertTrue(loginPage.isOnLoginPage(),"Deberia permanecer en la pagina de login");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "El mensaje no es el esperado");

        System.out.println("Login fallido, estamos en la pagina de login y " +
                "se muestra el mensaje de error esperado para usuario bloqueado");


    }




}
