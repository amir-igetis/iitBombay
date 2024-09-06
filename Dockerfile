# Stage 1: Build the application using Maven
FROM maven:3.8.3-openjdk-17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and package the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final image with OpenJDK
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=builder /app/target/playlist-0.0.1-SNAPSHOT.jar ./app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]

# Expose the port the application runs on
EXPOSE 8080


# FROM maven:3.8.3-openjdk-17 AS builder
# COPY . /app
# WORKDIR /app
# RUN mvn clean package
#
# FROM openjdk:17-jdk-slim
# WORKDIR /app
# COPY --from=builder /app/target/  .
# CMD ["java", "-jar","playlist-0.0.1-SNAPSHOT.jar"]


