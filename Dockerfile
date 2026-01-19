# Use an official JDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the executable jar file from your target folder to the container
# Note: Ensure you run 'mvn clean package' first to generate this file
COPY target/*.jar app.jar

# Run the web service on container startup
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]