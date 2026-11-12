public class Main {

    void main(){

        Cuenta cuenta = new Cuenta(3000.60);

        try {
            cuenta.retirar(500);
            System.out.println("RETIRO EXITOSO");
            System.out.println("Realizando segunda operacion");
            cuenta.retirar(3000);


        } catch (SaldoInsuficienteExeption e) {
            System.out.println("ERROR " + e.getMessage());
        }

    }


}