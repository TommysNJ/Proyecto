import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Producto> lista = new ArrayList<>();
    private ValidacionesYOrdenamiento orden = new ValidacionesYOrdenamiento();
    JComboBox<String> comboBox = new JComboBox<>();

    public List<String> mostrarProductosAdmin(){
        List<String> list = new ArrayList<>();
        for (Producto prod : lista){
            list.add(prod.toString() + "Cantidad disponible: " + prod.getCantidad() + "\n\n");
        }
        return list;
    }

    public boolean agregarProducto (Producto producto, JComboBox<String>combobox){
        String nombre = producto.getNombre();
        String descripcion = producto.getDescripcion();
        if (orden.busquedaSecuencialNombre(nombre, lista) == null && orden.busquedaSecuencialDescripcion(descripcion,lista)==null) {
            lista.add(producto);
            combobox.addItem(producto.getNombre());
            return true;
        } else {
            return false;
        }
    }
    public void quemarProductos (JComboBox<String> comboBox){
        Producto prod1 = new Producto("Producto01", "Papa", 2000, 5);
        Producto prod2 = new Producto("Producto02", "Salchi", 200,5);
        Producto prod3 = new Producto("Producto03", "Carni", 300,5);
        Producto prod4 = new Producto("Producto04", "Pollo", 2000,5);
        Producto prod5 = new Producto("Producto05", "Sopa", 25,5);
        lista.add(prod1);
        comboBox.addItem(prod1.getNombre());
        lista.add(prod2);
        comboBox.addItem(prod2.getNombre());
        lista.add(prod3);
        comboBox.addItem(prod3.getNombre());
        lista.add(prod4);
        comboBox.addItem(prod4.getNombre());
        lista.add(prod5);
        comboBox.addItem(prod5.getNombre());
    }

    public Producto imprimirProducto (String nombre){
        if (orden.busquedaSecuencialNombre(nombre,lista)!=null){
            return orden.busquedaSecuencialNombre(nombre,lista);
        }
        return null;
    }
    public String imprimirProductoCantidad (String nombre){
        return orden.busquedaSecuencialNombre(nombre,lista).toString()+ "Cantidad disponible: " + orden.busquedaSecuencialNombre(nombre,lista).getCantidad() + "\n\n";
    }

    public boolean eliminarProducto (String nombre, JComboBox<String> combobox){
        for (int i=0;i<lista.size();i++){
            if (lista.get(i).getNombre().equalsIgnoreCase(nombre)){
                lista.remove(i);
                actualizarComboBox(combobox);
                return true;
            }
        }
        return false;
    }
    public boolean modificarProducto (String nombre, String descripcion, double precio) {
        Producto producto = orden.busquedaSecuencialNombre(nombre, lista);
        if (producto != null) {
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            return true;
        } else {
            return false;
        }
    }
    public boolean disminuirCantidadProducto(ProductoPedido prod){
        Producto producto = orden.coincidenciaProducto(prod,lista);
        if (producto!=null){
            if (producto.getCantidad()>=prod.getCantidad()){
                producto.setCantidad(producto.getCantidad()-prod.getCantidad());
                return true;
            } else{
                return false;
            }
        }
        return false;
    }

    public boolean agregarStock (String nombre, int cantidad){
        Producto producto = orden.busquedaSecuencialNombre(nombre,lista);
        if (producto!=null){
            producto.setCantidad(producto.getCantidad()+cantidad);
            return true;
        } else{
            return false;
        }
    }

    private void actualizarComboBox(JComboBox<String> combobox) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Producto producto : lista) {
            model.addElement(producto.getNombre());
        }
        combobox.setModel(model);
    }

    @Override
    public String toString() {
        return "***MENU***\n" + lista;
    }
}
