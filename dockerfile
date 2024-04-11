# Étape 1: Utiliser une image de base officielle Java (OpenJDK)
FROM openjdk:17-jdk as build

# Étape 2: Définir le répertoire de travail dans l'image
WORKDIR /app

# Étape 3: Copier le fichier pom.xml et télécharger les dépendances (pour améliorer la mise en cache des couches Docker)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Étape 4: Copier le reste du projet
COPY src src

# Étape 5: Construire l'application (création du fichier JAR)
RUN ./mvnw package -DskipTests

# Étape 6: Exécuter l'application Spring Boot à partir d'une nouvelle image pour minimiser la taille de l'image
FROM openjdk:17
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080:80
ENTRYPOINT ["java", "-jar", "/app.jar"]
