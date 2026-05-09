# Java MySQL CRUD Application (Dockerized)

## Project Overview

This is a simple Java-based CRUD application that connects to a MySQL database.  
The application allows users to:

- Add student records
- View stored student data
- Store data in MySQL database
- Run the application using Docker

This project demonstrates:
- JDBC connectivity
- MySQL integration
- Docker containerization
- Basic database operations
- Clean project structure

---

## Technologies Used

- Java
- MySQL
- JDBC (MySQL Connector/J)
- Docker
- Git

---

## Project Structure

datareading/
│
├── StudentManagement.java
├── Dockerfile
├── mysql-connector-j-9.7.0.jar
└── README.md


---

## Features

- Menu-driven console application
- Insert student data into MySQL
- Retrieve and display stored records
- Dockerized application
- Database connection using JDBC

---

## How to Run Without Docker

### 1. Install Requirements
- Java JDK
- MySQL Server
- MySQL Connector/J

### 2. Create Database

```sql
CREATE DATABASE testdb;
USE testdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT
);

### 3. Compile
javac -cp ".;mysql-connector-j-9.7.0.jar" StudentManagement.java

### 4. Run
java -cp ".;mysql-connector-j-9.7.0.jar" StudentManagement

How to Run Using Docker
-------------------------
1. Create Docker Network
docker network create app-network

2. Run MySQL Container
docker run -d --name mysql-container --network app-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=testdb mysql:8

3. Build Java Image
docker build -t my-java-app .

4. Run Java Container
docker run -it --network app-network my-java-app

Database Configuration

Update JDBC URL in StudentManagement.java:

jdbc:mysql://mysql-container:3306/testdb

Learning Outcomes:- 
------------------
Understanding JDBC connection
Working with MySQL database
Using Docker for containerization
Managing multi-container networking
Handling common connection errors

Future Improvements:-
--------------------
Add update & delete functionality
Use Maven project structure
Add REST API using Spring Boot
Implement GUI version
Use Docker Compose for full setup


Author
Kajal Bairagi

