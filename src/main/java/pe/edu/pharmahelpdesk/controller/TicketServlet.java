
package pe.edu.pharmahelpdesk.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import pe.edu.pharmahelpdesk.dto.TicketDTO;
import pe.edu.pharmahelpdesk.model.Ticket;
import pe.edu.pharmahelpdesk.dao.TicketDAO;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/registrar")
public class TicketServlet extends HttpServlet {

    private final TicketDAO ticketDAO = new TicketDAO();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String solicitante = request.getParameter("solicitante");
        String puntoVenta = request.getParameter("puntoVenta");
        String categoria = request.getParameter("categoria");
        String prioridad = request.getParameter("prioridad");
        String descripcion = request.getParameter("descripcion");

        // Validar campos obligatorios
        if (solicitante == null || solicitante.isBlank()
                || puntoVenta == null || puntoVenta.isBlank()
                || categoria == null || categoria.isBlank()
                || prioridad == null || prioridad.isBlank()
                || descripcion == null || descripcion.isBlank()) {

            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Todos los campos son obligatorios."
            );
            return;
        }

        // DTO: transportar datos del formulario
        TicketDTO dto = new TicketDTO();

        dto.setCodigo(
            "PH-" + UUID.randomUUID()
                .toString().toUpperCase()
        );

        dto.setSolicitante(solicitante.trim());
        dto.setPuntoVenta(puntoVenta.trim());
        dto.setCategoria(categoria);
        dto.setPrioridad(prioridad);
        dto.setDescripcion(descripcion.trim());
        dto.setEstado("Abierto");

        // Modelo: representar la entidad Ticket
        Ticket ticket = new Ticket();

        ticket.setCodigo(dto.getCodigo());
        ticket.setSolicitante(dto.getSolicitante());
        ticket.setPuntoVenta(dto.getPuntoVenta());
        ticket.setCategoria(dto.getCategoria());
        ticket.setPrioridad(dto.getPrioridad());
        ticket.setDescripcion(dto.getDescripcion());
        ticket.setEstado(dto.getEstado());

        // DAO: registrar ticket en MySQL
        boolean registrado = ticketDAO.registrar(ticket);

        if (registrado) {

            // Enviar DTO a la vista JSP
            request.setAttribute("ticket", dto);

            request.getRequestDispatcher("/resultado.jsp")
                   .forward(request, response);

        } else {

            response.sendError(
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                "No se pudo guardar el ticket."
            );
        }
    }
}
