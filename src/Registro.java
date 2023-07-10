import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Registro {
    private List<Cliente> lista = new ArrayList<>();
    private ValidacionesYOrdenamiento orden = new ValidacionesYOrdenamiento();

    public void agregarCliente (Cliente cliente){
            lista.add(cliente);
    }

    public boolean validarCliente (String cedula){
        return orden.busquedaSecuencialCedula(cedula, lista) == null;
    }

    public Cliente imprimirCliente (String cedula){
        if (orden.busquedaSecuencialCedula(cedula,lista)!=null){
            return orden.busquedaSecuencialCedula(cedula,lista);
        }
        return null;
    }
    public String imprimirTodosClientesAscendente() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : lista) {
            sb.append("Nombre: ").append(cliente.getNombre()).append("\n");
            sb.append("Cédula: ").append(cliente.getCedula()).append("\n");
            sb.append("Correo: ").append(cliente.getCorreo()).append("\n");
            sb.append("Teléfono: ").append(cliente.getTelefono()).append("\n");
            sb.append("-------------------------\n");
        }
        return sb.toString();
    }

    public String imprimirTodosClientesDescendente() {
        List<Cliente> listaInversa = new ArrayList<>(lista);
        Collections.reverse(listaInversa);

        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : listaInversa) {
            sb.append("Nombre: ").append(cliente.getNombre()).append("\n");
            sb.append("Cédula: ").append(cliente.getCedula()).append("\n");
            sb.append("Correo: ").append(cliente.getCorreo()).append("\n");
            sb.append("Teléfono: ").append(cliente.getTelefono()).append("\n");
            sb.append("-------------------------\n");
        }
        return sb.toString();
    }

    public Cliente buscarClientePorCedula(String cedula) {
        for (Cliente cliente : lista) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente; // Se encontró el cliente con la cédula proporcionada
            }
        }
        return null; // No se encontró ningún cliente con la cédula proporcionada
    }

    public Cliente buscarClientePorNombre(String nombre) {
        for (Cliente cliente : lista) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente; // Se encontró el cliente con el nombre proporcionado
            }
        }
        return null; // No se encontró ningún cliente con el nombre proporcionado
    }

    public Cliente buscarClientePorCorreo(String correo) {
        for (Cliente cliente : lista) {
            if (cliente.getCorreo().equalsIgnoreCase(correo)) {
                return cliente; // Se encontró el cliente con el correo proporcionado
            }
        }
        return null; // No se encontró ningún cliente con el correo proporcionado
    }
    public Cliente buscarClientePorTelefono(String telefono) {
        for (Cliente cliente : lista) {
            if (cliente.getTelefono().equals(telefono)) {
                return cliente; // Se encontró el cliente con el número de teléfono proporcionado
            }
        }
        return null; // No se encontró ningún cliente con el número de teléfono proporcionado
    }


    public String obtenerClientesPorNombreAscendente() {
        List<Cliente> listaOrdenada = new ArrayList<>(lista);
        Collections.sort(listaOrdenada, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.getNombre().compareToIgnoreCase(c2.getNombre());
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append("***LISTA DE CLIENTES ORDENADA POR NOMBRE (A-Z)***").append("\n");
        for (Cliente cliente : listaOrdenada) {
            sb.append("Nombre: ").append(cliente.getNombre()).append("\n");
            sb.append("Cédula: ").append(cliente.getCedula()).append("\n");
            sb.append("Correo: ").append(cliente.getCorreo()).append("\n");
            sb.append("Teléfono: ").append(cliente.getTelefono()).append("\n");
            sb.append("-------------------------").append("\n");
        }
        return sb.toString();
    }

    public String obtenerClientesPorNombreDescendente() {
        List<Cliente> listaOrdenada = new ArrayList<>(lista);
        Collections.sort(listaOrdenada, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c2.getNombre().compareToIgnoreCase(c1.getNombre());
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append("***LISTA DE CLIENTES ORDENADA POR NOMBRE (Z-A)***").append("\n");
        for (Cliente cliente : listaOrdenada) {
            sb.append("Nombre: ").append(cliente.getNombre()).append("\n");
            sb.append("Cédula: ").append(cliente.getCedula()).append("\n");
            sb.append("Correo: ").append(cliente.getCorreo()).append("\n");
            sb.append("Teléfono: ").append(cliente.getTelefono()).append("\n");
            sb.append("-------------------------").append("\n");
        }
        return sb.toString();
    }

    public void quemarClientes (){
        Cliente c1 = new Cliente("Tomas Nuñez", "1711767226", "tomasj@hotmail.com","09988204651");
        Cliente c2 = new Cliente("Juan Ramirez", "1715217749", "juan@hotmail.com","0960027326");
        Cliente c3 = new Cliente("Mateo Rosero", "1752888592", "mateo@hotmail.com","0984905968");
        Cliente c4 = new Cliente("Willian Lopez", "0202140166", "willian@hotmail.com","0980321581");
        Cliente c5 = new Cliente("Marco Cando", "1707489322", "marco@hotmail.com", "0993986389");
        Cliente c6 = new Cliente("Andres Guaman","1756126659","andres@gmail.com", "0960267324");
        agregarCliente(c1);
        agregarCliente(c2);
        agregarCliente(c3);
        agregarCliente(c4);
        agregarCliente(c5);
        agregarCliente(c6);
    }
}
