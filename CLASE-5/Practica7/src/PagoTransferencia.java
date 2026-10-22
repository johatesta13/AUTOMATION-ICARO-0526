public class PagoTransferencia extends Pago{

    private String alias;

    public PagoTransferencia(double monto, String alias) {
        super(monto);
        this.alias = alias;
    }

    @Override
    public void procesar() {
        System.out.println("Pagando con transferencia al alias: " + alias + "Monto enviado: " + monto);
    }
}
