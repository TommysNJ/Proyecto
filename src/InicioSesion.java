import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class InicioSesion extends JFrame{
    private JPanel panel;
    private JTextField txtFieldUser;
    private JPasswordField txtFieldPass;
    private JButton btnAccept;
    private JButton ACEPTARButton;
    private String user = "admin";
    private String password = "admin";

    public InicioSesion() {

        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtFieldUser.getText().equals(user) && txtFieldPass.getText().equals(password)){
                    Interfaz formaPrincipal = new Interfaz();
                    formaPrincipal.setContentPane(formaPrincipal.getMainPanel());
                    formaPrincipal.setBounds(350,150,800,500);
                    formaPrincipal.setVisible(true);
                    formaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Credenciales invalidas");
                    txtFieldPass.setText("");
                    txtFieldUser.setText("");
                }
            }
        });
        btnAccept.addComponentListener(new ComponentAdapter() {
        });
    }

    public JPanel getPanel() {
        return panel;
    }


}
