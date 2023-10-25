# FROM eclipse-temurin:17-alpine
# VOLUME /tmp
# EXPOSE 8080
# ARG JAR_FILE=target/jemguitar-0.0.1.jar
# ADD ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

FROM eclipse-temurin:17-jdk-jammy as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

FROM base as development
CMD ["./mvnw", "spring-boot:run"]

FROM base as build
RUN ./mvnw package

FROM eclipse-temurin:17-jre-jammy as production
EXPOSE 8080
COPY --from=build /app/target/jemguitar-*.jar /jemguitar.jar
CMD ["java", "-jar", "/jemguitar.jar"]