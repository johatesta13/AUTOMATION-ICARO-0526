public class Cuenta {

    private double saldo;


    public Cuenta(double saldo) {
        this.saldo = saldo;
    }


    public void retirar(double monto) throws SaldoInsuficienteExeption{

        if(monto > saldo){
            throw new SaldoInsuficienteExeption("No tenes saldo suficiente para realizar esta operacion");

        }

        saldo -=monto;
    }
}
