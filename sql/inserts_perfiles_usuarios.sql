USE usuarios_perfiles;
-- Insertar perfiles válidos
INSERT INTO perfiles (nombre) VALUES
('ROLE_ADMIN'),
('ROLE_JEFE'),
('ROLE_TRABAJADOR'),
('ROLE_CLIENTE');

-- Insertar usuarios asociados a los perfiles
INSERT INTO usuarios (username, nombre, apellidos, email, password, enabled, direccion, fecha_nacimiento, fecha_registro, id_perfil) VALUES
('admin1', 'Carlos', 'Pérez López', 'carlos.perez@example.com', '{noop}admin123', 1, 'Calle Mayor 12, Madrid', '1990-04-15', CURDATE(), 1),
('jefe1', 'Laura', 'García Sánchez', 'laura.garcia@example.com', '{noop}jefe123', 1, 'Avenida del Sol 45, Valencia', '1987-09-22', CURDATE(), 2),
('trabajador1', 'Miguel', 'Rodríguez Torres', 'miguel.rodriguez@example.com', '{noop}trabajo123', 1, 'Calle Luna 8, Sevilla', '1993-12-03', CURDATE(), 3),
('cliente1', 'Ana', 'Martín Gómez', 'ana.martin@example.com', '{noop}cliente123', 1, 'Calle Real 23, Bilbao', '1998-06-10', CURDATE(), 4),
('trabajador2', 'Javier', 'Fernández Ruiz', 'javier.fernandez@example.com', '{noop}trabajo123', 0, 'Paseo del Prado 67, Madrid', '1995-01-30', CURDATE(), 3),
('cliente2', 'Elena', 'Santos Moreno', 'elena.santos@example.com', '{noop}cliente123', 1, 'Calle Verde 14, Málaga', '1992-03-18', CURDATE(), 4),
('jefe2', 'Raúl', 'Jiménez Castro', 'raul.jimenez@example.com', '{noop}jefe456', 1, 'Calle del Río 9, Granada', '1985-08-25', CURDATE(), 2),
('admin2', 'Sofía', 'Domínguez Vargas', 'sofia.dominguez@example.com', '{noop}admin456', 1, 'Avenida Central 101, Zaragoza', '1989-11-09', CURDATE(), 1),
('cliente3', 'María', 'López Ortega', 'maria.lopez@example.com', '{noop}cliente789', 1, 'Calle Jardín 4, Madrid', '1997-02-11', CURDATE(), 4),
('cliente4', 'Pedro', 'Sanz Molina', 'pedro.sanz@example.com', '{noop}cliente456', 1, 'Plaza Norte 21, Toledo', '1995-05-19', CURDATE(), 4),
('cliente5', 'Lucía', 'Ramírez León', 'lucia.ramirez@example.com', '{noop}clientexyz', 1, 'Calle Azul 99, Murcia', '2000-10-06', CURDATE(), 4),
('cliente6', 'Alberto', 'Cano Vidal', 'alberto.cano@example.com', '{noop}cliente111', 0, 'Avenida Sur 18, Cádiz', '1993-03-25', CURDATE(), 4),
('cliente7', 'Isabel', 'Crespo Iglesias', 'isabel.crespo@example.com', '{noop}cliente222', 1, 'Calle Verde 17, Oviedo', '1999-07-14', CURDATE(), 4),

('trabajador3', 'Hugo', 'Navarro Ruiz', 'hugo.navarro@example.com', '{noop}trabajo555', 1, 'Calle Pez 6, Madrid', '1991-11-20', CURDATE(), 3),
('trabajador4', 'Diego', 'Suárez Bravo', 'diego.suarez@example.com', '{noop}trabajo742', 1, 'Calle Estrella 12, León', '1994-04-02', CURDATE(), 3),
('trabajador5', 'Valeria', 'Prieto Cano', 'valeria.prieto@example.com', '{noop}trabajo321', 1, 'Calle Norte 48, Burgos', '1996-05-26', CURDATE(), 3),
('trabajador6', 'Adrián', 'Romero Vega', 'adrian.romero@example.com', '{noop}trabajo876', 0, 'Avenida Oeste 30, Coruña', '1992-12-15', CURDATE(), 3),
('trabajador7', 'Marta', 'Rubio Peña', 'marta.rubio@example.com', '{noop}trabajo909', 1, 'Calle Sol 3, Valencia', '1997-09-03', CURDATE(), 3),

('jefe3', 'Daniel', 'Campos Rivas', 'daniel.campos@example.com', '{noop}jefe789', 1, 'Paseo Real 44, Barcelona', '1988-01-11', CURDATE(), 2),
('jefe4', 'Claudia', 'Herrera Ortiz', 'claudia.herrera@example.com', '{noop}jefe999', 1, 'Avenida Dorada 55, Málaga', '1986-06-08', CURDATE(), 2),
('jefe5', 'Iván', 'Reyes Delgado', 'ivan.reyes@example.com', '{noop}jefe147', 0, 'Calle Fuego 19, Bilbao', '1990-03-12', CURDATE(), 2),
('jefe6', 'Nuria', 'Gómez Sáez', 'nuria.gomez@example.com', '{noop}jefe753', 1, 'Calle Ángel 10, Logroño', '1984-07-27', CURDATE(), 2),
('jefe7', 'Óscar', 'Benítez Roldán', 'oscar.benitez@example.com', '{noop}jefe258', 1, 'Calle Norte 5, Madrid', '1983-12-22', CURDATE(), 2),

('admin3', 'Pablo', 'Ortiz Cabrera', 'pablo.ortiz@example.com', '{noop}admin789', 1, 'Calle Mayor 2, Sevilla', '1989-11-02', CURDATE(), 1),
('admin4', 'Elena', 'Vega Santos', 'elena.vega@example.com', '{noop}admin951', 1, 'Plaza Roja 101, Zamora', '1991-01-15', CURDATE(), 1),
('admin5', 'Ricardo', 'Morales Paz', 'ricardo.morales@example.com', '{noop}admin357', 0, 'Avenida Norte 77, Huelva', '1987-08-09', CURDATE(), 1),
('admin6', 'Silvia', 'Durán Román', 'silvia.duran@example.com', '{noop}admin654', 1, 'Calle Nueva 4, Valencia', '1993-04-21', CURDATE(), 1),
('admin7', 'Jorge', 'Ibáñez Nieto', 'jorge.ibanez@example.com', '{noop}admin753', 1, 'Calle Larga 33, Santander', '1990-09-18', CURDATE(), 1),

('cliente8', 'Rosa', 'Delgado Ruiz', 'rosa.delgado@example.com', '{noop}cliente989', 1, 'Calle Oro 55, Alicante', '1998-02-14', CURDATE(), 4),
('trabajador8', 'Mario', 'Soto Vidal', 'mario.soto@example.com', '{noop}trabajo443', 1, 'Calle Viento 27, Valladolid', '1995-06-07', CURDATE(), 3);
