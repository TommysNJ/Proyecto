import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private JButton mostrarProductosButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
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
    private JTextArea areaProdAgregados;
    private JButton FINALIZARButton;
    private JTextField textIngresoCantProd;
    private Menu menu = new Menu();
    private Registro registro = new Registro();
    private Historial historial = new Historial();
    private Cliente cliente;
    private Pedido pedido = new Pedido(cliente);

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
                Producto producto = new Producto(textIngresoNombre.getText(),textIngresoDescripcion.getText(),Double.parseDouble(textIngresoPrecio.getText()),Integer.parseInt(textIngresoCantProd.getText()));

                if (menu.agregarProducto(producto,comboBoxPedido)){
                    textAIngresoProducto.setText(String.valueOf(producto));
                    textIngresoNombre.setText("");
                    textIngresoPrecio.setText("");
                    textIngresoDescripcion.setText("");
                    textIngresoCantProd.setText("");
                } else{
                    textAIngresoProducto.setText("El nombre o descripción del producto ya existe, ingrese uno nuevo.");
                    textIngresoNombre.setText("");
                    textIngresoPrecio.setText("");
                    textIngresoDescripcion.setText("");
                    textIngresoCantProd.setText("");
                }
            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.quemarProductos(comboBoxPedido);
                textAIngresoProducto.setText(menu.mostrarLista().toString());
                QuemarDatosButton.setEnabled(false);
                //ingresarProductoButton.setEnabled(true);
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
                    //modificarModifButton.setEnabled(true);
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
                if (menu.imprimirProducto(textNombreEliminar.getText()) != null) {
                    textAEliminar.setText(menu.imprimirProducto(textNombreEliminar.getText()).toString());
                    eliminarButton.setEnabled(true);
                } else {
                    textAEliminar.setText("No se encontró el producto ingresado.");
                    eliminarButton.setEnabled(false);
                    textNombreEliminar.setText("");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menu.eliminarProducto(textNombreEliminar.getText())){
                    menu.eliminarProducto(textNombreEliminar.getText());
                    textAEliminar.setText("Se eliminó con éxito.");
                    eliminarButton.setEnabled(false);
                    textNombreEliminar.setText("");
                } else {
                    textAEliminar.setText("No se elimino porque no existe el producto ingresado.");
                    eliminarButton.setEnabled(false);
                    textNombreEliminar.setText("");
                }
            }
        });
        mostrarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAMostrar.setText(menu.mostrarLista().toString());
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
                /*Cliente cliente = new Cliente(fieldRegistrarCedula.getText(),fieldRegistrarCedula.getText(),fieldRegistrarCorreo.getText(),fieldRegistrarTelefono.getText());
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
                //Cliente cliente = new Cliente(fieldRegistrarNombre.getText(),fieldRegistrarCedula.getText(),fieldRegistrarCorreo.getText(),fieldRegistrarTelefono.getText());
                //pedido = new Pedido(cliente);
                Producto producto = menu.imprimirProducto(String.valueOf(comboBoxPedido.getSelectedItem()));
                pedido.agregarProductoPedido(new ProductoPedido(producto,(int)spinnerCantidad.getValue()));
                areaProdAgregados.setText(pedido.imprimirPedido());
            }
        });
        mostrarHistorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaHistorial.setText(historial.getPilaHistorial().toString());
            }
        });

        FINALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente = new Cliente(fieldRegistrarNombre.getText(),fieldRegistrarCedula.getText(),fieldRegistrarCorreo.getText(),fieldRegistrarTelefono.getText());
                //Cliente cliente = new Cliente(fieldRegistrarNombre.getText(),fieldRegistrarCedula.getText(),fieldRegistrarCorreo.getText(),fieldRegistrarTelefono.getText());
                //pedido = new Pedido(cliente);
                pedido.calcularTotal();
                historial.agregarPedido(pedido);
            }
        });
        textIngresoPrecio.addKeyListener(new KeyAdapter() {
        });
        textIngresoPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Cancela el evento de entrada si no es un número
                }
            }
        });
        textIngresoCantProd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Cancela el evento de entrada si no es un número
                }
            }
        });

        textIngresoNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnIngresar();
            }
        });
        textIngresoDescripcion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnIngresar();
            }
        });
        textIngresoPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnIngresar();
            }
        });
        textIngresoCantProd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnIngresar();
            }
        });
        textoModifPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Cancela el evento de entrada si no es un número
                }
            }
        });
        textoModiDescripcion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnModi();
            }
        });
        textoModifPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnModi();
            }
        });
    }
    public void habBtnIngresar(){
        if(!textIngresoNombre.getText().isEmpty() && !textIngresoDescripcion.getText().isEmpty() &&
        !textIngresoPrecio.getText().isEmpty() && !textIngresoCantProd.getText().isEmpty()){
            ingresarProductoButton.setEnabled(true);
        }else{
            ingresarProductoButton.setEnabled(false);
        }
    }

    public void habBtnModi(){
        if(!textoModiDescripcion.getText().isEmpty() && !textoModifPrecio.getText().isEmpty()){
            modificarModifButton.setEnabled(true);
        }else{
            modificarModifButton.setEnabled(false);
        }
    }
    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
