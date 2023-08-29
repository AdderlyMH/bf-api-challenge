# Baufest API challenge

Este es un repositorio que contiene el proyecto bf-api-challenge. Este proyecto es un desafío API y puede contener código, recursos y archivos que inclyen:

* BDD con Cucumber y Gherkin
* RestAssured con Java
* Carga de data con POJO (Plain Old Java Object)
* Carga de data con archivos JSON
* Carga de data con JSON's en formato String
* Configuración de variables globales
* Extracción de parámetros de respuesta
* Reportes en JSON y HTML
* Hooks para ejecutar pasos antes de un escenario
* Ejecución de pruebas con comandos en terminal y Jenkins
* Logs

## Clonar repositorio

Para clonar este repositorio en tu máquina local, puedes seguir estos pasos:

1. Abre tu terminal o línea de comandos.

2. Navega al directorio donde desees clonar el repositorio.

3. Ejecuta el siguiente comando:

   ```bash
   git clone https://github.com/AdderlyMH/bf-api-challenge.git
   ```

## Data de prueba

La data de prueba se puede ingresar o modificar  en los archivos *feature* ubicados en:

   ```bash
   src/test/java/features/
   ```

## Ejecución de Pruebas

Es posible ejecutar las pruebas de distintas formas:

1. Ejecutando el archivo que se encuentra en la siguiente ubicación del proyecto:

   ```bash
   cucumber/Options/TestRunner.java
   ```

   Al terminar, se creará un reporte JSON en la siguiente ubicación del proyecto:

   ```bash
   target/jsonReports/cucumber-report.json
   ```

2. Vía comando en el terminal usando un perfil. Existe un perfil nombrado *Regression* dentro del proyecto que se puede ejecutar con el siguiente comando:

   ```bash
   mvn verify
   ```

   Al terminar, se creará una serie de reportes HTML en la siguiente ubicación del proyecto:
   
      ```bash
      target/cucumber-html-reports/
      ```

## Logs

Quedarán registrados los datos de cada ejecución a la API, tanto del *request* como del *response* en el archivo **log.txt**