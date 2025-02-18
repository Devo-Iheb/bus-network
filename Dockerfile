# Utilisation d'une image Java avec JDK 17
FROM eclipse-temurin:17-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR généré
COPY target/bus-network-1.0-SNAPSHOT.jar app.jar

# Exposer le port de l'application
EXPOSE 8080

# Commande pour exécuter l'application

