FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /build
COPY spring-war/ .
RUN mvn clean package -DskipTests

FROM tomcat:10.1-jre17-temurin-jammy

COPY --from=build /build/target/spring-form.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]