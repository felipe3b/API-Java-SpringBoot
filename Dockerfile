## Spring boot: Docker best practices - https://medium.com/@rohitloke/spring-boot-docker-best-practices-4bf4fdec158

# Base image 
FROM eclipse-temurin:17-jdk-jammy as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

# First stage: build the application
FROM base as build
RUN ./mvnw clean package install -DskipTests

# Second stage: extract layers
FROM eclipse-temurin:17-jre-alpine as layers
WORKDIR /layer
COPY --from=build /app/target/jemguitar-*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

# Final stage: create the production image
FROM eclipse-temurin:17-jre-alpine as production
WORKDIR /opt/app
RUN addgroup --system appuser && adduser -S -s /usr/sbin/nologin -G appuser appuser
ARG JAVA_OPTS
ENV JAVA_OPTS=${JAVA_OPTS}
EXPOSE 8080
COPY --from=layers /layer/dependencies/ ./
COPY --from=layers /layer/spring-boot-loader/ ./
COPY --from=layers /layer/snapshot-dependencies/ ./
COPY --from=layers /layer/application/ ./
RUN chown -R appuser:appuser /opt/app
USER appuser
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS org.springframework.boot.loader.JarLauncher"]

# COPY --from=build /app/target/jemguitar-*.jar /jemguitar.jar
# ENTRYPOINT ["java", "-jar", "/jemguitar.jar"]
# ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /jemguitar.jar"]
