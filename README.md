# Parcial

[![Heroku](https://heroku-badge.herokuapp.com/?app=obscure-beach-96504)](https://obscure-beach-96504.herokuapp.com/)
[![Maven Central](https://img.shields.io/maven-central/v/org.apache.maven.plugins/maven-compiler-plugin/3.8.0)](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin/3.8.0)
[![Maven Central](https://img.shields.io/maven-central/v/org.apache.maven.plugins/maven-dependency-plugin/3.0.1)](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-dependency-plugin/3.0.1)

### Prerequisitos

Se requiere maven y Java version 8 como minimo.

## Diseño

Esta api con Spark permite recibir una lista y retorna la lista ordenada y la sumatoria de sus elementos.

## Running
 Para empaquetar el proyecto de Java 
 > mvn package
 
 Para correr los test
 > mvn test 
 
 Para ejecutar el Api 
 > mvn exec:java -D "com.escuelaing.arep.clientServer.HttpServer"
 
 Para generar la documentacion de Java
 > mvn javadoc:javadoc


## Desarrollado

* [Maven](https://maven.apache.org/) - Dependency Management
* [JAVA](https://www.java.com/es/download) - Framework
* [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Framework

## Versionamiento

Para ver las versiones disponible, mire [realese version](https://github.com/Arep-Nico/Parcial/releases).

## Autor

| Developer |
| :--: |
| Nicolas Cardenas |

## License

This project is under GNU General Public License - see [LICENSE](LICENSE) to more info.

## Conocimientos

* StackOverflow
* Java Doc Api