package ar.org.icaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AgileTravelE2ETest {


    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL= "https://travel.agileway.net/login";
    private static final String USUARIO = "agileway";
    private static final String PASSWORD = "test$W1se";

    @BeforeClass
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
        options.addArguments("--incognito"); // en incognito chrome no usa el gestor de contraseñas

        driver = new ChromeDriver(options); //abre el navegador
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);


    }

    @AfterClass
    public void TearDown(){

        if (driver !=null){
            driver.quit();
        }
    }

    //PASO 1: LOGIN EN LA PAGINA
    @Test(priority = 1,description = "Validar login exitoso con credenciales validad")
    public void ValidarLogin(){

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username.sendKeys(USUARIO);

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys(PASSWORD);

        WebElement RememberMeCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remember_me")));
        if(!RememberMeCheck.isSelected()){
            RememberMeCheck.click();
        }

        WebElement signinBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("commit")));
        signinBtn.click();

        //VALIDAMOS INICIO DE SESION CON ASSERTS

      wait.until(ExpectedConditions.urlContains("start"));
      Assert.assertTrue(driver.getCurrentUrl().contains("start"),"Deberia iniciar sesion de manera correcta");
    }


    //PASO 2: SELECCION DEL VUELO

    @Test(priority = 2, description = "Validar la seleccion de un vuelo")
    public void BuscarVuelo(){

        WebElement radioOneway = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='oneway']")));
        WebElement radioReturn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='return']")));

        if(!radioOneway.isSelected()){
            radioOneway.click();
        }


        Assert.assertTrue(radioOneway.isSelected(),"DEBERIA ESTAR SELECCIONADO");

        //Dropdown de origen

        Select origen  = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fromPort"))));
        origen.selectByVisibleText("Sydney");

        //Dropdown destino

        Select destino = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.name("toPort"))));
        destino.selectByVisibleText("New York");

        //Dropdown de el dia
        Select dia = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("departDay"))));
        dia.selectByVisibleText("02");

        //Dropdown del mes

        Select mes = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.id("departMonth"))));
        mes.selectByIndex(1);

        //Al elegir el mes se despliega la tabla de vuelos disponibles
        WebElement tablaVuelos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flights")));
        Assert.assertTrue(tablaVuelos.isDisplayed(),"Deberia mostrarse la tabla de vuelos");

        //Seleccionamos el vuelo QF821 de Qantas buscando la fila por el numero de vuelo
        WebElement checkVuelo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='flights']//tr[td[text()='QF821']]//input[@type='checkbox']")));
        if(!checkVuelo.isSelected()){
            checkVuelo.click();
        }
        Assert.assertTrue(checkVuelo.isSelected(),"El vuelo QF821 deberia estar seleccionado");

        WebElement btncontinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
        btncontinue.click();

    }

    //PASO 3 DATOS DEL PASAJERO
    @Test(priority = 3,description = "Validar formulario del pasajero")
    public void Datosdelpasajero(){

        //CASO NEGATIVO CUANDO NO SE INGRESA LAST NAME

        WebElement btnnext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']")));
        btnnext.click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("flash_alert"),"Must provide last name"));

        //Caso positivo cuando ingresa todo correctamente

        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passengerFirstName")));
        firstName.sendKeys("John");
        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passengerLastName")));
        lastName.sendKeys("Doe");

        // la pagina se recarga despues del error, hay que volver a buscar el boton
        btnnext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']")));
        btnnext.click();

        //VALIDAMOS QUE LLEGAMOS A LA PAGINA DE PAGO
        WebElement tituloPago = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Pay by Credit Card']")));
        Assert.assertTrue(tituloPago.isDisplayed(),"Deberia mostrarse la pagina de pago");

    }

    //PASO 4: PAGO CON TARJETA
    @Test(priority = 4, description = "Validar el pago con tarjeta de credito")
    public void Pago(){

        WebElement radioVisa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='card_type' and @value='visa']")));
        if(!radioVisa.isSelected()){
            radioVisa.click();
        }
        Assert.assertTrue(radioVisa.isSelected(),"Visa deberia estar seleccionada");

        //El nombre del titular viene precargado con el pasajero
        WebElement holderName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("holder_name")));
        Assert.assertEquals(holderName.getAttribute("value"),"John Doe","El titular deberia ser el pasajero");

        WebElement cardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("card_number")));
        cardNumber.sendKeys("4111111111111111");

        //Dropdown mes de vencimiento
        Select mesVencimiento = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.name("expiry_month"))));
        mesVencimiento.selectByVisibleText("12");

        //Dropdown año de vencimiento
        Select anioVencimiento = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.name("expiry_year"))));
        anioVencimiento.selectByVisibleText("2028");

        WebElement btnPagar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Pay now']")));
        btnPagar.click();

    }

    //PASO 5: CONFIRMACION DE LA RESERVA
    @Test(priority = 5, description = "Validar la confirmacion de la reserva")
    public void Confirmacion(){

        //La confirmacion se carga por AJAX dentro del div #confirmation
        WebElement bookingNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("booking_number")));
        Assert.assertFalse(bookingNumber.getText().isEmpty(),"Deberia generarse un numero de reserva");

        WebElement confirmacion = driver.findElement(By.id("confirmation"));
        Assert.assertTrue(confirmacion.getText().contains("Sydney"),"La reserva deberia salir de Sydney");
        Assert.assertTrue(confirmacion.getText().contains("New York"),"La reserva deberia llegar a New York");
        Assert.assertTrue(confirmacion.getText().contains("John Doe"),"La reserva deberia estar a nombre de John Doe");

        System.out.println("Reserva confirmada, numero: " + bookingNumber.getText());
    }

}