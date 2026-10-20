# Spring Boot CRUD Application with Oracle Database and Postman Testing

A simple and practical Spring Boot REST API project that demonstrates CRUD (Create, Read, Update, Delete) operations using Oracle Database. This project focuses on backend development, REST API design, database integration, and API testing using Postman.

## Project Overview

This project demonstrates how to build a backend application using Spring Boot and connect it to an Oracle Database. It follows a layered architecture to separate API handling, business logic, and database operations.

The application provides REST APIs to manage student records and supports operations such as creating students, retrieving student information, updating records, and deleting records.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Oracle Database
- Maven
- Postman
- Eclipse IDE

## Features

- Create a new student record
- Retrieve all student records
- Retrieve a student by ID
- Update existing student details
- Delete student records
- Soft delete functionality
- RESTful API development
- Oracle Database integration
- API testing using Postman
- Layered architecture with Controller, Service, and Repository

## Project Architecture

The project follows a layered architecture:

```text
Client (Postman)
      |
      v
Controller Layer
      |
      v
Service Layer
      |
      v
Repository Layer
      |
      v
Oracle Database
```

### Layers

- **Controller:** Handles HTTP requests and returns API responses.
- **Service:** Contains business logic and validation.
- **Repository:** Performs database operations using Spring Data JPA.
- **Entity:** Represents the student table in the database.

## Database Configuration

This project uses Oracle Database to store student information.

Configure your database connection in `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
spring.datasource.username=hr
spring.datasource.password=pass
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect

server.port=8081
```

Replace the database username, password, and connection URL with your actual Oracle Database configuration.

## API Endpoints

The following are example endpoints for the student CRUD application. Adjust the paths according to your actual controller mappings.

| Operation | HTTP Method | Example Endpoint |
|---|---|---|
| Create student | POST | `/api/student` |
| Get all students | GET | `/api/student` |
| Get student by ID | GET | `/api/student/{id}` |
| Update student | PUT | `/api/student/{id}` |
| Delete student | DELETE | `/api/student/{id}` |
| Soft delete student | PUT | `/api/student/delete-soft?id={id}` |

## Testing with Postman

The APIs can be tested using Postman.

### 1. Create Student

**Method:** POST

```text
http://localhost:8081/api/student
```

Example JSON request body:

```json
{
  "name": "Rahul",
  "email": "rahul@example.com"
}
```

### 2. Get All Students

**Method:** GET

```text
http://localhost:8081/api/student
```

### 3. Get Student by ID

**Method:** GET

```text
http://localhost:8081/api/student/1
```

### 4. Update Student

**Method:** PUT

```text
http://localhost:8081/api/student/1
```

Example JSON request body:

```json
{
  "name": "Rahul Patil",
  "email": "rahul.patil@example.com"
}
```

### 5. Soft Delete Student

**Method:** PUT

```text
http://localhost:8081/api/student/delete-soft?id=1
```

Soft delete marks a record as deleted instead of physically removing it from the database. The record can remain available for auditing or recovery, depending on the application's implementation.

## How to Run the Project

1. Clone the repository:

   ```bash
   git clone YOUR_GITHUB_REPOSITORY_URL
   ```

2. Open the project in Eclipse IDE or another Java IDE.

3. Configure Oracle Database and update `application.properties`.

4. Install the Maven dependencies.

5. Run the Spring Boot application.

6. Open Postman and test the API endpoints.

## Learning Objectives

This project helped me understand:

- Spring Boot application development
- REST API design and HTTP methods
- Controller, Service, and Repository layers
- Dependency Injection
- Spring Data JPA
- Oracle database connectivity
- CRUD operations and soft delete
- API testing using Postman

## Future Improvements

- Add validation using Jakarta Bean Validation
- Implement global exception handling
- Add pagination and sorting
- Implement Spring Security and authentication
- Add automated tests using JUnit and Mockito
- Improve API documentation using Swagger/OpenAPI

## Author

**Aniruddha Kanade**

Aspiring Java Developer | Java | Spring Boot | Hibernate | Oracle Database | REST APIs
