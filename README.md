# Back-end Proyecto Usuarios AJE

API REST desarrollada con Spring Boot para la gestión de usuarios con control de acceso basado en perfiles y autenticación básica.

## 📋 Descripción

Este proyecto es una API REST robusta que implementa un sistema completo de gestión de usuarios con control de permisos basado en perfiles. Utiliza Spring Security para la autenticación y autorización, garantizando la seguridad de los endpoints según el perfil del usuario autenticado.

## 🚀 Tecnologías Utilizadas

- **Java** - Lenguaje de programación principal
- **Spring Boot** - Framework para el desarrollo de la aplicación
- **Spring Security** - Gestión de autenticación y autorización
- **Spring Data JPA** - Capa de persistencia
- **MySQL** - Sistema de gestión de base de datos
- **Maven/Gradle** - Gestión de dependencias

## 📁 Estructura del Proyecto

```
src/main/java/
├── model/          # Entidades JPA (Usuario, Perfil)
├── repository/     # Interfaces JPA Repository
├── controller/     # REST Controllers con endpoints
└── security/       # Configuración de Spring Security

sql/
├── scriptdb.sql                      # Script de creación de base de datos
└── inserts_perfiles_usuarios.sql    # Datos iniciales
```

## 🔧 Configuración Inicial

### Prerrequisitos

- JDK 17 o superior
- MySQL 8.0 o superior
- Maven 3.6+ o Gradle 7.0+

### Base de Datos

1. **Crear la base de datos:**
   ```bash
   mysql -u root -p < sql/scriptdb.sql
   ```

2. **Insertar datos iniciales:**
   ```bash
   mysql -u root -p < sql/inserts_perfiles_usuarios.sql
   ```

3. **Configurar conexión en `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

### Instalación y Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/Eduu115/Back-end-proyecto-usuarios-AJE.git
   cd Back-end-proyecto-usuarios-AJE
   ```

2. **Compilar el proyecto:**
   ```bash
   mvn clean install
   # o con Gradle:
   gradle build
   ```

3. **Ejecutar la aplicación:**
   ```bash
   mvn spring-boot:run
   # o con Gradle:
   gradle bootRun
   ```

La aplicación estará disponible en `http://localhost:9001`

## 🖥️ Aplicación Cliente (Front-end)

Además de usar la API directamente, puedes utilizar la **aplicación web completa** con interfaz gráfica desarrollada en React que consume todos los endpoints de esta API REST.

**Repositorio del cliente:** [Client-env-proyecto-AJE](https://github.com/Eduu115/Client-env-proyecto-AJE.git)

Esta aplicación front-end proporciona:
- Interfaz de usuario completa para todas las funcionalidades
- Gestión visual de usuarios y perfiles
- Formularios de registro y login
- Panel de administración
- Integración completa con todos los endpoints del API

Para usar la aplicación completa:
1. Asegúrate de tener el back-end corriendo (este proyecto)
2. Clona e instala el repositorio del cliente
3. Ejecuta el front-end siguiendo las instrucciones de su README

De esta forma tendrás la aplicación web completa funcionando con su parte cliente y servidor.

## 🔐 Autenticación

La API utiliza **Autenticación Básica HTTP** (Basic Auth). Debes incluir las credenciales en cada petición:

```bash
curl -u usuario:contraseña http://localhost:9001/api/endpoint
```

O en el header:
```
Authorization: Basic base64(usuario:contraseña)
```

## 📌 Endpoints de la API

### Usuarios (`/usuarios`)

| Método | Endpoint | Descripción | Body/Parámetros |
|--------|----------|-------------|-----------------|
| GET | `/usuarios/` | Obtener todos los usuarios | - |
| POST | `/usuarios/login` | Iniciar sesión (requiere Basic Auth) | - |
| POST | `/usuarios/registro` | Registrar nuevo usuario | `UsuarioDtoRegister` |
| POST | `/usuarios/registro/admin` | Registro con asignación de perfil (Admin) | `Usuario` con perfil |
| PUT | `/usuarios/actualizar/{username}` | Actualizar datos de usuario | `Usuario` |
| DELETE | `/usuarios/eliminar/{username}` | Eliminar usuario por username | `username` en path |

#### Ejemplo de Body para Registro:
```json
{
  "username": "usuario123",
  "password": "password123",
  "nombre": "Juan",
  "apellidos": "Pérez García",
  "email": "juan@example.com"
}
```

#### Ejemplo de Body para Registro Admin:
```json
{
  "username": "admin123",
  "password": "admin123",
  "nombre": "Admin",
  "apellidos": "Sistema",
  "email": "admin@example.com",
  "perfil": {
    "idPerfil": 1
  }
}
```

### Perfiles (`/perfiles`)

| Método | Endpoint | Descripción | Parámetros |
|--------|----------|-------------|------------|
| GET | `/perfiles/` | Obtener todos los perfiles | - |
| GET | `/perfiles/{idPerfil}` | Obtener perfil por ID | `idPerfil` en path |

### Notas Importantes

- ⚠️ **CORS habilitado**: Permite peticiones desde cualquier origen (`*`)
- 🔐 **Autenticación**: El endpoint `/usuarios/login` requiere autenticación básica HTTP
- 📝 **Respuestas**: Todos los endpoints devuelven `ResponseEntity` con código HTTP apropiado
- 🔄 **Actualización**: Al actualizar un usuario, el username se toma del path parameter
- ❌ **Eliminación**: Retorna `1` si se eliminó correctamente, `0` si el usuario no existe

## 👥 Sistema de Perfiles

El sistema implementa control de acceso basado en roles/perfiles:

- **ADMIN**: Acceso completo a todos los endpoints (CRUD completo)
- **USER**: Acceso de solo lectura a ciertos recursos
- **Otros perfiles**: Según la configuración en la base de datos

Los permisos se cargan desde la tabla `perfiles` y se asignan a cada usuario.

## 🗃️ Modelo de Datos

### Usuario
- Información básica del usuario
- Relación con Perfil (ManyToOne o similar)
- Credenciales de autenticación

### Perfil
- Define los permisos y roles
- Asociado a uno o múltiples usuarios
- Determina el acceso a endpoints protegidos

## 🛡️ Seguridad

- **Spring Security** configurado para autenticación básica
- Endpoints protegidos según perfil del usuario
- Validación de credenciales en cada petición
- Gestión de permisos a nivel de método/endpoint

## 📝 Notas de Desarrollo

- Toda la configuración está preparada para entorno local
- Los scripts SQL incluyen la estructura completa de la base de datos
- Se recomienda cambiar las credenciales por defecto en producción
- Para entornos de producción, considerar implementar JWT en lugar de Basic Auth

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o pull request para sugerencias o mejoras.

## 📄 Licencia

Este proyecto está bajo la Licencia Apache 2.0 - ver el archivo [LICENSE](LICENSE) para más detalles.

## ✒️ Autores

- **Eduardo Serrano** - [GitHub](https://github.com/Eduu115)
- **Anthony** - [GitHub](https://github.com/Tony1406)
- **Juan Guevara** - [GitHub](https://github.com/juan-guevara-m)

---

⭐ Si este proyecto te ha sido útil, ¡no olvides darle una estrella!
