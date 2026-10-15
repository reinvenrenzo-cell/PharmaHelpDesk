
package pe.edu.pharmahelpdesk.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
        "jdbc:mysql://localhost:3306/pharmahelpdesk"
        + "?useSSL=false"
        + "&allowPublicKeyRetrieval=true"
        + "&serverTimezone=America/Lima";

    private static final String USUARIO =
        System.getenv().getOrDefault(
            "PHARMA_DB_USER", "root"
        );

    private static final String CLAVE =
        System.getenv("PHARMA_DB_PASSWORD");

    private ConexionBD() {
        // Evita crear instancias de esta clase.
    }

    public static Connection obtenerConexion()
            throws SQLException {

        if (CLAVE == null) {
            throw new SQLException(
                "Falta configurar PHARMA_DB_PASSWORD"
            );
        }

        return DriverManager.getConnection(
            URL, USUARIO, CLAVE
        );
    }
}
