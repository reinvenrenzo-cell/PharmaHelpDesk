
package pe.edu.pharmahelpdesk.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registrar")
public class TicketServlet extends HttpServlet {

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

        // Estado inicial según regla RN03
        String estado = "Abierto";

        // Enviar datos a la vista de resultado
        request.setAttribute("solicitante", solicitante);
        request.setAttribute("puntoVenta", puntoVenta);
        request.setAttribute("categoria", categoria);
        request.setAttribute("prioridad", prioridad);
        request.setAttribute("descripcion", descripcion);
        request.setAttribute("estado", estado);

        request.getRequestDispatcher("/resultado.jsp")
                .forward(request, response);
    }
}
