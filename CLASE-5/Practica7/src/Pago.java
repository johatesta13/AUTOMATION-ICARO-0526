public abstract class Pago {

    protected double monto;


    public Pago(double monto) {
        this.monto = monto;
    }

    public abstract void procesar();

    public void mostrarMonto(){
        System.out.println("Monto " + monto);
    }
}
