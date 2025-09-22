# 📚 Book CRUD Project

> A simple CRUD project for managing books (Create, Read, Update, Delete).

---

## 🔍 Overview
This project provides a RESTful API for managing books, supporting the following operations:
- Create a new book  
- Retrieve all books  
- Get details of a specific book  
- Update an existing book  
- Delete a book  

---

## ⚙️ Features
- Simple and easy-to-use REST API  
- Supports basic CRUD operations  
- Scalable for future improvements  

---

## 🧰 Requirements
- Java  
- Spring Boot  
- Maven or Gradle  
- Database (H2, MySQL, or others)  

---

## 🚀 Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/OmarMohamedElqady/Book-CRUD-Project.git
   cd Book-CRUD-Project
   ```
2. Run the project:  
   - Maven:
     ```bash
     mvn spring-boot:run
     ```
   - Gradle:
     ```bash
     ./gradlew bootRun
     ```

---

## 🔗 Endpoints

| Operation             | HTTP Method | Path              |
|-----------------------|-------------|-------------------|
| Get all books         | GET         | `/books`          |
| Get a book by ID      | GET         | `/books/{id}`     |
| Create a new book     | POST        | `/books`          |
| Update a book         | PUT         | `/books/{id}`     |
| Delete a book         | DELETE      | `/books/{id}`     |

---

## 🛠 Future Improvements
- Add input validation  
- Improve error handling  
- Add search and filtering functionality  
- Implement authentication & authorization  

---
