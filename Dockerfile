FROM maven:3.9.0-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

COPY wait-for-mysql.sh .
RUN chmod +x wait-for-mysql.sh

EXPOSE 8081
ENTRYPOINT ["./wait-for-mysql.sh", "java", "-jar", "app.jar"]