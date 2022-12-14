LABORATORIO 2 - PATTERNS
===
**Nombre:** Sebastian Rojas

## PATTERNS - FACTORY
### LA HERRAMIENTA MAVEN

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
   >Un ciclo de vida de construcción es una secuencia de fases bien definida, que define el orden en el que se ejecutarán los objetivos. Aquí la fase representa una etapa del ciclo de vida. Como ejemplo, un típicoMaven Build Lifecycle consta que consta de la secuencia de sus fases.

4. Para qué sirven los plugins?
   >Un Plugin es un fragmento o componente de código hecho para ampliar las funciones de un programa o de una herramienta.

5. Qué es y para qué sirve el repositorio central de maven?

   >El repositorio de Maven es un directorio donde se almacenan todas las dependencias, como jars, archivos de biblioteca, complementos u otros artefactos que requerirán los proyectos. Estos repositorios nos ayudan a almacenar y mantener recursos útiles para que puedan usarse en nuestros proyectos maven mientras construyen e implementan los artefactos. Todo el diseño y la estructura de los repositorios subyacentes de maven de cualquier tipo están completamente ocultos para los usuarios de maven.En este tema, vamos a aprender sobre el MCP.
   El repositorio central de maven contiene toda la colección de archivos jar, complementos y bibliotecas que proporciona la comunidad de maven a los usuarios de maven.Este repositorio no necesita ninguna configuración, solo asegúrese de que su IDE/máquina esté conectada a Internet para descargar y usar las dependencias del repositorio central.
   Muchas veces, es posible que en las organizaciones no proporcionen acceso a Internet por razones de seguridad y ancho de banda. En estos casos, podemos descargar una copia de los recursos del repositorio central de Maven en el repositorio remoto para uso sin conexión. Esto debe mencionarse en su archivo settings.xml para las rutas del repositorio remoto. Incluso es posible que necesite otros repositorios centrales oficiales distribuidos a través de geografías para buscar y obtener dependencias, esto se denomina espejos en maven y se puede usar haciendo ciertos cambios en el archivo settings.xml.
   El siguiente diagrama muestra los componentes y la relación de otros repositorios y el usuario con el repositorio central de maven. La red de entrega de contenido (CDN) del repositorio central se puede ver conectada al usuario experto a través del archivo settings.xml.

## EJERCICIO DE LAS FIGURAS
### CREAR UN PROYECTO CON MAVEN

Se crea un proyecto maven con ayuda de los arquetipos (archetypes) con el siguiente comando
`mvn archetype:generate -Dfilter=maven-archetype-quickstart`.
En donde tendremos que especificar las caracteristicas provistas por el documento
   * Grupo: edu.eci.cvds
   * Id del Artefacto: Patterns
   * Paquete: edu.eci.cvds.patterns
   * archetypeArtifactId: maven-archetype-quickstart

![1](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/1.png)

Luego nos dirigimos a la carpeta Patterns y escribimos el comando `tree` para visualizar el listado de las rutas de carpetas

![2](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/2.png)

### AJUSTAR ALGUNAS CONFIGURACIONES EN EL PROYECTO

* Edite el archivo pom.xml y realize la siguiente actualización, Hay que cambiar la version del compilador de Java a la versión 8, para ello, agregue la sección properties antes de la sección de dependencias \
![6](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/6.png)

### COMPILAR Y EJECUTAR

Para compilar ejecute el comando:
```
$ mvn package
```
Si maven no actualiza las dependencias utilice la opción -U asi:
```
$ mvn -U package
```
* Busque cuál es el objetivo del parámetro "package" y qué otros parámetros se podrían enviar al comando mvn.
   * Su función es tomar el código compilado y empaquetarlo en su formato distribuible, como un JAR. Este comando construye el proyecto maven y lo empaqueta en un JAR, WAR, etc.
   * Podemos encontrar una multitud de parametros tales como: `clean`,`compiler:compile`,`compiler:testCompile`,`install`,`deploy`,`validate`,`dependency:tree`,`dependency:analyze`,`archetype:generate`,`test`, `compile`, `verify`, entre otros...


* Busque cómo ejecutar desde línea de comandos, un proyecto maven y verifique la salida cuando se ejecuta con la clase App.java como parámetro en "mainClass"
   * Para ejecutar el proyecto debe ejecutar el siguiente comando:
      ```
      mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.App"
      ```

* Buscar cómo enviar parámetros al plugin "exec".
   * Para enviar parametro ingresesar el siguiente comando 
      ```
      mvn exec: exec -Dexec.executable = "maven" [-Dexec.workingdir = "/ tmp"] -Dexec.args = "- X myproject: dist"
      ```

* Ejecutar nuevamente la clase desde línea de comandos y verificar la salida: ```Hello World!``` 
   *  \
   ![3](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/3.png)

* Ejecutar la clase desde línea de comandos enviando su nombre como parámetro y verificar la salida. Ej: Hello Pepito!
   * Cuando ejecuté el comando con argumentos nada ocurrió, seguía apareciendo "Hello world" así que vi el código de App.java y me dí cuenta que aunque recibía el parametro `args` no realizaba ningúna acción con este, por lo que cambíe el codigo a uno que sí tratará el argumento como se deseaba, volví a compilarlo con `mvn pattern` y lo corrí nuevamente con el argumento "Sebastian" \
   ![4](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/4.png)

* Verifique cómo enviar los parámetros de forma "compuesta" para que el saludo se realice con nombre y apellido. Ejecutar nuevamente y verifi car la salida en consola. Ej: Hello Pepito Perez!
   * Sintax: `mvn exec:java -Dexec.mainClass=test.Main -Dexec.args="'argument separated with space' 'another one'"` \
   ![5](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/5.png)

### HACER EL ESQUELETO DE LA APLICACION

* Esqueleto creado!
* Ejecute múltiples veces la clase ShapeMain , usando el plugin exec de maven con los siguientes parámetros y verifi que la salida en consola para cada una
   * ***Sin parámetros:***  \
      ![7](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/7.png)  \
      Corre el programa, entrando a la parte de if donde imprime que un parametro es requerido
   * ***Parámetro: qwerty***  \
      ![8](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/8.png)   \
      Aunque la figura no está dentro de las figuras de la interfaz se lanza una excepción comunicandolo.
   * ***Parámetro: pentagon***  \
      ![9](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/9.png)   \
      Aunque la figura no está dentro de las figuras de la interfaz se lanza una excepción comunicandolo, esto debido a que no es exactamente el formato que se encuentra en archivo Enum. 
   * ***Parámetro Hexagon***  \
      ![10](https://github.com/Tianrojas/LABORATORIO-2/blob/main/resourse/10.png)   \
      Retorna exactamente los lados de la figura ingresada

## ENTREGAR
* Investigue para qué sirve ***"gitignore"*** y cómo se usa. Para futuras entregas, debe estar configurado
   * Git ve cada archivo de tu copia de trabajo de una de las siguientes maneras:
      1. Con seguimiento: Un archivo que se ha preparado o confirmado previamente.
      2. Sin seguimiento: Un archivo que no se ha preparado o confirmado.
      3. Ignorado: Un archivo que se le ha indicado explícitamente a Git que ignore.
      
      Los archivos ignorados suelen ser artefactos de compilación y archivos generados por el equipo que pueden derivarse de tu fuente de repositorios o que no deberían confirmarse por algún otro motivo. Estos son algunos ejemplos habituales:
      * Cachés de dependencias, como es el caso del contenido de /node_modules o /packages.
      * Código compilado como, por ejemplo, los archivos .o, .pyc y .class.
      * Directorios de salida de compilación, como es el caso de /bin, /out o /target.
      * Archivos generados en tiempo de ejecución como, por ejemplo, .log, .lock o .tmp.
      * Archivos ocultos del sistema, como es el caso de .DS_Store o Thumbs.db.
      * Archivos personales de configuración de IDE como, por ejemplo, .idea/workspace.xml.
      
      A los archivos ignorados se les hace un seguimiento en un archivo especial llamado `.gitignore` que se incorpora en la raíz de tu repositorio. En Git no hay ningún comando explícito para ignorar archivos: en su lugar, cuando tengas nuevos archivos que quieras ignorar, deberás editar y confirmar manualmente el archivo `.gitignore`. Los archivos `.gitignore` contienen patrones que establecen coincidencias con los nombres de archivo de tu repositorio para determinar si deberían ignorarse o no.


### __Autores__

* [Sebastian Rojas](https://github.com/Tianrojas)




Fuentes
===
* [Utilidad de maven](https://tjmbb.org/es/learntek-espa%C3%B1ol/)
* [Fases de maven](https://ruben.civeira.net/2020/09/las-fases-del-ciclo-de-vida-de-maven.html)
* [Diferencia entre ciclo de vida y fases](https://blog.planview.com/project-phase-life-cycle/)
* [Plugings](https://neoattack.com/neowiki/plugin/)
* [Comandos de Mvn](https://www.digitalocean.com/community/tutorials/maven-commands-options-cheat-sheet)
* [gitignore](https://www.atlassian.com/es/git/tutorials/saving-changes/gitignore)