public class Estudiante {


    private int id;
    private String nombreCompleto;
    private float promedio;

    //Contrusctor vacio

    public Estudiante() {}




    //Constructor con parametros

    public Estudiante(int id, String nombreCompleto, float promedio) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.promedio = promedio;
    }// Estudiante estudiante1 = new Estudiante (202020202,"pepito", 10.0f)

    //Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
}
