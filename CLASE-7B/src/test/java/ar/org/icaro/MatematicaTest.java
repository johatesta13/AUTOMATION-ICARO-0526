package ar.org.icaro;


import org.testng.Assert;
import org.testng.annotations.Test;

public class MatematicaTest {



    @Test
    public void ValidarSuma(){

        int resultado = Matematica.Suma(4,5);

        Assert.assertEquals(resultado,9,"El resultadon deberia ser 9");
        System.out.println("El test paso correctamente el resultado es: " + resultado);
    }
}
