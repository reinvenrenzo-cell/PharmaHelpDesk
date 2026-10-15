
package pe.edu.pharmahelpdesk.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

        String solicitante =
                request.getParameter("solicitante");
        String puntoVenta =
                request.getParameter("puntoVenta");
        String categoria =
                request.getParameter("categoria");
        String prioridad =
                request.getParameter("prioridad");
        String descripcion =
                request.getParameter("descripcion");

        // Validar campos obligatorios
        if (solicitante == null || solicitante.isBlank()
                || puntoVenta == null || puntoVenta.isBlank()
                || categoria == null || categoria.isBlank()
                || prioridad == null || prioridad.isBlank()
                || descripcion == null || descripcion.isBlank()) {

            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Todos los campos son obligatorios"
            );
            return;
        }

        // Crear objeto del modelo
        Ticket ticket = new Ticket();

        ticket.setCodigo(
            "PH-" + UUID.randomUUID().toString()
                    .substring(0, 8).toUpperCase()
        );

        ticket.setSolicitante(solicitante);
        ticket.setPuntoVenta(puntoVenta);
        ticket.setCategoria(categoria);
        ticket.setPrioridad(prioridad);
        ticket.setDescripcion(descripcion);
        ticket.setEstado("Abierto");

        // Guardar en MySQL mediante DAO
        boolean guardado = ticketDAO.registrar(ticket);

        if (guardado) {
            request.setAttribute("codigo", ticket.getCodigo());
            request.setAttribute("solicitante", ticket.getSolicitante());
            request.setAttribute("puntoVenta", ticket.getPuntoVenta());
            request.setAttribute("categoria", ticket.getCategoria());
            request.setAttribute("prioridad", ticket.getPrioridad());
            request.setAttribute("descripcion", ticket.getDescripcion());
            request.setAttribute("estado", ticket.getEstado());

            request.getRequestDispatcher("/resultado.jsp")
                   .forward(request, response);
        } else {
            response.sendError(
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                "No se pudo registrar el ticket en la base de datos."
            );
        }
    }
}
