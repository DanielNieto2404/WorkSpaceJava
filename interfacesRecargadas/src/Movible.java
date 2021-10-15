public interface Movible {
    int metros = 10;
    default void mover(){
        if(this instanceof Vehiculo){
            Vehiculo v = (Vehiculo)this;
            System.out.println("El vehiculo "+v.getNombre() +" se ha movido " + metros + " Km");
        }

    }
}
