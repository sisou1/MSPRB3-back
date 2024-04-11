FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 6: Exécuter l'application Spring Boot à partir d'une nouvelle image pour minimiser la taille de l'image
FROM openjdk:17
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080:80
ENTRYPOINT ["java", "-jar", "app.jar"]
