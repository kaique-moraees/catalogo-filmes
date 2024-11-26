# Usar uma imagem base do OpenJDK para runtime
FROM openjdk:17-jdk-slim AS runtime

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR gerado pela aplicação Spring Boot para o contêiner
# Certifique-se de substituir o nome do arquivo JAR pelo correto após build
COPY target/catalogo-filmes-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta 8080, onde a aplicação Spring Boot será executada
EXPOSE 8080

# Comando para executar o JAR ao iniciar o contêiner
ENTRYPOINT ["java", "-jar", "app.jar"]
