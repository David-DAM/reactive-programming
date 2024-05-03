# PROGRAMACIÓN REACTIVA

## Descripción General
Este proyecto implementa un sistema CRUD para la entidad `Producto` utilizando programación reactiva para manejar de manera eficiente las operaciones asíncronas y los flujos de datos.

## Tecnologías Utilizadas
- **Spring WebFlux**: Para el manejo de la programación reactiva en el servidor.
- **Project Reactor**: Proporciona las APIs reactivas, como `Mono` y `Flux`.
- **MYSQL**: Base de datos SQL que soporta operaciones reactivas.
- **JUnit**: Para la creación de pruebas unitarias.
- **Lombok**: Para facilitar evitar la generación de código innecesario
- **Docker**: Para facilitar la generación de servicios
- **Configuration-processor**: Para la creación de propiedades de configuración propias

## Estructura del CRUD
Se definen cuatro operaciones básicas:
- **Crear**: Añade un nuevo `Producto`.
- **Leer**: Obtiene un `Producto` por su `id`.
- **Actualizar**: Modifica un `Producto` existente.
- **Eliminar**: Remueve un `Producto` del sistema.

## Pruebas
Se realizan tests de prueba para probar funcionalidades de la programación reactiva
