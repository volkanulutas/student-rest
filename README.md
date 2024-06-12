# Student-REST API
#### Spring REST API Example with Swagger 3 and render.com Deployment.

## Quick access and test
[https://student-rest.onrender.com/swagger-ui/index.html(https://student-rest.onrender.com/swagger-ui/index.html)

## Overview
Student-rest API is a simple RESTful service for managing students, developed using Spring framework. The API supports basic CRUD operations.

# Features
List Students: Retrieve a list of all students.
Create Student: Add a new student.
Update Student: Modify an existing student.
Get Student by ID: Retrieve a student by their unique ID.
Delete Student: Remove a student by their unique ID.

# Additional Technologies
**Swagger 3:** Integrated for API documentation.
**Lombok:** Used to reduce boilerplate code.
**Render:** Deployment platform used for deploying this application. More: https://www.render.com/

# Endpoints
## List Students
**GET /api/v1/student/**

**Description:** Fetch a list of all students.

**Response:**

```json GET students API
[
  {
    "id": 1,
    "name": "Volkan Ulutas",
    "grade": 55.0
  },
  {
    "id": 2,
    "name": "Demir Güngör",
    "grade": 75.0
  }
]
```
## Create Student
**POST /api/v1/student/**

**Description:** Create a new student.

**Request Body:**

```json POST Student Create API Request.
{
  "id": 2,
  "name": "Demir Güngör",
  "grade": 75.0
}
```

**Response:**
```json POST Student Create API Response.
{
  "id": 2,
  "name": "Demir Güngör",
  "grade": 75.0
}
```
## Update Student
**PATCH /api/v1/student/**

**Description:** Update an existing student's information.

**Request Body:**
```json PATCH Student Update API Request.
{
  "id": 2,
  "name": "Demir Güngör",
  "grade": 95.0
}
```

**Response:**
```json PATCH Student Update API Response.
{
  "id": 2,
  "name": "Demir Güngör",
  "grade": 95.0
}
```

## Get Student by ID
**GET /api/v1/student/{id}**

**Description:** Retrieve a student by their unique ID.

**Response:**
```json GET Student by id API Response.
{
  "id": 2,
  "name": "Demir Güngör",
  "grade": 95.0
}
```

## Delete Student
**DELETE /api/v1/student/{id}**

**Description:** Delete a student by their unique ID.

Response:
200 OK Message.

# Getting Started
## Prerequisites
Java 11 or higher
Maven 3.6.0 or higher
Spring Boot 2.4.0 or higher

## Installation
1. Clone the repository:
```sh
git clone https://github.com/volkanulutas/student-rest.git
cd student-rest
```

2. Build the project using Maven:

```sh
mvn clean install
```

3. Build the project using Maven:

```sh
mvn spring-boot:run
```

The application will start and be accessible at http://localhost:8080.


# Usage
You can interact with the API using tools like curl, Postman, or any HTTP client of your choice.

## Example Requests
### List Students:

```curl
curl -X GET http://localhost:8080/api/v1/student/
```

### Create Student:
```curl
curl -X POST http://localhost:8080/api/v1/student/ -H "Content-Type: application/json" -d '{"id": 1, name":"Jane Doe","grade":22.0}'
```
### Update Student:
```curl
curl -X PATCH http://localhost:8080/api/v1/student/ -H "Content-Type: application/json" -d '{"id": 1, name":"Jane Doe","grade":25.0}'
```

### Get Student by ID:

```curl
curl -X GET http://localhost:8080/api/v1/student/2
```

### Delete Student:

```curl
curl -X DELETE http://localhost:8080/api/v1/student/2
```

# Swagger API Documentation
Swagger UI is available for easy interaction and testing of the API endpoints.

After starting the application, you can access the Swagger UI at:

```curl
http://localhost:8080/swagger-ui.html
```

# Deployment
The application is deployed using onRender. For more details about the deployment process and configuration, please refer to the .Dockerfile in the repository.

You can access the live Swagger documentation and make live requests using the following URLs:

Development Environment: openapi.dev-url
Production Environment: openapi.prod-url
Example
You can check out the live deployment and make live API requests here:
```curl
https://student-rest.onrender.com/swagger-ui/index.html
```

# License
This project is licensed under the MIT License - see the LICENSE file for details.