import javax.swing.*;
import java.awt.event.*;

public class InicioSesion extends JFrame{
    private JPanel panel;
    private JTextField txtFieldUser;
    private JPasswordField txtFieldPass;
    private JButton btnAccept;

    private String user = "admin";
    private String password = "admin";

    public InicioSesion() {

        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if (txtFieldUser.getText().equals(user) && txtFieldPass.getText().equals(password)) {
                        Interfaz formaPrincipal = new Interfaz();
                        formaPrincipal.setContentPane(formaPrincipal.getMainPanel());
                        formaPrincipal.setBounds(350, 150, 800, 500);
                        formaPrincipal.setVisible(true);
                        formaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales invalidas");
                        txtFieldPass.setText("");
                        txtFieldUser.setText("");
                    }

            }
        });
        btnAccept.addComponentListener(new ComponentAdapter() {
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

    public JPanel getPanel() {
        return panel;
    }


}
