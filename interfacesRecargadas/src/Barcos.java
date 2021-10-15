public class Barcos extends Vehiculo{
    public Barcos(int id, double caballosPotencia, String nombre) {
        super(id, caballosPotencia, nombre);
    }

    //Implementar metodo mover cambido para Barcos
    @Override
    public void mover() {
        int metrosTotal = (int) (metros + (this.getCaballosPotencia() * 2));
        System.out.println("El vehiculo "+this.getNombre() +" se ha movido " + metrosTotal + " Km");
    }
}
