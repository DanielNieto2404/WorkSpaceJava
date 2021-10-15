package negocio;

import modelo.Coche;
import persistencia.DaoCocheMySql;
import persistencia.interfaces.DaoCoche;

import java.util.List;

public class GestorNegocio {
    DaoCoche cocheDao = new DaoCocheMySql();

    public boolean alta(Coche c){
        //aplicamos la regla de negocio
        if(c.getMatricula().length() == 7 || c.getMarca().isEmpty() || c.getModelo().isEmpty()) {
            boolean alta = cocheDao.alta(c);
            return alta;
        }
        return false;
    }

    public boolean baja(int id){
        boolean baja = cocheDao.baja(id);
        return baja;
    }

    public boolean modificar(Coche c, int id){
        //aplicamos la regla de negocio
        if(c.getMatricula().length() == 7 || c.getMarca().isEmpty() || c.getModelo().isEmpty()) {
            boolean modificada = cocheDao.modificar(c, id);
            return modificada;
        }
        return false;
    }

    public Coche obtener(int id){
        Coche coche = cocheDao.obtener(id);
        return coche;
    }

    public List<Coche> listar(){
        List<Coche> listaCoches = cocheDao.listar();
        return listaCoches;
    }
}
