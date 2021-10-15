import com.mysql.cj.result.Row;
import modelo.Coche;
import negocio.GestorNegocio;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import persistencia.DaoCocheMySql;

import java.io.*;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
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
                    "6.Exportar como CSV \n" +
                    "7. Exportar como Excel \n" +
                    "8.Salir");

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
                    try {
                        crearFicheroCVS();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "7":
                    try {
                        crearFicheroExcel();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "8":
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
    public static void crearFicheroCVS() throws IOException {
        DaoCocheMySql daoCoche = new DaoCocheMySql();
        List<Coche> coches = daoCoche.listar();
//create a CSV printer
        BufferedWriter writer = java.nio.file.Files.newBufferedWriter(Paths.get("cars.csv"));
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
//create header row
        printer.printRecord("Id", "Matricula", "Modelo", "Marca");
// create data rows

        for(Coche coche : coches){

            printer.printRecord(coche.getId(), coche.getMatricula(), coche.getModelo(),coche.getMarca());
        }
//close the printer after the file is complete
        printer.flush();
        printer.close();
    }

    public static void crearFicheroExcel() throws FileNotFoundException {
        DaoCocheMySql daoCoche = new DaoCocheMySql();
        List<Coche> coches = daoCoche.listar();
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowCount = 0;

        for (Coche coche : coches) {
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(++rowCount);

            writeCar(coche, row);
        }
        OutputStream fileOut = new FileOutputStream("D:\\workspace\\ej08_BDMaven\\coches.xlsx");
        try (FileOutputStream outputStream = new FileOutputStream("D:\\workspace\\ej08_BDMaven\\coches.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void writeCar(Coche coche, org.apache.poi.ss.usermodel.Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(coche.getId());

        cell = row.createCell(2);
        cell.setCellValue(coche.getMatricula());

        cell = row.createCell(3);
        cell.setCellValue(coche.getModelo());

        cell = row.createCell(4);
        cell.setCellValue(coche.getMarca());
    }


}
