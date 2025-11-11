drop database if exists usuarios_perfiles;

create database usuarios_perfiles;

USE usuarios_perfiles;

create table perfiles(
id_perfil int auto_increment PRIMARY KEY not null,
nombre varchar(40) check (nombre in ('ROLE_ADMIN', 'ROLE_JEFE', 'ROLE_TRABAJADOR', 'ROLE_CLIENTE')) not null
);

create table usuarios (
username varchar(50) PRIMARY KEY not null,
nombre varchar(50) not null,
apellidos varchar(100),
email varchar(100) unique not null,
password varchar(255) not null, -- check (password = '{noop}%%'),
enabled int check (enabled in (1,0)) not null default 1, -- añadir al edit en la lsita de usuarios en la vista
direccion varchar(150),
fecha_nacimiento date,
fecha_registro date,
id_perfil int,
FOREIGN KEY (id_perfil) references perfiles(id_perfil)
);