# Estágio 1: Construção usando a imagem oficial do Maven (Evita erros de permissão do Windows)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
# Agora usamos o comando 'mvn' direto em vez do './mvnw'
RUN mvn clean package -DskipTests

# Estágio 2: Execução do projeto
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]