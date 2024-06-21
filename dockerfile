# Etape de build et de tests
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean test  # Exécute les tests JUnit avec Maven

RUN mvn clean package -DskipTests

# Etape de runtime
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
