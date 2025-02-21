# Sử dụng OpenJDK 17
FROM openjdk:17 AS build

# Cài đặt Maven và build ứng dụng
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Chạy ứng dụng từ JAR
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/backend-hutieugo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
