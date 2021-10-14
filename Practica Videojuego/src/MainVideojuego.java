import java.util.Random;

public class MainVideojuego {
    public static void main(String[] args) {
        Espada espada = new Espada("Espada de las mil verdades", 50, 30);

        Hechizo hechizo = new Hechizo("Bola de fuego", 45,40);
       Guerrero guerrero = new Guerrero("Conan", espada, 100, 10 );
       Mago mago = new Mago("Gandalf", hechizo, 90, 5);
       guerrero.atacar(mago);
        System.out.println(mago.puntosVida);

    }


    public void crearEnemigo(){
        Random rand = new Random();
        int random = rand.nextInt(4);
        int boss = rand.nextInt(1000);
        Espada espada = new Espada("Espada bastarda", 40, 25);
        Espada mazaSauron = new Espada("Maza de sauron", 100, 75);
        if (boss == 756){
            Guerrero guerrero = new Guerrero("Sauron", mazaSauron, 500, 20);
        }else {
            if (random == 0){
                //Crear guerrero enemigo
            }else  if(random == 1){
                // generar enemigo arquero
            }else if (random == 2){
                //generar enemgio mago
            }else {
                //generar enemigo healer
            }
        }

    }

    public void generarArmas(){
        
    }
}
