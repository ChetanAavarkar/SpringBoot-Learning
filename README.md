# Student Management System – Spring Boot

A beginner-friendly RESTful Student Management System built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

This project is part of my Java and Spring Boot learning journey and focuses on understanding how a REST API communicates with a MySQL database through the Spring Data JPA architecture.

## 🚀 Features

* Add a new student
* Retrieve all students
* Retrieve a student by ID
* Update student information
* Delete a student
* RESTful API endpoints
* MySQL database integration
* Spring Data JPA for database operations
* Layered application structure

## 🛠️ Technologies Used

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Maven**
* **Eclipse IDE**
* **Git & GitHub**

## 📂 Project Structure

```text
SpringBootLearning
│
├── src/main/java
│   │
│   └── com.example.SpringBootLearning
│       │
│       ├── SpringBootLearningApplication.java
│       │
│       ├── controller
│       │   └── StudentController.java
│       │
│       ├── service
│       │   └── StudentService.java
│       │
│       ├── repository
│       │   └── StudentRepository.java
│       │
│       └── model
│           └── Student.java
│
├── src/main/resources
│   └── application.properties
│
├── pom.xml
└── README.md
```

> The package/file names may differ slightly depending on the current version of the project.

## 🏗️ Application Architecture

The project follows a layered architecture:

```text
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
Spring Data JPA / Hibernate
   │
   ▼
MySQL Database
```

### Controller

Handles HTTP requests and provides REST API endpoints.

### Service

Contains the application's business logic.

### Repository

Uses Spring Data JPA to communicate with the database.

### Entity / Model

Represents a student as a Java object and maps it to a database table.

## 🗄️ Database

The application uses **MySQL** as its relational database.

Example student table:

| Column | Description  |
| ------ | ------------ |
| `id`   | Student ID   |
| `name` | Student name |
| `city` | Student city |

## 🔗 REST API Endpoints

| Method   | Endpoint         | Description       |
| -------- | ---------------- | ----------------- |
| `POST`   | `/students`      | Add a student     |
| `GET`    | `/students`      | Get all students  |
| `GET`    | `/students/{id}` | Get student by ID |
| `PUT`    | `/students/{id}` | Update student    |
| `DELETE` | `/students/{id}` | Delete student    |

## 📌 Example Request

### Add Student

```http
POST /students
```

Request body:

```json
{
  "id": 101,
  "name": "Chetan",
  "city": "Surat"
}
```

### Get All Students

```http
GET /students
```

### Get Student by ID

```http
GET /students/101
```

### Update Student

```http
PUT /students/101
```

Request body:

```json
{
  "name": "Chetan",
  "city": "Ahmedabad"
}
```

### Delete Student

```http
DELETE /students/101
```

## ⚙️ How to Run

### 1. Clone the repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Open the project

Open the project in **Eclipse IDE** as a Maven project.

### 3. Configure MySQL

Create the required database in MySQL.

Then update `application.properties` with your local database configuration.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Do not commit your real database password to GitHub.

### 4. Run the application

Run:

```text
SpringBootLearningApplication.java
```

as a **Spring Boot App**.

The application will normally start at:

```text
http://localhost:8080
```

## 📚 What I Learned From This Project

Through this project, I am learning:

* Spring Boot project structure
* REST APIs
* Controllers
* Services
* Dependency Injection
* Entities
* Spring Data JPA
* `JpaRepository`
* CRUD operations
* MySQL integration
* Hibernate and ORM concepts
* Maven
* Debugging Spring Boot applications
* Git and GitHub

## 🔮 Future Improvements

Possible future improvements include:

* Proper exception handling
* Validation using Spring Validation
* Better HTTP status responses
* Global exception handling
* DTOs
* Pagination and sorting
* Search and filtering
* Spring Security
* Frontend integration
* Deployment

## 👨‍💻 Author

**Chetan Aavarkar**

MCA Student | Java Developer Aspirant

This project is part of my ongoing Java and Spring Boot learning journey.
