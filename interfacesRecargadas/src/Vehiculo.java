public class Vehiculo implements Movible {
private int id;
private double caballosPotencia;
private String nombre;

    public Vehiculo(int id, double caballosPotencia, String nombre) {
        this.id = id;
        this.caballosPotencia = caballosPotencia;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCaballosPotencia() {
        return caballosPotencia;
    }

    public void setCaballosPotencia(double caballosPotencia) {
        this.caballosPotencia = caballosPotencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
