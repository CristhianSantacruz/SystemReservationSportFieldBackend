# 📋 Backend del Sistema de Reservación de Canchas

Este repositorio contiene el código fuente de un sistema backend diseñado para gestionar **usuarios**, **grupos**, y **reservaciones de canchas deportivas**. El sistema busca optimizar la administración de estas actividades, ofreciendo una solución eficiente y moderna para facilitar el proceso de reservas.

---

## 🛠️ Funcionalidades Principales

### 👤 Gestión de Usuarios
- **Registro y Autenticación**: Los usuarios pueden registrarse en el sistema utilizando credenciales seguras y autenticarse para acceder a sus funciones.
- **Roles de Usuario**: Soporte para múltiples roles, como usuarios estándar y administradores para supervisión y gestión avanzada.
- **Perfil del Usuario**: Actualización de información personal y consulta de actividades previas.

### 👥 Gestión de Grupos
- **Creación de Grupos**: Los usuarios pueden formar equipos o grupos para organizar actividades deportivas.
- **Invitaciones a Grupos**: Envío de invitaciones a otros usuarios para unirse al grupo.
- **Gestión Interna**: Modificación de nombres del grupo y asignación de roles internos (capitán, miembro).

### 🏟️ Reservación de Canchas
- **Consulta de Disponibilidad**: Ver las canchas disponibles en tiempo real.
- **Reservas Únicas**: Un grupo puede reservar una cancha en un horario específico.
- **Cancelación y Modificación**: Permite cancelar o modificar reservas dentro de un periodo permitido.
- **Historial de Reservas**: Visualización de las reservas previas realizadas por un usuario o grupo.

---

## 🌟 Características Adicionales
- **Notificaciones**: 
  - Recordatorios automáticos para reservas próximas.
  - Alertas en caso de cambios o cancelaciones.
- **Sistema de Reputación**: 
  - Los grupos que cumplan consistentemente con sus reservas pueden ganar puntos de confianza.
  - Los usuarios que no respeten las políticas de cancelación pueden recibir restricciones.
- **Integración con Calendarios**: Sincronización con Google Calendar o Microsoft Outlook.
- **Soporte Multilenguaje**: Disponible en varios idiomas para mejorar la accesibilidad.
- **Estadísticas**:
  - Métricas de uso, como las canchas más reservadas y horarios pico.
  - Panel para administradores con insights sobre el uso del sistema.

---

## 🖥️ Tecnologías Utilizadas
- **Lenguaje**: Kotlin (para un backend moderno y robusto).
- **Framework**: Spring Boot.
- **Base de Datos**: PostgreSQL para almacenamiento relacional.
- **Autenticación**: JWT (JSON Web Tokens) para la seguridad de las sesiones.
- **APIs REST**: Diseño de endpoints para gestionar usuarios, grupos y reservas.
- **Documentación**: Swagger para describir y probar los endpoints de forma interactiva.

---

## 📚 Instalación y Configuración

### Prerrequisitos
- **Java 17+**
- **Maven o Gradle**
- **Servidor de Base de Datos** (PostgreSQL)


### Pasos de Instalación
1. Clonar este repositorio:
   ```bash
   git clone https://github.com/usuario/reservacion-canchas.git
  

