
public class Main {

    void main(){

        PagoTarjeta pagoTarjeta = new PagoTarjeta(14000,3);
        pagoTarjeta.procesar();

        PagoTransferencia pagoTransferencia = new PagoTransferencia(5000,"johanita.mp");
        pagoTransferencia.procesar();

    }
}