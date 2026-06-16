# Sistema GreenBite - Módulo de Autenticación y Registro

## Integrantes
* Cory Leveke
* Jean Portino
* Benjamin Ruz

## 1. Arquitectura de Microservicios y Puertos
* **Microservicio Auth:** Corriendo en `http://localhost:8080` (Persistencia en Base de Datos H2)
* **BFF Agregador:** Corriendo en `http://localhost:8082`

## 2. Instrucciones de Ejecución (Mediante IDE / VS Code)
1. Abrir la carpeta raíz del proyecto en Visual Studio Code (asegurar tener instalado el "Extension Pack for Java").
2. Dirigirse a la pestaña lateral izquierda del **Spring Boot Dashboard**.
3. Seleccionar el componente `microservicio-login` y hacer clic en el botón de **Start** (Play).
4. Seleccionar el componente `greenbite-bff` y hacer clic en el botón de **Start** (Play).

## 3. Planificación y Ejecución de Pruebas Unitarias
1. En el explorador de archivos de VS Code, abrir la ruta: `src/test/java/com/duoc/auth/service/AuthServiceTest.java`.
2. Hacer clic en el botón **Run Test** (icono de Play verde) situado sobre la cabecera de la clase para ejecutar el entorno de JUnit 5 y Mockito.
3. Tras la finalización de los tests, el reporte automatizado de métricas de cobertura de código se generará de forma local en la ruta: `microservicio-login/target/site/jacoco/index.html`.

## 4. Especificación de la API REST (Contratos de Comunicación)

### POST: Registro de Usuario (Consumido a través del BFF)
* **URL:** `http://localhost:8082/api/bff/registro`
* **Headers:** `Content-Type: application/json`
* **Payload de Entrada (JSON):**
```json
{
  "rut": "12.345.678-9",
  "nombre": "Benjamin",
  "apellido": "Ruz",
  "email": "benja@duocuc.cl",
  "password": "password123",
  "fechaNacimiento": "2000-01-01",
  "direccion": "Av. Alameda 123",
  "region": "Metropolitana",
  "comuna": "Lo Espejo"
}
