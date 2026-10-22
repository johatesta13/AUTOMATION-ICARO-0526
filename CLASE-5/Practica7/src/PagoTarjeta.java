public class PagoTarjeta extends Pago {
    private int cuotas;

    public PagoTarjeta(double monto,int cuotas) {
        super(monto);
        this.cuotas = cuotas;
    }

    @Override
    public void procesar() {
        System.out.println("Pagaste con tarjeta en " + cuotas + "cuotas de $: " + monto/cuotas);

    }


}
