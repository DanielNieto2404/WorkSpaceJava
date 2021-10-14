public abstract class Arma {
    public String nombre;
    public int dañoMax;
    public int dañoMin;
    public String claseBoost;
    public  double multiplicadorCritico;

    public Arma(String nombre, int dañoMax, int dañoMin, String claseBoost, double multiplicadorCritico) {
        this.nombre = nombre;
        this.dañoMax = dañoMax;
        this.dañoMin = dañoMin;
        this.claseBoost = claseBoost;
        this.multiplicadorCritico = multiplicadorCritico;
    }

    public abstract void usar();
}