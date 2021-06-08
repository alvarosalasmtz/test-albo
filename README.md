# Examen Albo
> Por: Alvaro Salas
> [Linkedin](https://www.linkedin.com/in/alvarosalasmtz/)
> [GitHub](https://github.com/alvarosalasmtz)

## Tecnologías en el Microservicio test-albo:

- Maven 3.8.1
- Java 8
- Spring Boot 2.5.0
- Kotlin 1.5.10
- Spring Cloud 2020.0.3
- MongoDB Community 4.4.6

## Features:
> Nota: Por carga de trabajo el proyecto se realizo en pocas horas

- Mejor manejo de Excepciones
- Pruebas unitarias y uso de TDD
- Deploy con Docker
- Uso de hystrix para el consumo de api cuando falle
- Analisis de codigo y cobertura Sonar

## Ejecucion:
> Nota: La ejecución se realizo en SO Ubuntu 21.04
1. Se requiere de la Base de Datos: MongoDB
   [Install MongoDB en Ubuntu](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/)
2. Asegurar de tener configurado Java
   Ejemplo:
```sh
echo $JAVA_HOME
/usr/lib/jvm/java-8-openjdk-amd64/
```
3. Agregar el subdomio **test.albo.mx** al file: **/etc/hosts**
   Ejemplo:
```txt
127.0.0.1	localhost
127.0.1.1	test.albo.mx

# The following lines are desirable for IPv6 capable hosts
::1     ip6-localhost ip6-loopback
fe00::0 ip6-localnet
ff00::0 ip6-mcastprefix
ff02::1 ip6-allnodes
ff02::2 ip6-allrouters
```
4. Dar permisos y ejecutar assemble.sh para empaquetar el proyecto
> Nota: El archivo **assemble.sh** se encuentra en la raíz del proyecto
```sh
chmod +x assemble.sh
./assemble.sh
```
5. Dar permisos y ejecutar assemble.sh para ejecutar el proyecto
> Nota: El archivo **avengers.sh** se encuentra en la raíz del proyecto y pedirá permisos de admin
```sh
chmod +x avengers.sh
./avengers.sh
```
> Al ejecutar **avengers.sh** abrirá automáticamente la URL de Swagger en el explorador

