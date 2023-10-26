# Parcial-02-AREP

### Instalación

1. Clonar el repositorio

```
git clone https://github.com/SantiagoBayona/Parcial-02-AREP
```

2. Dentro del directorio del proyecto lo construimos e instalamos

```
mvn package
```

```
mvn clean install
```

## Ejecución

### En local

1. Corremos el servidor

```
java -cp "target/classes;target/dependency/*" org.example.SparkWebServer
```

```
java -cp "target/classes;target/dependency/*" org.example.Proxy
```

### En la instancia ec2

A través de sftp subimos a la instancia las clases y las dependencias

![img1](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/d02c562d-c316-41e6-acb6-4ebb95582564)

Y las descomprimimos

![img2](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/8bcd8eb9-829f-4e4d-ad2f-d4766cbebdb8)

Ejecutamos las clases con los comandos

```
java -cp "./bin/classes:./bin/dependency/*" org.example.SparkWebServer
```

```
java -cp "./bin/classes:./bin/dependency/*" org.example.Proxy
```

## Pruebas

### En local

Al ingresar a la dirección

```
https://localhost:4568/
```

Vemos que el recurso solicitado es mostrado y funcional

![image](https://github.com/SantiagoBayona/Parcial-02-AREP/assets/64861204/90376064-07dd-4ace-bba1-564298b088f5)

Nota: Dado que el proyecto se construyó para ser corrido remotamente este no funciona en local

![image](https://github.com/SantiagoBayona/Parcial-02-AREP/assets/64861204/e6589c7a-d412-4e44-80e2-b7ebc48bc323)

### En remoto

Al ingresar a la dirección

```
http://ec2-3-85-96-149.compute-1.amazonaws.com:4568/
```

Vemos que el recurso carga

![image](https://github.com/SantiagoBayona/Parcial-02-AREP/assets/64861204/3f9c3eb5-13a4-43e3-ac48-e7839c8ef397)

## Clase que resuelve el problema 

![image](https://github.com/SantiagoBayona/Parcial-02-AREP/assets/64861204/371c47f0-07e7-4caf-a3b9-36c81db543d6)




