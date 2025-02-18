FROM openjdk:11
COPY target/backend-hutieugo.jar backend-hutieugo.jar
ENTRYPOINT ["java", "-jar", "/backend-hutieugo.jar"]
