# Full Stack Application - Backend (Spring Boot)

## Overview
This is the backend of a Full Stack web application developed using **Spring Boot**. It provides RESTful APIs for the front-end, handles authentication, and interacts with the database.

## Features
- **User Authentication & Authorization**
- **CRUD Operations with a Database**
- **RESTful API Development**
- **Secure backend using Spring Security**
- **Data Persistence using JPA & Hibernate**
- **Build and Dependency Management using Maven**

## Technologies Used
- **Spring Boot**
- **Spring Security** (for authentication & authorization)
- **Spring Data JPA** (for database interactions)
- **Hibernate** (ORM framework)
- **MySQL / PostgreSQL** (Database)
- **Maven** (for dependency management)
- **IntelliJ IDEA / Eclipse** (Development Environment)

## Setup Instructions
### Clone the Repository
```bash
git clone https://github.com/hamza97benroummane/Spring_boot_Ecommerce_App.git
cd Spring_boot_Ecommerce_App
```

### Configure the Database
Edit the `application.properties` file:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Build and Run the Application
```bash
mvn spring-boot:run
```
The server will start at:
```
http://localhost:8080
```

## Contributing
If you’d like to contribute to this project:
- Fork the repository
- Create a new branch (`feature-branch`)
- Commit your changes
- Push to the branch and submit a pull request

### **🌎 Author**

- **Developed by** Hamza BEN ROUMMANE
- **GitHub:** https://github.com/hamza97benroummane

