import java.util.Scanner;

public class MenuCafeteria {



    public void main(){

        Scanner scanner = new Scanner(System.in);


        System.out.println("MENU DE LA CAFETERIA");
        System.out.println("1. Cafe con leche");
        System.out.println("2. Tostado de JYQ");
        System.out.println("3. Medilunas");
        System.out.println("4. Salir");
        System.out.println("SELECIONA UNA OPCION DEL 1 AL 4");

        int opcion = scanner.nextInt();

        switch (opcion){

            case 1:
                System.out.println("Preparando cafe con leche");
             break;
            case 2:
                System.out.println("Ya sale tu tostado de JyQ");
            break;
            case 3:
                System.out.println("Medialunas para la mesa x");
             break;
            case 4:
                System.out.println("Gracias por venir");
            break;
            default:
                System.out.println("Opcion incorrecta, volve a intentar");

        }

        scanner.close();

    }
}
