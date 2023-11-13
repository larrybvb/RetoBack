#COPY /target/esigna-bono-service-1.0.jar ${SERVICE_PATH}
FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY /target/cliente-service-1.0.jar app.jar
EXPOSE 9001 
ENTRYPOINT ["java", "-jar", "app.jar"]