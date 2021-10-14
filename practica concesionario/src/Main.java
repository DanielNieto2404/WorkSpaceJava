import modelo.Coche;
import negocio.GestorNegocio;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException{
        String matricula;
        String modelo;
        String marca;
        String idString;
        int id;
        Coche coche;
        GestorNegocio gestorNegocio = new GestorNegocio();
        Scanner sc = new Scanner(System.in);
        boolean entrar = true;
        while (entrar){
            System.out.println("Elige una de las siguientes opcion \n" +
                    "1.alta \n" +
                    "2.Baja \n" +
                    "3.Modificar \n" +
                    "4.Obtener \n" +
                    "5.Listar \n" +
                    "6.Salir");
            System.out.print("opcion:");
            switch (sc.nextLine()){
                case "1":
                    System.out.println("Introduce matricula:");
                    matricula = sc.nextLine();
                    System.out.println("Introduce modelo:");
                    modelo = sc.nextLine();
                    System.out.println("Introduce marca");
                    marca=sc.nextLine();
                    gestorNegocio.alta(crearCoche(matricula,modelo,marca));
                    break;
                case "2":
                    System.out.println("Elije la id que desas borrar");
                    gestorNegocio.listar().forEach(System.out::println);
                    System.out.println("id:");
                    idString = sc.nextLine();
                     id = Integer.parseInt(idString);
                    gestorNegocio.baja(id);
                    break;
                case "3":
                    System.out.println("Elije la id que desas modificar");
                    gestorNegocio.listar().forEach(System.out::println);
                    System.out.println("id:");
                    idString = sc.nextLine();
                     id = Integer.parseInt(idString);
                    System.out.println("Introduce matricula:");
                    matricula = sc.nextLine();
                    System.out.println("Introduce modelo:");
                    modelo = sc.nextLine();
                    System.out.println("Introduce marca");
                    marca=sc.nextLine();
                    gestorNegocio.modificar(crearCoche(matricula,modelo,marca), id);
                    break;
                case "4":
                    System.out.println("Elije la id que desas obtener");
                    gestorNegocio.listar().forEach(System.out::println);
                    System.out.println("id:");
                    idString = sc.nextLine();
                    id = Integer.parseInt(idString);
                    System.out.println(gestorNegocio.obtener(id).toString());
                    break;
                case "5":
                    gestorNegocio.listar().forEach(System.out::println);
                    break;
                case "6":
                    entrar = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }

    public static Coche crearCoche( String matricula,String marca, String modelo){
        Coche coche = new Coche();
        coche.setMatricula(matricula);
        coche.setMarca(marca);
        coche.setModelo(modelo);
        return coche;
    }
}
