import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {


                InicioSesion formaPrincipal = new InicioSesion();
                formaPrincipal.setContentPane(formaPrincipal.getPanel());
                formaPrincipal.setBounds(350,150,800,500);
                formaPrincipal.setVisible(true);
                formaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }

        });

    }

}