# 1. Etapa de construire (Build Stage)
FROM maven:3.8.4-openjdk-17 AS builder

# Setează directorul de lucru pentru build
WORKDIR /app

# Copiază fișierul pom.xml pentru a descărca dependențele (optimizare cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiază codul sursă al proiectului
COPY src ./src

# Compilează și împachetează aplicația (sare peste teste pentru rapiditate)
RUN mvn clean package -DskipTests

# 2. Etapa de rulare (Run Stage) - pentru o imagine finală mai ușoară
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copiază artifactul generat (.jar) din etapa de build
# Notă: Înlocuiește 'nume-aplicatie.jar' cu numele real generat de proiectul tău
COPY --from=builder /app/target/*.jar app.jar

# Expune portul implicit pe care rulează de obicei aplicațiile Java (ex: Spring Boot)
EXPOSE 8080

# Comanda de pornire a aplicației
ENTRYPOINT ["java", "-jar", "app.jar"]