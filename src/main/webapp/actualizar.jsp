
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Empleado"%>
<%@page import ="jakarta.servlet.http.HttpServletRequest"%>
<%@page import ="modelo.Empleado"%>
<%@page import ="modelo.EmpleadoDAO"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
            />
        <title>Pacientes</title>
    </head>
    <body>
        <div class="container p-3 text-center"><h2 class="text-danger-emphasis">Editar Empleado</h2></div>   

        <form class="col container" action="SvEmpleado" method="POST">

            <%String cedula = request.getParameter("cedula");%>
            <%Empleado empleado = new EmpleadoDAO().buscarCedula(cedula);%>
            <div class="mt-2">
                <input
                    type="text"
                    class="form-control"
                    placeholder="Cedula"
                    value="<%=empleado.getCedula()%>"
                    name="cedula"
                    readonly
                    />
            </div>
            <div class="mt-2">
                <input
                    type="text"
                    class="form-control"
                    placeholder="Nombres"
                    value="<%=empleado.getNombres()%>"
                    name="nombres"
                    />
            </div>
            <div class="mt-2">
                <input
                    type="text"
                    class="form-control"
                    placeholder="Apellidos"
                    name="apellidos"
                    value="<%=empleado.getApellidos()%>"

                    />
            </div>
            <div class="mt-2">
                <input
                    type="text"
                    class="form-control"
                    placeholder="Fecha de nacimiento"    
                    name="fechanacimiento"
                    value="<%=empleado.getFechaDeNacimiento()%>"


                    />
            </div>
            <div class="mt-2">
                <input
                    type="text"
                    class="form-control"
                    placeholder="Telefono"
                    name="telefono"
                    value="<%=empleado.getTelefono()%>"

                    />
            </div>
            <div class="mt-2">
                <input
                    type="text"
                    class="form-control"
                    placeholder="Correo"
                    name="correo"
                    value="<%=empleado.getEmail()%>"

                    />
            </div>

        
                <button type="submit" class="btn btn-success w-100 mt-2" value="btn-editar" name="boton">Editar</button>    

      



        </div>
    </form>


</body>
</html>
