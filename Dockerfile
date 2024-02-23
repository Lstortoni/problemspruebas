FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/problem-service-0.0.1.jar
COPY ${JAR_FILE} app_problem.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app_problem.jar"]