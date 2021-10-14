package persistencia.interfaces;

import java.util.List;
import modelo.Coche;

public interface DaoCoche {
    public boolean alta(Coche p);
    public boolean baja(int id);
    public boolean modificar(Coche p);
    public Coche obtener(int id);
    public List<Coche> listar();
}
