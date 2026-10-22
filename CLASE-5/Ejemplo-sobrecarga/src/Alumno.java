import java.util.ArrayList;

public class Alumno extends Persona{


    private int nota;

    private String matricula;
    private ArrayList<String> materias;

    public Alumno(){
        super();
        this.materias = new ArrayList<>();
    }

    public Alumno(String nombre, String apellido, String matricula) {
        super(nombre, apellido);
        this.matricula = matricula;

        this.materias = new ArrayList<>();

    }
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    };

    public void Saludar(){
        System.out.println("Que onda!");
    }

}
