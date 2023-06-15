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
    private JTextField textoModiDescripcion;
    private JTextField textoModifPrecio;
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
    private JButton mostrarHistorialButton;
    private JTextArea areaHistorial;
    private JButton eliminarButton1;
    private Menu menu = new Menu();
    private Registro registro = new Registro();
    private ProductoPedido productoPedido;
    private Historial historial = new Historial();

    public Interfaz() {
        textoModiDescripcion.setEnabled(false);
        textoModifPrecio.setEnabled(false);
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
                if (menu.imprimirProducto(textoModifNombre.getText()) != null) {
                    textAModif.setText(menu.imprimirProducto(textoModifNombre.getText()).toString());
                    textoModifNombre.setEnabled(true);
                    textoModifPrecio.setEnabled(true);
                    textoModiDescripcion.setEnabled(true);
                    modificarModifButton.setEnabled(true);
                } else {
                    textAModif.setText("No se encontró un plato con el nombre especificado.");
                    textoModifPrecio.setEnabled(false);
                    modificarModifButton.setEnabled(false);
                }
            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.modificarProducto(textoModifNombre.getText(),textoModiDescripcion.getText(),Double.parseDouble(textoModifPrecio.getText()));
                textAModif.append("***PLATO MODIFICADO***\n");
                textAModif.append(menu.imprimirProducto(textoModifNombre.getText()).toString());
                textoModifPrecio.setEnabled(false);
                textoModiDescripcion.setEnabled(false);
                modificarModifButton.setEnabled(false);
                textoModifNombre.setText("");
                textoModifPrecio.setText("");
                textoModiDescripcion.setText("");
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
                Cliente cliente = new Cliente(fieldRegistrarCedula.getText(),fieldRegistrarCedula.getText(),fieldRegistrarCorreo.getText(),fieldRegistrarTelefono.getText());
                Producto producto = menu.imprimirProducto(String.valueOf(comboBoxPedido.getSelectedItem()));
                Pedido pedido = new Pedido(cliente,new ProductoPedido(producto,(int)spinnerCantidad.getValue()));
                historial.agregarPedido(pedido);
                areaMenu.setText(pedido.toString());
                //Pedido pedido = pedido.agregarProductoPedido(new ProductoPedido(producto,(int)spinnerCantidad.getValue()));

                //historial.agregarPedido(new Cliente(fieldRegistrarCedula.getText(),fieldRegistrarCedula.getText(),fieldRegistrarCorreo.getText(),fieldRegistrarTelefono.getText()));
                /*if (producto!=null){
                    productoPedido = new ProductoPedido(producto,(int)spinnerCantidad.getValue());
                    areaMenu.setText(productoPedido.toString());
                }*/
            }
        });
        mostrarHistorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaHistorial.setText(historial.getPilaHistorial().toString());
            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
