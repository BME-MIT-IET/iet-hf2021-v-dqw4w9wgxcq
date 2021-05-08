FROM openjdk:8
COPY cli/build/libs/*.jar /app/ontomalizer-cli.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "ontomalizer-cli.jar"]
