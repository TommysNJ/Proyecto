public class Cliente {
    private String nombre;
    private String cedula;
    private String correo;
    private String telefono;

    public Cliente(String nombre, String cedula, String correo, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }


    public String getCedula() {
        return cedula;
    }


    public String getCorreo() {
        return correo;
    }


    public String getTelefono() {
        return telefono;
    }


    @Override
    public String toString() {
        return "-Cliente-" + "\nNombre:"+ nombre +
                "\nCedula: " + cedula +
                "\nCorreo: " + correo + '\'' +
                "\nTeléfono: " + telefono;
    }
}
