package pe.edu.pharmahelpdesk.dao;

import pe.edu.pharmahelpdesk.config.ConexionBD;
import pe.edu.pharmahelpdesk.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketDAO {

    public boolean registrar(Ticket ticket) {

        String sql = """
            INSERT INTO tickets
            (codigo, solicitante, punto_venta,
             categoria, prioridad, descripcion, estado)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexion =
                ConexionBD.obtenerConexion();

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

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {

            System.err.println(
                "Error al registrar ticket: "
                + e.getMessage()
            );

            return false;
        }
    }
}
