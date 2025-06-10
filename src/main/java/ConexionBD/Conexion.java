package ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    Connection cn;
    public Connection conectarBD() {
        try {
         
            
     
            String url = "jdbc:mysql://urxzbjwtviwsxlwf:I2Ec85phRWm0NePJmLVl@bnadmksbi08vzbk70van-mysql.services.clever-cloud.com:3306/bnadmksbi08vzbk70van";
            String usuario = "urxzbjwtviwsxlwf";
            String contraseña = "I2Ec85phRWm0NePJmLVl";
                    
            
            
            // Realizar la conexión con el casting específico
            cn = (Connection) DriverManager.getConnection(url, usuario, contraseña);
            
            
            
        } catch (Exception e) {
            System.out.println("Conexión fallida: " + e.getMessage());
        }
        return cn;
    }
    public static void main(String[] args) {
        Conexion prueba = new Conexion();
        
        prueba.conectarBD();
    }
    
}

