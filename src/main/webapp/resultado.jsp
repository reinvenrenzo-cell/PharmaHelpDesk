
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ticket - PharmaHelpDesk</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f5f9;
            text-align: center;
            padding: 40px;
        }

        .contenedor {
            background: white;
            max-width: 550px;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px #ddd;
        }

        h1 {
            color: #1769aa;
        }

        .estado {
            color: #b36b00;
            font-weight: bold;
        }

        a {
            display: inline-block;
            background: #1769aa;
            color: white;
            padding: 12px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="contenedor">
    <h1>PharmaHelpDesk</h1>
    <h2>Incidencia recibida</h2>

    <p><strong>Solicitante:</strong>
        ${solicitante}</p>

    <p><strong>Punto de venta:</strong>
        ${puntoVenta}</p>

    <p><strong>Categoría:</strong>
        ${categoria}</p>

    <p><strong>Prioridad:</strong>
        ${prioridad}</p>

    <p><strong>Descripción:</strong>
        ${descripcion}</p>

    <p><strong>Estado:</strong>
        <span class="estado">${estado}</span>
    </p>

    <a href="${pageContext.request.contextPath}/index.jsp">
        Registrar otra incidencia
    </a>
</div>

</body>
</html>
