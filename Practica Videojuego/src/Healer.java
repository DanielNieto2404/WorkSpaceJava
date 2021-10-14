import java.util.Random;

public class Healer extends Personaje {
    public Healer(String nombre, Arma arma, int puntosVida, int atributoEspecial) {
        super(nombre, arma, puntosVida, atributoEspecial);
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Curare a mis compañeros, soy el gran  " + nombre);
        arma.usar();
        Random rand = new Random();
        boolean critico = false;
        int posivilidadCritico = rand.nextInt(10);
        if (posivilidadCritico == 7){
            critico = true;
        }else {
            critico = false;
        }
        if (critico){
            if(arma.claseBoost == "Healer"){
                System.out.println("Este arma me gusta, toma esta");
                enemigo.puntosVida -= (Math.floor(Math.random()*(arma.dañoMax-arma.dañoMin+1)+arma.dañoMin) + atributoEspecial) * arma.multiplicadorCritico;

            }else {
                System.out.println("Este armas no me gusta");
                enemigo.puntosVida -= Math.floor(Math.random()*(arma.dañoMax-arma.dañoMin+1)+arma.dañoMin) * arma.multiplicadorCritico;
            }
            System.out.println("Has metido un critico de " + arma.multiplicadorCritico + " x");
        }else {
            if(arma.claseBoost == "Healer"){
                System.out.println("Este arma me gusta, toma esta");
                enemigo.puntosVida -= (Math.floor(Math.random()*(arma.dañoMax-arma.dañoMin+1)+arma.dañoMin) + atributoEspecial);
            }else {
                System.out.println("Este armas no me gusta");
                enemigo.puntosVida -= Math.floor(Math.random()*(arma.dañoMax-arma.dañoMin+1)+arma.dañoMin);
            }
        }
    }
}
