public class Main {

    void main() {

        Alumno alumno1 = new Alumno("Juan", "Perez", "2021-2B");

        alumno1.agregarMateria("Matematica");
        alumno1.agregarMateria("Programacion");
        alumno1.agregarMateria("base de datos");

        Profesor profesor1 = new Profesor("Ana", "Martinez");
        profesor1.AgregarAlumno(alumno1);

        NoDocente nodocente1 = new NoDocente("Carlos", "Lopez", "Administrativo");


        //Alumno
        System.out.println("=====ALUMNO======");
        System.out.println("Nombre: " + alumno1.getNombre());
        System.out.println("Apellido: " +alumno1.getApellido());
        System.out.println("Matricula: " + alumno1.getMatricula());
        System.out.println("Materias del alumno: " + alumno1.getMaterias());


        //Profesor
        System.out.println("=====Profesor======");
        System.out.println("Nombre: " + profesor1.getNombre() + "Apellido: " + profesor1.getApellido());
        System.out.println("Cantidad de alumnos del profesor" + profesor1.getAlumnos().size());

        //No docente
        System.out.println("=====NO docente======");
        System.out.println("Nombre: " + nodocente1.getNombre() + "Apellido: " + nodocente1.getApellido() + "Area: " + nodocente1.getArea());



    }
}
