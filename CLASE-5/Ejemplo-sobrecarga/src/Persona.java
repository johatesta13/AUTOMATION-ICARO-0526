public class Persona {


    private String nombre;
    private String apellido;



    //Constructor Vacio
    public Persona() {
    }
    // Constructor con parametros
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void Saludar(){
       System.out.println("Hola, como estan?");
   }




}
