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

    public void AgregarAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }//Alumno alumno1 = new Alumno(parametros)
    //alumno1.agregarMateria("Matematica");
    //Profesor profe = new Profesor("Pepe", "Pepe")
    //profe.AgregarAlumno(alumno1)


    //Sobrecarga 1: califica a un alumno en especifico

    public void calificar(Alumno alumno, int nota){

        alumno.setNota(nota);
    }

    //Sobrecarga 2 : califica a todos los alumnos
    public void calificar(int nota){

        for (Alumno alumno: alumnos ){
            alumno.setNota(nota);
        }

    }

    public void Saludar(){
        System.out.println("Hola a todos, bienvenidos");
    }


    public void MostrarNota(){
        System.out.println("NOTA DE TODOS LOS ALUMNOS");

        for (Alumno alumno : alumnos){
            System.out.println(alumno.getNota());
        }
    }
}
