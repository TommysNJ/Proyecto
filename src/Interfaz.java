import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarProductoButton;
    private JTextArea textAIngresoProducto;
    private JButton QuemarDatosButton;
    private JTextField textIngresoDescripcion;
    private JTextField textIngresoPrecio;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;
    private JTextField fieldValidarCedula;
    private JButton validarButton;
    private JTextField fieldRegistrarNombre;
    private JTextField fieldRegistrarCedula;
    private JTextField fieldRegistrarCorreo;
    private JTextField fieldRegistrarTelefono;
    private JButton registrarButton;
    private JLabel labelNombre;
    private JLabel labelCedula;
    private JLabel labelCorreo;
    private JLabel labelTelefono;
    private JButton quemarClienteButton;
    private JTextArea areaMenu;
    private JSpinner spinnerCantidad;
    private JComboBox comboBoxPedido;
    private JButton agregarButton;
    private JButton mostrarMenúButton;
    private Menu menu = new Menu();
    private Registro registro = new Registro();
    private ProductoPedido productoPedido;

    public Interfaz() {
        textoModifPrecio.setEnabled(false);
        textoModifCalorias.setEnabled(false);
        textoModifPreparacion.setEnabled(false);
        modificarModifButton.setEnabled(false);
        eliminarButton.setEnabled(false);
        ingresarProductoButton.setEnabled(false);
        labelNombre.setVisible(false);
        labelCedula.setVisible(false);
        labelCorreo.setVisible(false);
        labelTelefono.setVisible(false);
        fieldRegistrarNombre.setVisible(false);
        fieldRegistrarCedula.setVisible(false);
        fieldRegistrarCorreo.setVisible(false);
        fieldRegistrarTelefono.setVisible(false);
        registrarButton.setVisible(false);

        ingresarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto = new Producto(textIngresoNombre.getText(),textIngresoDescripcion.getText(),Double.parseDouble(textIngresoPrecio.getText()));

                if (menu.agregarProducto(producto,comboBoxPedido)){
                    textAIngresoProducto.setText(String.valueOf(producto));
                    textIngresoNombre.setText("");
                    textIngresoPrecio.setText("");
                    textIngresoDescripcion.setText("");
                } else{
                    textAIngresoProducto.setText("El nombre o descripción del producto ya existe, ingrese uno nuevo.");
                    textIngresoNombre.setText("");
                    textIngresoDescripcion.setText("");
                }
            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.quemarProductos(comboBoxPedido);
                textAIngresoProducto.setText(menu.mostrarLista().toString());
                QuemarDatosButton.setEnabled(false);
                ingresarProductoButton.setEnabled(true);
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (registro.validarCliente(fieldValidarCedula.getText())){
                    JOptionPane.showMessageDialog(null, "No se encontró el cliente, registrese.");
                    labelNombre.setVisible(true);
                    labelCedula.setVisible(true);
                    labelCorreo.setVisible(true);
                    labelTelefono.setVisible(true);
                    fieldRegistrarNombre.setVisible(true);
                    fieldRegistrarCedula.setVisible(true);
                    fieldRegistrarCorreo.setVisible(true);
                    fieldRegistrarTelefono.setVisible(true);
                    registrarButton.setVisible(true);
                } else{
                    labelNombre.setVisible(true);
                    labelCedula.setVisible(true);
                    labelCorreo.setVisible(true);
                    labelTelefono.setVisible(true);
                    fieldRegistrarNombre.setVisible(true);
                    fieldRegistrarCedula.setVisible(true);
                    fieldRegistrarCorreo.setVisible(true);
                    fieldRegistrarTelefono.setVisible(true);
                    fieldRegistrarNombre.setText(registro.imprimirCliente(fieldValidarCedula.getText()).getNombre());
                    fieldRegistrarCedula.setText(registro.imprimirCliente(fieldValidarCedula.getText()).getCedula());
                    fieldRegistrarCorreo.setText(registro.imprimirCliente(fieldValidarCedula.getText()).getCorreo());
                    fieldRegistrarTelefono.setText(String.valueOf(registro.imprimirCliente(fieldValidarCedula.getText()).getTelefono()));
                }
            }
        });
        quemarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registro.quemarClientes();
                quemarClienteButton.setEnabled(false);
            }
        });
        mostrarMenúButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaMenu.setText(menu.mostrarLista().toString());
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto = menu.imprimirProducto(String.valueOf(comboBoxPedido.getSelectedItem()));
                if (producto!=null){
                    productoPedido = new ProductoPedido(producto,(int)spinnerCantidad.getValue());
                    areaMenu.setText(productoPedido.toString());
                }
            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
