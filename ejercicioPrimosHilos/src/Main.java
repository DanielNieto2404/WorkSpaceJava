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
        Hilo hilo1 = new Hilo();
        hilo1.setNumero(num1);
        Hilo hilo2 = new Hilo();
        hilo2.setNumero(num2);
        Hilo hilo3 = new Hilo();
        hilo3.setNumero(num3);



        //arrancamos los dos hilos
        //ojo no se ejecuta run()
        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("Hilo principal parando");
    }

}
