import java.util.List;

public class ValidacionesYOrdenamiento {

    public Producto busquedaSecuencialNombre (String nombre, List<Producto> menu){

        for (int i=0; i< menu.size();i++){
            Producto producto = menu.get(i);
            if (producto.getNombre().equalsIgnoreCase(nombre)){
                return producto;
            }
        }

        return null;
    }
    public Producto busquedaSecuencialDescripcion (String descripcion, List<Producto> menu){

        for (int i=0; i< menu.size();i++){
            Producto producto = menu.get(i);
            if (producto.getDescripcion().equalsIgnoreCase(descripcion)){
                return producto;
            }
        }

        return null;
    }
    public Cliente busquedaSecuencialCedula (String cedula, List<Cliente> registro){

        for (int i=0; i< registro.size();i++){
            Cliente cliente = registro.get(i);
            if (cliente.getCedula().equalsIgnoreCase(cedula)){
                return cliente;
            }
        }

        return null;
    }
}
