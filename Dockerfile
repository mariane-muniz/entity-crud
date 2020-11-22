FROM maven:3.5.2-jdk-8-alpine
COPY pom.xml /maven-build/
COPY src/ /maven-build/src/
WORKDIR /maven-build/
RUN mvn clean package -q 

FROM openjdk:8-jdk
WORKDIR /root/
COPY --from=0 /maven-build/target/entity-crud-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "entity-crud-0.0.1-SNAPSHOT.jar"]