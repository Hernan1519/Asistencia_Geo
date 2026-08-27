# GeoAsist 📍

Aplicación Backend desarrollada con **Java 21 y Spring Boot** para gestionar la asistencia mediante **códigos QR y validación de ubicación**.

El sistema busca verificar que el usuario se encuentre en el lugar correspondiente al momento de registrar su asistencia.

Proyecto académico desarrollado durante la **Tecnicatura Universitaria en Programación – UTN Haedo**.

## 🚀 Tecnologías

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* PostgreSQL
* JWT
* BCrypt
* Maven
* Lombok
* REST API
* Git / GitHub

## 🏗️ Arquitectura

Arquitectura por capas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

Paquetes principales:

* `model` → Entidades
* `dto` → Objetos de transferencia
* `repository` → Acceso a datos
* `service` → Lógica de negocio
* `controller` → Endpoints REST
* `security` → Autenticación y seguridad

## 🔐 Seguridad

Flujo de autenticación:

```text
Login
  ↓
AuthenticationManager
  ↓
UserDetailsService
  ↓
PostgreSQL
  ↓
BCrypt
  ↓
Authentication
  ↓
JwtService
  ↓
JWT
```

El JWT contiene información del usuario, roles, fecha de emisión y expiración.

## 📌 Estado

* [x] Persistencia JPA / Hibernate
* [x] PostgreSQL
* [x] Arquitectura por capas
* [x] DTOs y validaciones
* [x] Manejo de excepciones
* [x] Spring Security
* [x] Autenticación
* [x] BCrypt
* [x] Generación de JWT
* [ ] Filtro JWT
* [ ] Protección de endpoints
* [ ] Validación de ubicación
* [ ] Registro de asistencia mediante QR

## 👨‍💻 Autor

**Javier Hernán Rios**

Tecnicatura Universitaria en Programación – UTN Haedo

**Enfoque:** Backend Java | Spring Boot | PostgreSQL
