import java.util.Timer;
import java.util.TimerTask;

public class Hilo extends Thread{
    private int numero;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Hilo() {

    }
    @Override
    public void run( ) {
        Timer timer = new Timer("Timer");
        TimerTask timerTask = new TimerTask(){
            public void run() {
                System.out.println("Arrancando hilo: " + Thread.currentThread().getName());

                Boolean esPrimoActual = true;
                if(numero<2)
                {
                    esPrimoActual = false;
                }
                else
                {
                    for(int x=2; x*x<=numero; x++)
                    {
                        if( numero%x==0 ){esPrimoActual = false;break;}
                    }
                }
                if (esPrimoActual){
                    System.out.println(numero + " es primo");
                }else {
                    System.out.println(numero + " no es primo");
                }

            }
        };
        timer.schedule(timerTask, 30);
        System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado" + timer.toString());
    }
}
