package Datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import ConexionBD.Conexion;  // Asegúrate de tener bien el paquete
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
public class InsertarDatos {
public int insertarPersona(String nombre, String apellido, int estatura, int peso, String correo, String fechaNacimiento) {
    
    Conexion con = new Conexion();
    Connection cn = con.conectarBD();
    int idGenerado = -1;
    
    try {
        String sql = "INSERT INTO Datos1 (Nombre, Apellido, Estatura, Peso, Correo, FechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setInt(3, estatura);
        ps.setInt(4, peso);
        ps.setString(5, correo);
        ps.setString(6, fechaNacimiento);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            idGenerado = rs.getInt(1);
            System.out.println("Persona registrada con ID: " + idGenerado);
        }
        
    } catch (Exception e) {
        System.out.println("Error al insertar: " + e.getMessage());
    }
    
    return idGenerado;
}public boolean guardarEmocionDiaActual(int idPersona, String emocion) {
    String diaSemana = getNombreDiaSemana();
    String rutaImagen = getRutaImagen(emocion);
    Conexion con = new Conexion();
    Connection cn = con.conectarBD();
    if (cn == null) {
        System.out.println("No hay conexión a la base de datos.");
        return false;
    }
    try {
        // Primero verificamos si ya hay registro para esa persona y día
        String sqlSelect = "SELECT Id FROM EstadoAnimo WHERE Id_persona = ? AND DiaSemana = ?";
        PreparedStatement psSelect = cn.prepareStatement(sqlSelect);
        psSelect.setInt(1, idPersona);
        psSelect.setString(2, diaSemana);
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            // Si existe, actualizamos
            int idEstado = rs.getInt("Id");
            String sqlUpdate = "UPDATE EstadoAnimo SET Emocion = ?, RutaImagen = ? WHERE Id = ?";
            PreparedStatement psUpdate = cn.prepareStatement(sqlUpdate);
            psUpdate.setString(1, emocion);
            psUpdate.setString(2, rutaImagen);
            psUpdate.setInt(3, idEstado);
            int filas = psUpdate.executeUpdate();
            psUpdate.close();
            psSelect.close();
            cn.close();
            return filas > 0;
        } else {
            // Si no existe, insertamos nuevo
            String sqlInsert = "INSERT INTO EstadoAnimo (Id_persona, DiaSemana, Emocion, RutaImagen) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = cn.prepareStatement(sqlInsert);
            psInsert.setInt(1, idPersona);
            psInsert.setString(2, diaSemana);
            psInsert.setString(3, emocion);
            psInsert.setString(4, rutaImagen);
            int filas = psInsert.executeUpdate();
            psInsert.close();
            psSelect.close();
            cn.close();
            return filas > 0;
        }
    } catch (SQLException e) {
        System.out.println("Error al guardar emoción día actual: " + e.getMessage());
        return false;
    }
}
private String getNombreDiaSemana() {
    DayOfWeek dia = LocalDate.now().getDayOfWeek();
    switch (dia) {
        case MONDAY: return "Lunes";
        case TUESDAY: return "Martes";
        case WEDNESDAY: return "Miércoles";
        case THURSDAY: return "Jueves";
        case FRIDAY: return "Viernes";
        case SATURDAY: return "Sábado";
        case SUNDAY: return "Domingo";
        default: return "";
    }
}

private String getRutaImagen(String emocion) {
    Map<String, String> emocionesImagenes = new HashMap<>();
    emocionesImagenes.put("Feliz", "imagenes/feliz.png");
    emocionesImagenes.put("Triste", "imagenes/triste.png");
    emocionesImagenes.put("Enojado", "imagenes/enojado.png");
    emocionesImagenes.put("Ansioso", "imagenes/ansioso.png");
    emocionesImagenes.put("Relajado", "imagenes/relajado.png");

    return emocionesImagenes.getOrDefault(emocion, "imagenes/default.png");
}
   
    public static void main(String[] args) {
       
        }
    }
