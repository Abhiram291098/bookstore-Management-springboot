# 1. Start with Java 17 image
FROM openjdk:17-jdk-slim

# 2. Create folder in the container
WORKDIR /app

# 3. Copy your JAR file to that folder
COPY build/libs/*.jar app.jar

# 4. Run the JAR file when container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
