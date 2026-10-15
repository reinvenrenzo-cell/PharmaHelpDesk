
CREATE DATABASE IF NOT EXISTS pharmahelpdesk
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE pharmahelpdesk;

-- Puntos de venta
CREATE TABLE punto_venta (
    id_punto_venta INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200)
);

-- Colaboradores
CREATE TABLE colaborador (
    id_colaborador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    correo VARCHAR(150),
    id_punto_venta INT NOT NULL,
    FOREIGN KEY (id_punto_venta)
        REFERENCES punto_venta(id_punto_venta)
);

-- Categorías
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL UNIQUE
);

-- Tickets de soporte TI
CREATE TABLE tickets (
    id_ticket INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(40) NOT NULL UNIQUE,
    id_colaborador INT NULL,
    id_categoria INT NULL,
    solicitante VARCHAR(120) NOT NULL,
    punto_venta VARCHAR(100) NOT NULL,
    categoria VARCHAR(60) NOT NULL,
    prioridad ENUM('Baja','Media','Alta') NOT NULL,
    descripcion TEXT NOT NULL,
    estado ENUM(
        'Abierto',
        'En proceso',
        'Resuelto',
        'Cerrado'
    ) NOT NULL DEFAULT 'Abierto',
    solucion TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id_colaborador)
        REFERENCES colaborador(id_colaborador),

    FOREIGN KEY (id_categoria)
        REFERENCES categoria(id_categoria)
);

-- Categorías iniciales
INSERT INTO categoria (nombre) VALUES
('Hardware'),
('Software'),
('Red'),
('Cuenta de usuario'),
('Impresora'),
('Otro');
