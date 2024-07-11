import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.*;


public class Buscar {
    public JTextField placa;
    public JPanel panel1;
    private JLabel busqueda;


    public Buscar() {
        placa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/Vehiculos";
                String user = "root";
                String password = "123456";


                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Conectado a la base de datos");
                    String query = "SELECT * FROM carro WHERE placa='" + placa.getText() + "'";

                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    if (resultSet.next()) {
                        String placa= resultSet.getString("placa");
                        String marca = resultSet.getString("marca");
                        int cilindro = resultSet.getInt("numero_cilindros");
                        String gasolina = resultSet.getString("combustuble");
                        String color = resultSet.getString("color");
                        String propietario = resultSet.getString("propietario");




                        busqueda.setText("<html>Placa: " + placa+ "<br>" +
                                "MARCA"  + marca + "<br>" +
                                "cilindros " + cilindro + "<br>" +
                                "gasolina"+gasolina+"<br>"+
                                "color"+color+"<br>"+
                                "propietario"+propietario+"<br><html>");

                    } else {
                        busqueda.setText("Estudiante no encontrado");
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
                }


            }

        });
    }
}
