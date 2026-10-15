
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>PharmaHelpDesk</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f5f9;
            margin: 0;
        }

        header {
            background: #123456;
            color: white;
            padding: 20px;
            text-align: center;
        }

        main {
            background: white;
            max-width: 550px;
            margin: 40px auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px #ddd;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
        }

        button {
            background: #1769aa;
            color: white;
            padding: 12px;
            border: none;
            margin-top: 20px;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<header>
    <h1>PharmaHelpDesk</h1>
    <p>Boticas Hogar y Salud</p>
    <p>Sistema de Gestión de Incidencias TI</p>
</header>

<main>
    <h2>Registrar incidencia</h2>

    <form action="${pageContext.request.contextPath}/registrar"
          method="post">

        <label>Nombre del solicitante:</label>
        <input type="text" name="solicitante" required>

        <label>Punto de venta:</label>
        <input type="text" name="puntoVenta" required>

        <label>Categoría:</label>
        <select name="categoria" required>
            <option value="">Seleccione</option>
            <option>Hardware</option>
            <option>Software</option>
            <option>Red</option>
            <option>Cuenta de usuario</option>
            <option>Impresora</option>
            <option>Otro</option>
        </select>

        <label>Prioridad:</label>
        <select name="prioridad" required>
            <option value="">Seleccione</option>
            <option>Baja</option>
            <option>Media</option>
            <option>Alta</option>
        </select>

        <label>Descripción:</label>
        <textarea name="descripcion"
                  rows="4" required></textarea>

        <button type="submit">
            Registrar Ticket
        </button>
    </form>
</main>

</body>
</html>
