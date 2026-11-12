public class Main{
    void main() {


             Alumno juan = new Alumno("Juan","Perez","AAA--0000");
             Alumno juanA = new Alumno("Juana","Lopez","AAA--0001");
             Alumno Maria = new Alumno("Maria","Romero","AAA--0002");


             Profesor profe = new Profesor("Alberto","Hernandez");
             profe.AgregarAlumno(juan);
             profe.AgregarAlumno(juanA);
             profe.AgregarAlumno(Maria);


             NoDocente noDocente = new NoDocente("Julia","juarez");


             //SOBRECARGA 1; CALIFICAR A UN ALUMNO EN ESPECIFICO juan

             profe.calificar(juan,9);
             System.out.println(juan.getNota());

             //SOBRECARGA 2 CALIFICAR A TODOS LOS ALUMNOS
             profe.calificar(10);

             profe.MostrarNota();


        }
}


