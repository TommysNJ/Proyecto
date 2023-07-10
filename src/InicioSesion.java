import javax.swing.*;
import java.awt.event.*;

public class InicioSesion extends JFrame{
    private JPanel panel;
    private JTextField txtFieldUser;
    private JPasswordField txtFieldPass;
    private JButton btnAccept;
    private String userCajero = "cajero";
    private String passCajero = "cajero";
    private String userAdmin = "admin";
    private String passAdmin = "admin";
    private String usuario =  "";
    private String clave  = "";


    public InicioSesion() {

        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    usuario = txtFieldUser.getText();
                    clave = txtFieldPass.getText();
                    if (usuario.equals(userAdmin) && clave.equals(passAdmin)) {
                        Interfaz formaPrincipal = new Interfaz(usuario, clave);
                        formaPrincipal.setContentPane(formaPrincipal.getMainPanel());
                        formaPrincipal.setBounds(350, 150, 800, 500);
                        formaPrincipal.setVisible(true);
                        formaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setVisible(false);
                    } else if(usuario.equals(userCajero) && clave.equals(passCajero)){
                        Interfaz formaPrincipal = new Interfaz(usuario, clave);
                        formaPrincipal.setContentPane(formaPrincipal.getMainPanel());
                        formaPrincipal.setBounds(350, 150, 800, 500);
                        formaPrincipal.setVisible(true);
                        formaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Credenciales invalidas");
                        txtFieldPass.setText("");
                        txtFieldUser.setText("");
                    }

            }
        });



        txtFieldPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Simular la acción de presionar el botón
                    btnAccept.doClick();
                }
            }
        });
        txtFieldUser.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Simular la acción de presionar el botón
                    btnAccept.doClick();
                }
            }
        });
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public JPanel getPanel() {
        return panel;
    }


}
