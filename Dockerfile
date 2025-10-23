# =========================
# Stage 1: Build the app
# =========================
FROM maven:3.9.9-amazoncorretto-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Run the app
# =========================
FROM amazoncorretto:17

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Copy wait script inside the container
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Expose port
EXPOSE 8080

# Wait for DB to be ready, then start Spring Boot
ENTRYPOINT ["/wait-for-it.sh", "db:5432", "--", "java", "-Xmx2048M", "-jar", "/app/app.jar"]


