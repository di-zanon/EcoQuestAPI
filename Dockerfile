FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src src
RUN mvn clean package -DskipTests -B

FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia o arquivo .war gerado para a imagem final
COPY --from=build /app/target/*.war app.war

EXPOSE 8080

CMD ["java", "-jar", "app.war"]