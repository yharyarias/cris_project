/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Yhary
 * Created: 24 abr 2024
 */

-- Crear tabla roles si no existe
CREATE TABLE IF NOT EXISTS roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    can_create BOOLEAN,
    can_read BOOLEAN,
    can_update BOOLEAN,
    can_delete BOOLEAN
);

-- Insertar roles si no existen
INSERT INTO roles (name, can_create, can_read, can_update, can_delete) 
VALUES
('Administrador', true, true, true, true),
('Usuario', true, true, false, false)
ON DUPLICATE KEY UPDATE name = VALUES(name), 
                        can_create = VALUES(can_create), 
                        can_read = VALUES(can_read), 
                        can_update = VALUES(can_update), 
                        can_delete = VALUES(can_delete);

-- Crear tabla users si no existe
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Insertar registros en la tabla users si no existen
INSERT INTO users (username, password, role_id) 
VALUES
('admin', 'admin123', 1), -- Usuario administrador
('user', 'user123', 2) -- Usuario estándar
ON DUPLICATE KEY UPDATE username = VALUES(username), 
                        password = VALUES(password), 
                        role_id = VALUES(role_id);
