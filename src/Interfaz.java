import javax.swing.*;
import java.awt.event.*;

public class Interfaz extends JFrame{

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
    private JButton buscarButtonStock;
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
    private JTabbedPane tabbedCajero;
    private JTextField txtCliente;
    private JButton btnAceptar;
    private JTextArea area;
    private JPanel panelIngresar;
    private JPanel panelModificar;
    private JPanel panelEliminar;
    private JPanel panelMostrar;
    private JPanel panelHistorial;
    private JPanel panelPedido;
    private JPanel panelClientes;
    private JCheckBox ordenAlfabeticoCheckBox;
    private JComboBox comboBoxBusca;
    private JCheckBox aZCheckBox;
    private JCheckBox zACheckBox;
    private JCheckBox ordenAgregadoCheckBox;
    private JCheckBox ascendenteCheckBox;
    private JCheckBox descendenteCheckBox;
    private JTextField fieldNombreStock;
    private JTextField fieldCantidadStock;
    private JButton agregarButtonStock;
    private JTextArea areaStock;
    private JButton verHistorialButton;
    private JTextArea areaRecomendaciones;
    private JButton buttonVendidos;
    private JButton producto;
    private Menu menu = new Menu();
    private Registro registro = new Registro();
    private Historial historial = new Historial();
    private Cliente cliente;
    private Pedido pedido = new Pedido();
    private Recomendar recomendar = new Recomendar();
    private SpinnerNumberModel modelo = new SpinnerNumberModel(1,1,100,1);
    private ValidacionesYOrdenamiento validar = new ValidacionesYOrdenamiento();
    private InicioSesion inicio = new InicioSesion();


    public Interfaz() {
        textoModiDescripcion.setEnabled(false);
        textoModifPrecio.setEnabled(false);
        modificarModifButton.setEnabled(false);
        eliminarButton.setEnabled(false);
        ingresarProductoButton.setEnabled(false);
        agregarButtonStock.setEnabled(false);
        fieldCantidadStock.setEnabled(false);
        labelNombre.setVisible(false);
        labelCedula.setVisible(false);
        labelCorreo.setVisible(false);
        labelTelefono.setVisible(false);
        fieldRegistrarNombre.setVisible(false);
        fieldRegistrarCedula.setVisible(false);
        fieldRegistrarCorreo.setVisible(false);
        fieldRegistrarTelefono.setVisible(false);
        registrarButton.setVisible(false);

        spinnerCantidad.setModel(modelo);

        spinnerCantidad.setEditor(new JSpinner.DefaultEditor(spinnerCantidad) {
            @Override
            public void setEnabled(boolean enabled) {
                super.setEnabled(false);
            }
        });

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
                textAIngresoProducto.setText(menu.mostrarProductosAdmin().toString());
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
                    textoModiDescripcion.setEnabled(false);
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

                String nombreEliminar = textNombreEliminar.getText();
                if (menu.eliminarProducto(nombreEliminar, comboBoxPedido)) {
                    textAEliminar.setText("Se eliminó con éxito");
                    eliminarButton.setEnabled(false);
                    textNombreEliminar.setText("");
                } else {
                    textAEliminar.setText("No se eliminó porque no existe el producto ingresado");
                    eliminarButton.setEnabled(false);
                    textNombreEliminar.setText("");
                }

            }
        });
        mostrarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAMostrar.setText(menu.mostrarProductosAdmin().toString());
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
                    fieldRegistrarNombre.setText("");
                    fieldRegistrarCedula.setText("");
                    fieldRegistrarTelefono.setText("");
                    fieldRegistrarCorreo.setText("");
                    fieldRegistrarNombre.setEditable(true);
                    fieldRegistrarCedula.setEditable(true);
                    fieldRegistrarCorreo.setEditable(true);
                    fieldRegistrarTelefono.setEditable(true);
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
                    fieldRegistrarNombre.setEditable(false);
                    fieldRegistrarCedula.setEditable(false);
                    fieldRegistrarCorreo.setEditable(false);
                    fieldRegistrarTelefono.setEditable(false);
                    registrarButton.setVisible(false);
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
                areaMenu.setText(menu.toString());
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
                ProductoPedido productoPedido= new ProductoPedido(producto,(int)spinnerCantidad.getValue());
                ProductoPedido productoPedido1= new ProductoPedido(producto,(int)spinnerCantidad.getValue());
                if (menu.disminuirCantidadProducto(productoPedido)){
                    //menu.disminuirCantidadProducto(productoPedido);
                    pedido.agregarProductoPedido(productoPedido);
                    recomendar.agregarProductoPedido(productoPedido1);
                    areaProdAgregados.setText(pedido.imprimirPedido());
                    FINALIZARButton.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null,"No hay los suficientes productos disponibles, lamentamos el incoveniente.");
                }
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
                pedido.setCliente(cliente);
                pedido.calcularTotal();
                historial.agregarPedido(pedido);
                pedido = new Pedido();
                areaProdAgregados.setText("");
                JOptionPane.showMessageDialog(null,"Pedido realizado con éxito!!");
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
        textNombreEliminar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Simular la acción de presionar el botón
                    ButtonBuscarEliminar.doClick();
                }
            }
        });
        fieldValidarCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Cancela el evento de entrada si no es un número
                }

                String text = fieldValidarCedula.getText();
                if (text.length() >= 10) {
                    e.consume();  // Cancela el evento de entrada si se alcanza la longitud máxima (10 caracteres)
                }
            }
        });
        fieldRegistrarCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Cancela el evento de entrada si no es un número
                }

                String text = fieldRegistrarCedula.getText();
                if (text.length() >= 10) {
                    e.consume();  // Cancela el evento de entrada si se alcanza la longitud máxima (10 caracteres)
                }
            }
        });
        fieldRegistrarTelefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Cancela el evento de entrada si no es un número
                }

                String text = fieldRegistrarTelefono.getText();
                if (text.length() >= 10) {
                    e.consume();  // Cancela el evento de entrada si se alcanza la longitud máxima (10 caracteres)
                }
            }
        });
        fieldRegistrarNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    e.consume();  // Cancela el evento de entrada si no es una letra o espacio
                }
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = fieldRegistrarCorreo.getText();
                String telf = fieldRegistrarTelefono.getText();
                String cedula = fieldRegistrarCedula.getText();

                if (!validar.esCorreoValido(correo)) {
                    JOptionPane.showMessageDialog(null, "Ingresa una dirección de correo electrónico válida");
                } else if (!validar.esNumeroTelefonoValido(telf)) {
                    JOptionPane.showMessageDialog(null, "Ingresa un número telefónico válido");
                } else if (!validar.esCedulaValida(cedula)) {
                    JOptionPane.showMessageDialog(null, "Ingresa un número de cédula válido");
                } else {
                    // codigo boton despues de validar
                    Cliente client = new Cliente(fieldRegistrarNombre.getText(),fieldRegistrarCedula.getText(),
                            fieldRegistrarCorreo.getText(),fieldRegistrarTelefono.getText());
                    registro.agregarCliente(client);
                }
                registrarButton.setVisible(false);
                JOptionPane.showMessageDialog(null,"Cliente ingresado correctamente a la base de datos!!");
            }
        });
        fieldRegistrarNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnRegistrar();
            }
        });
        fieldRegistrarCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnRegistrar();
            }
        });
        fieldRegistrarCorreo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnRegistrar();
            }
        });
        fieldRegistrarTelefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnRegistrar();
            }
        });

        fieldValidarCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Simular la acción de presionar el botón
                    validarButton.doClick();
                }
            }
        });
        fieldValidarCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habBtnValidar();
            }
        });

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBoxBusca.getSelectedItem();

                if (selectedOption.equals("Cedula")) {
                    if(registro.buscarClientePorCedula(txtCliente.getText())==null){
                        JOptionPane.showMessageDialog(null,"Cliente no encontrado");
                        area.setText("");
                    }else{
                        area.setText(registro.buscarClientePorCedula(txtCliente.getText()).toString());
                    }
                } else if (selectedOption.equals("Nombre")) {
                    if(registro.buscarClientePorNombre(txtCliente.getText())==null){
                        JOptionPane.showMessageDialog(null,"Cliente no encontrado");
                        area.setText("");
                    }else{
                        area.setText(registro.buscarClientePorNombre(txtCliente.getText()).toString());
                    }
                } else if (selectedOption.equals("Correo")) {
                    if(registro.buscarClientePorCorreo(txtCliente.getText())==null){
                        JOptionPane.showMessageDialog(null,"Cliente no encontrado");
                        area.setText("");
                    }else{
                        area.setText(registro.buscarClientePorCorreo(txtCliente.getText()).toString());
                    }
                } else {
                    // Código a ejecutar para cualquier otra opción
                    JOptionPane.showMessageDialog(null, "No se seleccionó una opción válida");
                }
            }
        });
        txtCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                habAcept();
            }
        });

        aZCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aZCheckBox.isSelected()){
                    zACheckBox.setEnabled(false);
                    ascendenteCheckBox.setEnabled(false);
                    descendenteCheckBox.setEnabled(false);
                    area.setText("");
                    area.append(registro.obtenerClientesPorNombreAscendente());
                }else{
                    zACheckBox.setEnabled(true);
                    ascendenteCheckBox.setEnabled(true);
                    descendenteCheckBox.setEnabled(true);
                }
            }
        });
        zACheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(zACheckBox.isSelected()){
                    aZCheckBox.setEnabled(false);
                    ascendenteCheckBox.setEnabled(false);
                    descendenteCheckBox.setEnabled(false);
                    area.setText("");
                    area.append(registro.obtenerClientesPorNombreDescendente());
                }else{
                    aZCheckBox.setEnabled(true);
                    ascendenteCheckBox.setEnabled(true);
                    descendenteCheckBox.setEnabled(true);
                }
            }
        });
        ascendenteCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ascendenteCheckBox.isSelected()){
                    descendenteCheckBox.setEnabled(false);
                    aZCheckBox.setEnabled(false);
                    zACheckBox.setEnabled(false);
                    area.setText("");
                    area.append(registro.imprimirTodosClientesAscendente());
                }else{
                    descendenteCheckBox.setEnabled(true);
                    aZCheckBox.setEnabled(true);
                    aZCheckBox.setEnabled(true);
                }
            }
        });
        descendenteCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(descendenteCheckBox.isSelected()){
                    ascendenteCheckBox.setEnabled(false);
                    aZCheckBox.setEnabled(false);
                    zACheckBox.setEnabled(false);
                    area.setText("");
                    area.append(registro.imprimirTodosClientesDescendente());
                }else{
                    ascendenteCheckBox.setEnabled(true);
                    aZCheckBox.setEnabled(true);
                    zACheckBox.setEnabled(true);
                }
            }
        });
        buscarButtonStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menu.imprimirProducto(fieldNombreStock.getText()) != null) {
                    areaStock.setText(menu.imprimirProductoCantidad(fieldNombreStock.getText()));
                    fieldCantidadStock.setEnabled(true);
                    agregarButtonStock.setEnabled(true);
                    //modificarModifButton.setEnabled(true);
                } else {
                    areaStock.setText("No se encontró un plato con el nombre especificado.");
                    fieldCantidadStock.setEnabled(false);
                    agregarButtonStock.setEnabled(false);
                }
            }
        });
        agregarButtonStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.agregarStock(fieldNombreStock.getText(),Integer.parseInt(fieldCantidadStock.getText()));
                areaStock.append("***STOCK RENOVADO***\n");
                areaStock.append(menu.imprimirProductoCantidad(fieldNombreStock.getText()));
                fieldCantidadStock.setEnabled(false);
                agregarButtonStock.setEnabled(false);
                fieldNombreStock.setText("");
                fieldCantidadStock.setText("");
            }
        });
        verHistorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaRecomendaciones.setText(recomendar.toString());
            }
        });
        buttonVendidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaRecomendaciones.setText(recomendar.generarArbol().toString());
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

    public void habBtnRegistrar(){
        if(!fieldRegistrarNombre.getText().isEmpty() &&  !fieldRegistrarCedula.getText().isEmpty() &&
        !fieldRegistrarCorreo.getText().isEmpty() && !fieldRegistrarTelefono.getText().isEmpty()){
            registrarButton.setEnabled(true);
        }else{
            registrarButton.setEnabled(false);
        }
    }

    public void  habBtnValidar(){
        if(!fieldValidarCedula.getText().isEmpty()){
            validarButton.setEnabled(true);
        }else{
            validarButton.setEnabled(false);
        }
    }

    public void habAcept(){
        if(!txtCliente.getText().isEmpty()){
            btnAceptar.setEnabled(true);
        }else{
            btnAceptar.setEnabled(false);
        }
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
