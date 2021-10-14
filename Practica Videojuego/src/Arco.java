public class Arco extends Arma{

    public Arco(String nombre, int dañoMax, int dañoMin, double multiplicadorCritico) {
        super(nombre, dañoMax, dañoMin, "Arquero", 2.5);
    }

    public void usar(){
        System.out.println("Fiummm");
    }
}
