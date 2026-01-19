public class Rekursion {
    public Rekursion(){}

    public void sayHello() {
        //mache ne println
        // eine Syso
        //und rufe die methode selber nochmal auf
        System.out.println();
        System.out.println("Hello there!");
        sayHello();
    }
}
