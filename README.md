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
java -cp "target/classes;target/dependency/*" org.example.HelloWorld
```

```
java -cp "target/classes;target/dependency/*" org.example.LoggedIn
```

### En la instancia ec2

A través de sftp subimos a la instancia las clases y las dependencias

![img1](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/d02c562d-c316-41e6-acb6-4ebb95582564)

Y las descomprimimos

![img2](https://github.com/SantiagoBayona/AREP-Lab-07/assets/64861204/8bcd8eb9-829f-4e4d-ad2f-d4766cbebdb8)

Ejecutamos las clases con los comandos

```
java -cp "./bin/classes:./bin/dependency/*" org.example.LoggedIn
```

```
java -cp "./bin/classes:./bin/dependency/*" org.example.HelloWorld
```
