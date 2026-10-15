
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Ticket registrado - PharmaHelpDesk</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 30px 15px;
            font-family: Arial, sans-serif;
            background: #f1f5f9;
            color: #1e293b;
        }

        .contenedor {
            max-width: 650px;
            margin: 30px auto;
            padding: 35px;
            background: white;
            border-radius: 14px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.08);
        }

        h1 {
            text-align: center;
            color: #15803d;
        }

        .subtitulo {
            text-align: center;
            color: #64748b;
        }

        .codigo {
            margin: 25px 0;
            padding: 20px;
            background: #dcfce7;
            border-radius: 10px;
            text-align: center;
            overflow-wrap: anywhere;
        }

        .codigo strong {
            display: block;
            margin-top: 8px;
            font-size: 19px;
            color: #166534;
        }

        .detalle {
            padding: 12px 0;
            border-bottom: 1px solid #e2e8f0;
        }

        .detalle strong {
            display: block;
            margin-bottom: 5px;
        }

        .estado {
            color: #2563eb;
            font-weight: bold;
        }

        .boton {
            display: block;
            margin-top: 30px;
            padding: 14px;
            text-align: center;
            background: #2563eb;
            color: white;
            border-radius: 8px;
            text-decoration: none;
        }

        .boton:hover {
            background: #1d4ed8;
        }
    </style>
</head>

<body>

<div class="contenedor">

    <h1>Ticket registrado correctamente</h1>

    <p class="subtitulo">
        PharmaHelpDesk - Boticas Hogar y Salud
    </p>

    <div class="codigo">
        Código de seguimiento
        <strong>${ticket.codigo}</strong>
    </div>

    <div class="detalle">
        <strong>Solicitante:</strong>
        ${ticket.solicitante}
    </div>

    <div class="detalle">
        <strong>Punto de venta:</strong>
        ${ticket.puntoVenta}
    </div>

    <div class="detalle">
        <strong>Categoría:</strong>
        ${ticket.categoria}
    </div>

    <div class="detalle">
        <strong>Prioridad:</strong>
        ${ticket.prioridad}
    </div>

    <div class="detalle">
        <strong>Descripción:</strong>
        ${ticket.descripcion}
    </div>

    <div class="detalle">
        <strong>Estado:</strong>
        <span class="estado">${ticket.estado}</span>
    </div>

    <a href="${pageContext.request.contextPath}/index.jsp"
       class="boton">
        Registrar otro ticket
    </a>

</div>

</body>
</html>
