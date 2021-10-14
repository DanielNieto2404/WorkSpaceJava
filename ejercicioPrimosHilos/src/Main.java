import java.util.Scanner;

public class Main extends Thread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el primer numero:");
        int num1 = sc.nextInt();
        System.out.print("Introduce el segundo numero:");
        int num2 = sc.nextInt();
        System.out.print("Introduce el tercer numero:");
        int num3 = sc.nextInt();
        Hilo hilo1 = new Hilo(num1);
        Hilo hilo2 = new Hilo(num2);
        Hilo hilo3 = new Hilo(num3);
        try {
            //Duerme el hilo que passe por aqui durante un tiempo
            //En este caso, siempre sera el main
            System.out.println("Esperando 5 segundos a arrancar los hilos... :), que nervios...");
            Thread.sleep(5000);//5 seg
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //arrancamos los dos hilos
        //ojo no se ejecuta run()
        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("Hilo principal parando");
    }

}
