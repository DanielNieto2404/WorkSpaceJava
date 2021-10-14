public class Hilo extends Thread{
    private int numero;
    public Hilo(int numero) {
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
    @Override
    public void run() {
        System.out.println("Arrancando hilo: " + Thread.currentThread().getName());
        for (int i = 0; i < 20; i++) {

            try {
                Thread.sleep(500);//simulacion de tarea que tarda 500 milisegungdos
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }// 0.5 segundos

            System.out
                    .println("Hilo: " + Thread.currentThread().getName()
                            + " , dice: " + numero + " ciclo: " + i);
        }
        System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
    }
}
