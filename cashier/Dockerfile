FROM --platform=linux/amd64 maven AS MAVEN_BUILD

COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests


FROM --platform=linux/amd64 openjdk:17-alpine
COPY --from=MAVEN_BUILD /target/*.jar /waitress.jar
CMD ["java", "-jar", "/waitress.jar"]