import java.util.Random;

public class Guerrero extends Personaje {
    public Guerrero(String nombre, Arma arma, int puntosVida, int atributoEspecial) {
        super(nombre, arma, puntosVida, atributoEspecial);
    }

    @Override
    public void atacar(Personaje enemigo) {
        int puntosVidaIniciales = enemigo.puntosVida;
        System.out.println("Mi punteria es certera, soy  " + nombre);
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
            if(arma.claseBoost == "Guerrero"){
                System.out.println("Este arma me gusta, toma esta");
                enemigo.puntosVida -= (Math.floor(Math.random()*(arma.dañoMax-arma.dañoMin+1)+arma.dañoMin) + atributoEspecial) * arma.multiplicadorCritico;

            }else {
                System.out.println("Este armas no me gusta");
                enemigo.puntosVida -= Math.floor(Math.random()*(arma.dañoMax-arma.dañoMin+1)+arma.dañoMin) * arma.multiplicadorCritico;
            }
            System.out.println("Has metido un critico de " + arma.multiplicadorCritico + " x");
        }else {
            if(arma.claseBoost == "Guerrero"){
                System.out.println("Este arma me gusta, toma esta");
                enemigo.puntosVida -= (Math.floor(Math.random()*(arma.dañoMax-arma.dañoMin+1)+arma.dañoMin) + atributoEspecial);
            }else {
                System.out.println("Este armas no me gusta");
                enemigo.puntosVida -= Math.floor(Math.random()*(arma.dañoMax-arma.dañoMin+1)+arma.dañoMin);
            }
        }

        System.out.println(puntosVidaIniciales - enemigo.puntosVida);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
}
