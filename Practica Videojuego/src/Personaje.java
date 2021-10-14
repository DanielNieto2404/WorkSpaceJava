public abstract class Personaje {
    public String nombre;
    public Arma arma;
    public int puntosVida;
     public int atributoEspecial;

    public Personaje(String nombre, Arma arma, int puntosVida, int atributoEspecial) {
        this.nombre = nombre;
        this.arma = arma;
        this.puntosVida = puntosVida;
        this.atributoEspecial = atributoEspecial;
    }

    public abstract void atacar(Personaje enemigo);
}
