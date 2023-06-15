import javax.swing.*;
import java.util.ArrayList;
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
    public void quemarClientes (){
        Cliente c1 = new Cliente("Tomás Núñez", "0503897910", "tomas.nunezj@hotmail.com","0998949534");
        Cliente c2 = new Cliente("Tomás Núñez", "1534567845", "tomas.nunezj@hotmail.com","0998949534");
        Cliente c3 = new Cliente("Tomás Núñez", "2014567348", "tomas.nunezj@hotmail.com","0998949534");
        Cliente c4 = new Cliente("Tomás Núñez", "3476342517", "tomas.nunezj@hotmail.com","0998949534");
        Cliente c5 = new Cliente("Tomás Núñez", "0978572832", "tomas.nunezj@hotmail.com", "0998949534");
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);
        lista.add(c5);
    }
}
