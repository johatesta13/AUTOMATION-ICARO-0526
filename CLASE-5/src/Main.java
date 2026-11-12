public class Main{
    void main() {
        Perro max = new Perro("Max",3);
        Gato garfield = new Gato("Garfield",4);


        System.out.println(max.getNombre() + " dice " + max.comunicarse());
        System.out.println(garfield.getNombre() + " dice " + garfield.comunicarse());

        //Polimorfismo

        Animal animal1 = new Perro("Firulais",6);
        Animal animal2 = new Gato("michi", 9);

        System.out.println(animal1.comunicarse());
        System.out.println(animal2.comunicarse());


    }

}