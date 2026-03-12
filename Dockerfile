# Builder stage: use Gradle image with JDK 21 to produce the Spring Boot jar
FROM gradle:9.3-jdk21 AS builder
WORKDIR /app
COPY --chown=gradle:gradle . .
RUN gradle clean bootJar --no-daemon --no-build-cache

# Runtime stage: minimal JRE image
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
