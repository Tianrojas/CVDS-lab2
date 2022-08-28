# Laboratorio 2
===
**Nombre:** Sebastian Rojas

### La herramienta maven
===

1. Cuál es su mayor utilidad?
Entre sus mayores ventajas podemos encontrar:
* Maven puede agregar todas las dependencias necesarias para el proyecto automáticamente leyendo el archivo pom.
* Uno puede construir fácilmente su proyecto para jar, war, etc. según sus requisitos usando Maven.
* Maven facilita el inicio de proyectos en diferentes entornos y no necesita manejar la inyección de dependencias, compilaciones, procesamiento, etc.
* Añadir una nueva dependencia es muy fácil. Uno tiene que escribir el código de dependencia en un archivo pom.

2. Fases de maven:
* **validate:** se encarga de comprobar si toda la información, y todas las dependencias necesarias para la construcción estan disponibles.
* **compile:** realiza la compilación del código fuente.
* **test-compile:** realiza la compilación de los casos de prueba.
* **test:** ejecuta las clases de pruebas.
* **package:** empaquete el código compilado en un paquete distribuible en base al tipo de proyecto (jar, war, ...).
* **integration-test:** ejecuta los test de integración con el paquete ya ensamblado.
* **install:** copia el paquete en el repositorio local.
* **deploy:** copia el paquete en el repositorio remoto.

3. Ciclo de vida de la construcción:
Un ciclo de vida de construcción es una secuencia de fases bien definida, que define el orden en el que se ejecutarán los objetivos. Aquí la fase representa una etapa del ciclo de vida. Como ejemplo, un típicoMaven Build Lifecycle consta que consta de la secuencia de sus fases.

4. Para qué sirven los plugins?
Un Plugin es un fragmento o componente de código hecho para ampliar las funciones de un programa o de una herramienta.

5. Qué es y para qué sirve el repositorio central de maven?

>>El repositorio de Maven es un directorio donde se almacenan todas las dependencias, como jars, archivos de biblioteca, complementos u otros artefactos que requerirán los proyectos. Estos repositorios nos ayudan a almacenar y mantener recursos útiles para que puedan usarse en nuestros proyectos maven mientras construyen e implementan los artefactos. Todo el diseño y la estructura de los repositorios subyacentes de maven de cualquier tipo están completamente ocultos para los usuarios de maven.En este tema, vamos a aprender sobre el MCP.
El repositorio central de maven contiene toda la colección de archivos jar, complementos y bibliotecas que proporciona la comunidad de maven a los usuarios de maven.Este repositorio no necesita ninguna configuración, solo asegúrese de que su IDE/máquina esté conectada a Internet para descargar y usar las dependencias del repositorio central.
Muchas veces, es posible que en las organizaciones no proporcionen acceso a Internet por razones de seguridad y ancho de banda. En estos casos, podemos descargar una copia de los recursos del repositorio central de Maven en el repositorio remoto para uso sin conexión. Esto debe mencionarse en su archivo settings.xml para las rutas del repositorio remoto. Incluso es posible que necesite otros repositorios centrales oficiales distribuidos a través de geografías para buscar y obtener dependencias, esto se denomina espejos en maven y se puede usar haciendo ciertos cambios en el archivo settings.xml.
El siguiente diagrama muestra los componentes y la relación de otros repositorios y el usuario con el repositorio central de maven. La red de entrega de contenido (CDN) del repositorio central se puede ver conectada al usuario experto a través del archivo settings.xml.








## Fuentes
===
[Utilidad de maven](https://tjmbb.org/es/learntek-espa%C3%B1ol/)
[Fases de maven](https://ruben.civeira.net/2020/09/las-fases-del-ciclo-de-vida-de-maven.html)
[Diferencia entre ciclo de vida y fases](https://blog.planview.com/project-phase-life-cycle/)
[Plugings](https://neoattack.com/neowiki/plugin/)
