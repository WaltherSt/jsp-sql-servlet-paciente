package modelo;

import controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDAO {

    ConexionBD conexion = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Empleado buscarCedula(String cedula) {
        Empleado empleado = new Empleado();
        String sql = "select * from empleado where cedula=" + cedula;
        try {
            con = conexion.conectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado.setCedula(rs.getString(1));
                empleado.setNombres(rs.getString(2));
                empleado.setApellidos(rs.getString(3));
                empleado.setFechaDeNacimiento(rs.getString(4));
                empleado.setTelefono(rs.getString(5));
                empleado.setEmail(rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println("Error en Metodo Buscar Cedula" + e);
        }

        return empleado;
    }

    public List<Empleado> listar() {
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = conexion.conectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCedula(rs.getString(1));
                empleado.setNombres(rs.getString(2));
                empleado.setApellidos(rs.getString(3));
                empleado.setFechaDeNacimiento(rs.getString(4));
                empleado.setTelefono(rs.getString(5));
                empleado.setEmail(rs.getString(6));
                lista.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar" + e);

        }

        lista.remove(0);

        return lista;
    }

    //Metodo Agregar
    public void agregar(Empleado empleado) throws SQLException {
        String sql = "insert into empleado (cedula, nombres, apellidos, fecha_de_nacimiento, telefono, email) values(?, ?, ?, ?, ?, ?)";
        ;
        try {
            con = conexion.conectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getCedula());
            ps.setString(2, empleado.getNombres());
            ps.setString(3, empleado.getApellidos());
            ps.setString(4, empleado.getFechaDeNacimiento());
            ps.setString(5, empleado.getTelefono());
            ps.setString(6, empleado.getEmail());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en agregar. " + e);
        } finally {
            con.close();

        }
    }

    public void actualizar(Empleado empleado) throws SQLException {
        String sql = "update empleado set nombres=?, apellidos=?, fecha_de_nacimiento=?, telefono=?, email=? where cedula=?";
        try {
            con = conexion.conectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getNombres());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getFechaDeNacimiento());
            ps.setString(4, empleado.getTelefono());
            ps.setString(5, empleado.getEmail());
            ps.setString(6, empleado.getCedula());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en Actualizar (DAO)" + e);
        } finally {
            con.close();

        }
    }

    public void borrar(String cedula) {
        String sql = "delete from empleado where cedula =" + cedula;
        try {
            con = conexion.conectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error borrar (DAO): " + e);
        }

    }
}
