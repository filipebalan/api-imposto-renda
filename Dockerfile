# Estágio 1: Construção do projeto (Build)
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
# Transforma o código em um pacote executável (.jar)
RUN ./mvnw clean package -DskipTests

# Estágio 2: Execução do projeto (Run)
FROM eclipse-temurin:21-jre
WORKDIR /app
# Pega o arquivo pronto do estágio 1 e joga no servidor
COPY --from=build /app/target/*.jar app.jar
# Libera a porta 8080 para a internet
EXPOSE 8080
# O comando de "Play" do servidor
ENTRYPOINT ["java", "-jar", "app.jar"]