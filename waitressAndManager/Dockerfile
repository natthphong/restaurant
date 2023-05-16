FROM maven AS MAVEN_BUILD
COPY . ./
RUN mvn clean package -DskipTests


FROM openjdk:17-alpine
COPY --from=MAVEN_BUILD /target/*.jar /waitress.jar
CMD ["java", "-jar", "/waitress.jar"]