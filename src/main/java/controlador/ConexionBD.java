package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    Connection con;

    String url = "jdbc:sqlserver://dentimeddbserver.database.windows.net:1433;database=dentimed;user=dentimeddbserver-admin@dentimeddbserver;password=36822411M87ENO7M$;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Connection conectarBaseDeDatos() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url);
            System.out.println("Conexión exitosa a la base de datos ");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se pudo Conectar a la base de datos ");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBaseDeDatos();
    }
}
