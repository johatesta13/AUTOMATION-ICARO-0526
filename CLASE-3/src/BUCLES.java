import java.util.Scanner;

public class BUCLES {

    void main(){

       /* Scanner sc = new Scanner(System.in);

        //CASO 1: VENDER PRODUCTOS MIENTRAS HAYA STOCK

        //1. while primero va a chequear si hay stock y luego va a ejecutar si
        //stock = 0 no ejecuta

        int stock = 3;

        while (stock > 0){

            System.out.println("Vendiste un producto");
            System.out.println("restando stock");
            stock = stock - 1;
            System.out.println(stock);
        }


        System.out.println("---DO WHILE----");

        int stock2 =3;
        do {
            System.out.println("Vendiste un producto");
            System.out.println("restando stock");
            stock2 = stock2 - 1;
            System.out.println(stock2);
        }while (stock2 > 0);
        */


        //FOR CALCULAR CUANTOS PRODUCTOS TENGO EN UN CARRITO DE COMPRAS

        String[] productos = {"REMERA", "CARTERA", "BUZO"};
        int[] precios = {2000,300,400};
        int total =0;

        for(int i= 0 ; i < precios.length ; i++){

            System.out.println(productos[i] + "$" + precios[i]);

            total += precios[i];
        }

        System.out.println("Total a pagar: $" + total);




    }
}
