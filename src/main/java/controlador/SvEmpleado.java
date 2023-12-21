package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empleado;
import modelo.EmpleadoDAO;

public class SvEmpleado extends HttpServlet {

    EmpleadoDAO dao = new EmpleadoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String boton = (String) request.getParameter("boton");

        switch (boton) {
            case "btn-agregar":
                try {
                    String cedulaEmpleado = request.getParameter("cedulaEmpleado");
                    String nombresEmpleado = request.getParameter("name");
                    String apellidosEmpleado = request.getParameter("lastname");
                    String fNacimientoEmpleado = request.getParameter("FNacimientoEmpleado");
                    String telefonoEmpleado = request.getParameter("telefonoEmpleado");
                    String emailEmpleado = request.getParameter("emailEmpleado");

                    Empleado empleado = new Empleado(cedulaEmpleado, nombresEmpleado, apellidosEmpleado, fNacimientoEmpleado, telefonoEmpleado, emailEmpleado);
                    dao.agregar(empleado);

                } catch (Exception e) {

                    Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, e);
                } finally {
                    response.sendRedirect("index.jsp");
                }

                break;

            case "btn-editar":
                try {
                    String cedula = request.getParameter("cedula");
                    String nombres = request.getParameter("nombres");
                    String apellidos = request.getParameter("apellidos");
                    String nacieminto = request.getParameter("fechanacimiento");
                    String telefono = request.getParameter("telefono");
                    String correo = request.getParameter("correo");
                    ;

                    Empleado empleadoActualizado = new Empleado(cedula, nombres, apellidos, nacieminto, telefono, correo);
                    dao.actualizar(empleadoActualizado);

                } catch (Exception e) {
                    Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, e);
                } finally {
                    response.sendRedirect("index.jsp");
                }
                break;

            default:

                try {
                    dao.borrar(boton);
                } catch (Exception e) {
                    Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, e);
                } finally {
                    response.sendRedirect("index.jsp");
                }

        }

    }

}
