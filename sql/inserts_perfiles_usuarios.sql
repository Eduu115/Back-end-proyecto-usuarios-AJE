USE usuarios_perfiles;
-- Insertar perfiles válidos
INSERT INTO perfiles (nombre) VALUES
('ROLE_ADMIN'),
('ROLE_JEFE'),
('ROLE_TRABAJADOR'),
('ROLE_CLIENTE');

-- Insertar usuarios asociados a los perfiles
INSERT INTO usuarios (username, nombre, apellidos, email, password, enabled, direccion, fecha_nacimiento, fecha_registro, id_perfil) VALUES
('admin1', 'Carlos', 'Pérez López', 'carlos.perez@example.com', 'admin123', 1, 'Calle Mayor 12, Madrid', '1990-04-15', CURDATE(), 1),
('jefe1', 'Laura', 'García Sánchez', 'laura.garcia@example.com', 'jefe123', 1, 'Avenida del Sol 45, Valencia', '1987-09-22', CURDATE(), 2),
('trabajador1', 'Miguel', 'Rodríguez Torres', 'miguel.rodriguez@example.com', 'trabajo123', 1, 'Calle Luna 8, Sevilla', '1993-12-03', CURDATE(), 3),
('cliente1', 'Ana', 'Martín Gómez', 'ana.martin@example.com', 'cliente123', 1, 'Calle Real 23, Bilbao', '1998-06-10', CURDATE(), 4),
('trabajador2', 'Javier', 'Fernández Ruiz', 'javier.fernandez@example.com', 'trabajo123', 0, 'Paseo del Prado 67, Madrid', '1995-01-30', CURDATE(), 3),
('cliente2', 'Elena', 'Santos Moreno', 'elena.santos@example.com', 'cliente123', 1, 'Calle Verde 14, Málaga', '1992-03-18', CURDATE(), 4),
('jefe2', 'Raúl', 'Jiménez Castro', 'raul.jimenez@example.com', 'jefe456', 1, 'Calle del Río 9, Granada', '1985-08-25', CURDATE(), 2),
('admin2', 'Sofía', 'Domínguez Vargas', 'sofia.dominguez@example.com', 'admin456', 1, 'Avenida Central 101, Zaragoza', '1989-11-09', CURDATE(), 1);
