import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{
        String cadenaConexion = "jdbc:mysql://localhost:3306/concesionario";
        String user = "root";
        String pass = "Bambi2004";
        Connection con;
        try {
            con = DriverManager.getConnection(cadenaConexion, user, pass);
        } catch (SQLException e) {
            System.out.println("No se ha podido establecer la conexi�n con la BD");
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Se ha establecido la conexi�n con la Base de datos");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from vehiculos ");
       // PreparedStatement statement = con.prepareStatement("Select * from cliente where nombre = ?");
        // statement.setString(1,"DELGADO PEREZ MARISA");


        while(rs.next())
            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        con.close();
    }
}
