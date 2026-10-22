import java.util.ArrayList;

public class Profesor extends Persona{

    private ArrayList<Alumno> alumnos;


    public Profesor() {
        super();
    }

    public Profesor(String nombre, String apellido){
        super(nombre,apellido);
        this.alumnos = new ArrayList<>();
    }

  // Getter y setter
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    //Metodo para agregar alumnos a la lista

    public void AgregarAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }//Alumno alumno1 = new Alumno(parametros)
    //alumno1.agregarMateria("Matematica");
    //Profesor profe = new Profesor("Pepe", "Pepe")
    //profe.AgregarAlumno(alumno1)
}
