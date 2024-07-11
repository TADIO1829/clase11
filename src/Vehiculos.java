import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vehiculos {
    public JButton Ingresar;
    public JPanel panel1;
    public JButton buscar;


    public Vehiculos() {
        Ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Ingresar");
                frame.setContentPane(new Ingresar().panel2);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);



            }
        });
    }
}
