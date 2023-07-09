import java.util.Arrays;
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
    public boolean esCorreoValido(String correo) {
        String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
        return correo.matches(patron);
    }
    public boolean esNumeroTelefonoValido(String numeroTelefono) {
        // Eliminar todos los caracteres que no sean dígitos
        String numeroLimpio = numeroTelefono.replaceAll("[^0-9]", "");

        // Verificar que el número limpio tenga 10 dígitos
        if (numeroLimpio.length() != 10) {
            return false;
        }

        // Verificar si los primeros dígitos corresponden a los prefijos de telefonía móvil en Ecuador
        String prefijosMovil[] = {"09", "099", "098", "097", "096", "095", "094", "093", "092", "091"};
        String prefijo = numeroLimpio.substring(0, 2);
        boolean esPrefijoValido = Arrays.asList(prefijosMovil).contains(prefijo);

        return esPrefijoValido;
    }

    public boolean esCedulaValida(String cedula) {
        // Eliminar todos los caracteres que no sean dígitos
        String cedulaLimpia = cedula.replaceAll("[^0-9]", "");

        // Verificar que la cédula limpia tenga 10 dígitos
        if (cedulaLimpia.length() != 10) {
            return false;
        }

        // Obtener los dígitos de la cédula
        int digitoRegion = Integer.parseInt(cedulaLimpia.substring(0, 2));
        int digitoTercer = Integer.parseInt(cedulaLimpia.substring(2, 3));
        int digitoVerificador = Integer.parseInt(cedulaLimpia.substring(9));

        // Verificar el dígito de la región
        if (digitoRegion < 1 || digitoRegion > 24) {
            return false;
        }

        // Verificar el dígito del tercer dígito
        if (digitoTercer < 0 || digitoTercer > 5) {
            return false;
        }

        // Calcular el dígito verificador
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Integer.parseInt(String.valueOf(cedulaLimpia.charAt(i)));
            if (i % 2 == 0) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }
            suma += digito;
        }
        int digitoCalculado = 10 - (suma % 10);
        if (digitoCalculado == 10) {
            digitoCalculado = 0;
        }

        // Verificar el dígito verificador
        return digitoVerificador == digitoCalculado;
    }

}
