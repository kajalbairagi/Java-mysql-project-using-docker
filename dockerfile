FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY  StudentManagement.java .

COPY mysql-connector-j-9.7.0.jar .

RUN javac -cp ".:mysql-connector-j-9.7.0.jar" StudentManagement.java

CMD ["java", "-cp", ".:mysql-connector-j-9.7.0.jar", "StudentManagement"]
