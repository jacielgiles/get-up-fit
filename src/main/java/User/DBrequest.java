/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import ConexionBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alfre
 */
public class DBrequest {
    
    public String[][] obtenerRutina(int genero, int edadReal, int peso, int equipo, int finalEjercicio) {
        String idRutina = "" + genero + edadReal + peso + equipo + finalEjercicio;

        String[][] rutina = new String[5][2]; // 5 ejercicios [nombre, tiempo]

        String sql = "SELECT ejercicio1, tiempo1, ejercicio2, tiempo2, ejercicio3, tiempo3, " +
                     "ejercicio4, tiempo4, ejercicio5, tiempo5 FROM Rutinas3 WHERE id_rutina = ?";

        try {
            Conexion conexion = new Conexion();
            Connection cn = conexion.conectarBD();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, idRutina);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    rutina[i][0] = rs.getString("ejercicio" + (i + 1));
                    rutina[i][1] = rs.getString("tiempo" + (i + 1));
                }
            } else {
                System.out.println("Rutina no encontrada para ID: " + idRutina);
            }

        } catch (Exception e) {
            System.out.println("Error al consultar la rutina: " + e.getMessage());
        }

        return rutina;
    }
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
}
    public String obtenerDatosPorId(int idPersona) {
    Conexion con = new Conexion();
    Connection cn = con.conectarBD();
    String datos = "";

    String sql = "SELECT Nombre, Apellido, Estatura, Peso, Correo, FechaNacimiento FROM Datos1 WHERE Id_persona = ?";

    try {
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, idPersona);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            datos = "Nombre: " + rs.getString("Nombre") + "\n" +
                    "Apellido: " + rs.getString("Apellido") + "\n" +
                    "Estatura: " + rs.getInt("Estatura") + " cm\n" +
                    "Peso: " + rs.getInt("Peso") + " kg\n" +
                    "Correo: " + rs.getString("Correo") + "\n" +
                    "Fecha de Nacimiento: " + rs.getString("FechaNacimiento");
        } else {
            datos = "No se encontró una persona con el ID: " + idPersona;
        }

    } catch (Exception e) {
        datos = "Error al consultar los datos: " + e.getMessage();
    }

    return datos;
}
   
}


