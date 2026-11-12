package ar.org.icaro;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class UsuarioTest {

    Usuario usuario;
    Usuario usuari10;


    @BeforeMethod
    public void SetUP() {
        usuario = new Usuario("Joha", "pass");
        usuari10 = new Usuario("Joha", "pas");
    }


    @Test(priority = 1, description = "Validamos login exitoso con credenciales validas")
    public void loginExitoso() {

        boolean resultado = usuario.login("pass");
        Assert.assertTrue(resultado, "Se esperaba login correcto");
        Assert.assertTrue(usuario.isEstaLogueado(),"DEBERIA ESTAR LOGUEADO");


    }

    @Test(priority = 1, description = "Validamos login fallido con credenciales invalidas")
    public void loginfallido() {

        boolean resultado =usuario.login("jhsjsjsj");

        Assert.assertFalse(usuario.isEstaLogueado(),"No deberia estar logueado");
        Assert.assertFalse(resultado,"El usuario no tiene que loguearse");


    }



}
