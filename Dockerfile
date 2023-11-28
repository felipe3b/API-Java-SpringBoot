FROM eclipse-temurin:17-jdk-jammy as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

# FROM base as development
# CMD ["./mvnw", "spring-boot:run"]

FROM base as build
RUN ./mvnw clean package install -DskipTests

FROM eclipse-temurin:17-jre-jammy as production
ARG JAVA_OPTS
ENV JAVA_OPTS=${JAVA_OPTS}
EXPOSE 8080
COPY --from=build /app/target/jemguitar-*.jar /jemguitar.jar
# ENTRYPOINT ["java", "-jar", "/jemguitar.jar"]
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /jemguitar.jar"]