package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Coche;
import persistencia.interfaces.DaoCoche;

public class DaoCocheMySql implements DaoCoche {

    private Connection conexion;
    public boolean abrirConexion(){
        String url = "jdbc:mysql://localhost:3306/concesionario";
        String usuario = "root";
        String password = "Bambi2004";
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



    @Override
    public boolean alta(Coche p) {
        if(!abrirConexion()){
            return false;
        }
        boolean alta = true;

        String query = "insert into personas (NOMBRE,EDAD,PESO) "
                + " values(?,?,?)";
        try {
            //preparamos la query con valores parametrizables(?)
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, p.getMatricula());
            ps.setString(2, p.getModelo());
            ps.setString(3, p.getMarca());

            int numeroFilasAfectadas = ps.executeUpdate();
            if(numeroFilasAfectadas == 0)
                alta = false;
        } catch (SQLException e) {
            System.out.println("alta -> Error al insertar: " + p);
            alta = false;
            e.printStackTrace();
        } finally{
            cerrarConexion();
        }

        return alta;
    }


    public boolean baja(int id) {
        if(!abrirConexion()){
            return false;
        }

        boolean borrado = true;
        String query = "delete from personas where id = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            //sustituimos la primera interrgante por la id
            ps.setInt(1, id);

            int numeroFilasAfectadas = ps.executeUpdate();
            if(numeroFilasAfectadas == 0)
                borrado = false;
        } catch (SQLException e) {
            borrado = false;
            System.out.println("baja -> No se ha podido dar de baja"
                    + " el id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return borrado;
    }

    @Override
    public boolean modificar(Coche p) {
        if(!abrirConexion()){
            return false;
        }
        boolean modificado = true;
        String query = "update personas set NOMBRE=?, EDAD=?, "
                + "PESO=? WHERE ID=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, p.getMatricula());
            ps.setString(2, p.getModelo());
            ps.setString(3, p.getMarca());

            int numeroFilasAfectadas = ps.executeUpdate();
            if(numeroFilasAfectadas == 0)
                modificado = false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("modificar -> error al modificar la "
                    + " persona " + p);
            modificado = false;
            e.printStackTrace();
        } finally{
            cerrarConexion();
        }

        return modificado;
    }

    @Override
    public Coche obtener(int id) {
        if(!abrirConexion()){
            return null;
        }
        Coche persona = null;

        String query = "select ID,NOMBRE,EDAD,PESO from personas "
                + "where id = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                persona = new Coche();
                persona.setMatricula(rs.getString(1));
                persona.setModelo(rs.getString(2));
                persona.setModelo(rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("obtener -> error al obtener la "
                    + "persona con id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }


        return persona;
    }

    @Override
    public List<Coche> listar() {
        if(!abrirConexion()){
            return null;
        }
        List<Coche> listaPersonas = new ArrayList<>();

        String query = "select ID,NOMBRE,EDAD,PESO from personas";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Coche persona = new Coche();
                persona.setMatricula(rs.getString(1));
                persona.setModelo(rs.getString(2));
                persona.setMarca(rs.getString(3));

                listaPersonas.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("listar -> error al obtener las "
                    + "personas");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }


        return listaPersonas;
    }
}
