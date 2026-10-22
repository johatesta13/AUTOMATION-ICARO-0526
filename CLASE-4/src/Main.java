public class Main {

    void main(){

        //Instanciar o crear un objeto

        Estudiante estudiante1 = new Estudiante(1001,"Maria Gonzalez", 9.0f);
        Estudiante estudiante = new Estudiante(1002,"Roberto Gomez", 8.0f);

        //Mostrando datos

        System.out.println("DATOS DEL ESTUDIANTE");
        System.out.println("ID: " + estudiante1.getId());
        System.out.println("Nombre: " + estudiante1.getNombreCompleto());
        System.out.println("Promedio: " + estudiante1.getPromedio());

        System.out.println("NUEVO PROMEDIO DE MARIA" +"PROMEDIO ACTUAL" + estudiante1.getPromedio());
        estudiante1.setPromedio(9.5f);
        System.out.println("Promedio Nuevo: " + estudiante1.getPromedio());



    }
}
