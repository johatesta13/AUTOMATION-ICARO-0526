public class TryAndCatch1 {

    void main(){

        String texto = "20";

        try{
            int numero = Integer.parseInt(texto);
            System.out.println("El valor del numero es: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("El texto ingresado no es un numero ");
        }
        finally {
            System.out.println();
            System.out.println("ESTE BLOQUE SIEMPRE SE EJECUTA");
        }


    }
}
