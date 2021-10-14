import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        String cadenaConexion = "jdbc:mysql://localhost:3306/concesionario";
        String user = "root";
        String pass = "Bambi2004";
        Connection con = null;
        try{
            con = DriverManager.getConnection(cadenaConexion, user, pass);
            String matricula = "Ernion G�esley";
            String marca = "Seat";
            String modelo = "Ibiza";

            //Esta menera NO se debe usar nunca, se debe usar SIEMPRE
            //preparedStatement, lo vemos solo para fines didacticos
            String sql = "INSERT INTO PERSONAS " +
                    "(matricula, modelo, marca) " +
                    "VALUES ('" + matricula + "', '" + modelo + "', '" + marca +  "');";
            System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
            System.out.println(sql);

            //siguiente paso es mandar la query a traves de la conexi�n
            Statement sentencia;//esta clase NO se debe usar, el que la use en las practicas esta suspenso
            sentencia = con.createStatement();
            //Ejecutamos la query, y nos devuelve las filas afectadas (dadas de alta)
            int filasAfectadas = sentencia.executeUpdate(sql);

            System.out.println("Sentencia SQL ejecutada con �xito");
            System.out.println("Registros afectados: " + filasAfectadas);
            System.out.println("Se ha establecido la conexi�n con la Base de datos");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from vehiculos ");
            PreparedStatement statement = con.prepareStatement("Select * from vehiculos where marca = ?");
            statement.setString(1,"Seat");
        } catch (SQLException e) {
            System.out.println("Error al a�adir una nueva persona");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }




    }
    }


