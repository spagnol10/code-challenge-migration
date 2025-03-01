FROM openjdk:17-jdk-alpine

COPY target/dummyjson-client-1.0-SNAPSHOT.jar /app/dummyjson-client-1.0-SNAPSHOT.jar

CMD ["java", "-jar", "/app/dummyjson-client-1.0-SNAPSHOT.jar"]

# Comando para rodar o dockerfile
# MAC -> docker build --platform linux/amd64 -t ibm .
# WINDOWNS -> docker build --platform linux/amd64 -t ibm .
