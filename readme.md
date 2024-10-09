# BanCodo 

BanCodo es un proyecto de simulación de cajero automático por consola desarrollado en Java como TP final del curso "Programación Inicial con Java" de Codo a Codo.

Las consignas eran las siguientes:

![Screenshoot de consignas](./images/consignas.png)

Agregué que no estaba en el curso, el uso de una interfaz, y clase abstracta, ya que no vimos POO.

También los "modelos" en realidad no lo son, y la implementación no sería correcta, los hice así para organizar los archivos, pero como no tuvimos persistencia de datos hasta la ultima clase, lo que hacíamos era mantener la info en memoria con variables estáticas, al final solo persistimos los datos de login pero por archivos .dat, entonces, para no cambiar tanto la forma en que venia el curso, solo cree la clase FileManager para manejar mejor los archivos, y la clase usuario en sus variables estáticas lee estos archivos. Sé que no es lo mejor, pero me pareció lo apropiado para la forma en que se vió en el curso.

## Herramientas utilizadas:

* IDE: Visual Studio Code
* Extenciones:
-   Extension pack For Java
-   Java Imports Snippets
-   Language Support for Java(TM) by Red Hat

### Requisitos:

* JDK 23
* Maven : Este lo instalé por "separado" basandome en este video: https://www.youtube.com/watch?v=rl5-yyrmp-0


## Ejecución

Se puede ejecutar en VSC teniendo la jdk instaladas y el plugin de Extension pack for java, dandole al boton Play.

Sino, teniendo también java, se puede ejecutar con:
```bash
java src/main/java/com/bancodo/Main.java
```


### Compilar con Maven


```bash
mvn package
```

Ejecutarlo:

```bash
java -jar <Ruta al archivo .jar distribuible>
```
