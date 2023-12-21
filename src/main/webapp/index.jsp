

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Empleado"%>
<%@page import="modelo.EmpleadoDAO"%>


<!DOCTYPE html>
<html>
    <!-- Enlace a Bootstrap CSS -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous"
        />
</style>


<head>
    <!-- Configuración de la página -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Empleados</title>
</head>

<body>
    <!-- Contenedor principal -->
    <div class="container-fluid mt-3 p ">
        <!-- Título de la página -->


        <!-- Formulario para agregar productos -->

        <div class="d-flex gap-4 w-full m-5 ">
            <form class="card col-sm-4 border border-0" action="SvEmpleado" method="POST">
                <!-- Campo para la CEDULA de los empleados -->
                <div class="mb-3">

                    <input
                        type="number"
                        class="form-control"
                        id=" cedulaEmpleado "
                        name="cedulaEmpleado"
                        placeholder="Cedula"
                        />
                </div>

                <!-- Campo para los NOMBRES de los empleados -->
                <div class="mb-3">

                    <input
                        type="text"
                        class="form-control"
                        id="nombresEmpleado"
                        name="name"
                        placeholder="Nombres"
                        />
                </div>

                <!-- Campo para los APELLIDOS de los empleados-->
                <div class="mb-3">

                    <input
                        type="text"
                        class="form-control"
                        id="apellidosEmpleado"
                        name="lastname"
                        placeholder="Apellidos"
                        />
                </div>

                <div class="mb-3">

                    <input
                        type="date"
                        class="form-control"
                        id="FNacimientoEmpleado"
                        name="FNacimientoEmpleado"
                        placeholder="Fecha de nacimiento"
                        />
                </div>

                <div class="mb-3">

                    <input
                        type="number"
                        class="form-control"
                        id="telefonoEmpleado"
                        name="telefonoEmpleado"
                        placeholder="Telefono"
                        />
                </div>

                <div class="mb-3">

                    <input
                        type="text"
                        class="form-control"
                        id="emailEmpleado "
                        name="emailEmpleado"
                        placeholder="Correo electronico"
                        />
                </div>


                <button type="submit" class="btn btn-primary" value="btn-agregar" name="boton">Agregar</button>           


            </form>
           
            <table class="table table-hover border">
                <thead class="table-dark">
                    <tr class="text-center">
                        <th scope="col">Cedula</th>
                        <th scope="col">Nombres</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Fecha de nacimiento</th>
                        <th scope="col">Telefono</th>
                        <th scope="col">Correo electronico</th>
                        <th scope="col">Acciones</th>
                    </tr>
                   
                </thead>
                <tbody>
                      <%List<Empleado> listaEmpleados = new EmpleadoDAO().listar();%>

                    <%for (Empleado empleado : listaEmpleados) {%>
                    <tr class="text-center align-middle">
                        <td ><%= empleado.getCedula()%></td>
                        <td><%= empleado.getNombres()%></td>
                        <td><%= empleado.getApellidos()%></td>
                        <td><%= empleado.getFechaDeNacimiento()%></td>
                        <td><%= empleado.getTelefono()%></td>
                        <td><%= empleado.getEmail()%></td>

                        <td>
                            <form class="d-flex justify-content-around " action="SvEmpleado" method="POST">
                                <a href="actualizar.jsp?cedula=<%=empleado.getCedula()%>" class="btn btn-success" type="submit">Editar</a>
                                <button class="btn btn-danger" type="submit" name="boton" value=<%=empleado.getCedula()%>>Eliminar</button>
                            </form>
                        </td>
                    </tr>
                    <%}%>          
                
                </tbody>
            </table>

        </div>
    </div>
</div>


</body>
</html>

