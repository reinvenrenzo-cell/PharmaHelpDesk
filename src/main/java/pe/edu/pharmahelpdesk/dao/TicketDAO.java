
package pe.edu.pharmahelpdesk.dao;

import pe.edu.pharmahelpdesk.model.Ticket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketDAO {

    private static final String URL =
        "jdbc:mysql://localhost:3306/pharmahelpdesk";

    private static final String USUARIO = "root";

    // Configurar mediante variable de entorno
    private static final String CLAVE =
        System.getenv("PHARMA_DB_PASSWORD");

    public boolean registrar(Ticket ticket) {

        String sql = """
            INSERT INTO tickets
            (codigo, solicitante, punto_venta,
             categoria, prioridad, descripcion, estado)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexion =
                DriverManager.getConnection(
                    URL, USUARIO, CLAVE);

            PreparedStatement ps =
                conexion.prepareStatement(sql)
        ) {
            ps.setString(1, ticket.getCodigo());
            ps.setString(2, ticket.getSolicitante());
            ps.setString(3, ticket.getPuntoVenta());
            ps.setString(4, ticket.getCategoria());
            ps.setString(5, ticket.getPrioridad());
            ps.setString(6, ticket.getDescripcion());
            ps.setString(7, ticket.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(
                "Error al registrar ticket: "
                + e.getMessage()
            );
            return false;
        }
    }
}
