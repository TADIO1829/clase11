import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ingresar {
    public JPanel panel2;
    public JTextField prueba;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JButton ingresarButton;
    public JTextField textField5;
    public JButton regresarButton;


    public Ingresar() {

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarVehiculo();
            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame=new JFrame();
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
                frame.setContentPane(new Vehiculos().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 1000);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }


    public void insertarVehiculo() {
        String placa = prueba.getText();
        int cilindro= Integer.parseInt(textField2.getText());
        String marca = textField1.getText();
        String combustible=textField3.getText();
        String color=textField4.getText();
        String propietario=textField5.getText();

        Objetos ob = new Objetos(marca,placa,cilindro,combustible,color,propietario);

        insertarBD(ob);
    }


    public void insertarBD(Objetos ob){
        String url = "jdbc:mysql://localhost:3306/Vehiculos";
        String user = "root";
        String password = "123456";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO carro (placa, marca, numero_cilindros,combustuble,color,propietario) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ob.getPlaca());
            statement.setString(2, ob.getMarca());
            statement.setInt(3, ob.getCilindros());
            statement.setString(4, ob.getCombutible());
            statement.setString(5, ob.getColor());
            statement.setString(6, ob.getPropietario());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(prueba, "Datos de persona insertados correctamente!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(prueba, "Error al insertar datos del vehiculo: " + ex.getMessage());
        }

    }
}

