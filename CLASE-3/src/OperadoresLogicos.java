public class OperadoresLogicos {

    void main(){

        int edad = 18;
        boolean tieneEntrada = false;


        boolean PUEDEENTRAR = (edad >=18) && (tieneEntrada);
        //true && true --> true
        //true && false --> false

        System.out.println(PUEDEENTRAR);

        boolean Puedeentrar = (edad >=18) || (tieneEntrada);
        // true || false --> true
        // false || false --> false

        System.out.println(Puedeentrar);

        boolean negacionlogica = !(edad >=18) || (tieneEntrada);
        System.out.println(negacionlogica);

    }
}
