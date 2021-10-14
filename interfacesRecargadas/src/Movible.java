public interface Movible {
    default void mover(int distancia){
        System.out.println("El vehiculo se ha movido " + distancia + " Km");
    }
}
