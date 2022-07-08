FROM bellsoft/liberica-openjdk-alpine:latest
ADD /target/Tokenizer-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]