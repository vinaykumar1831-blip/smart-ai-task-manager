# Smart AI Task Manager

## Overview
Smart AI Task Manager is a Spring Boot REST API application developed to manage tasks efficiently. The project demonstrates CRUD operations, validation, exception handling, filtering, search, pagination, sorting, and dashboard statistics.

## Technologies Used
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger/OpenAPI
- Git & GitHub

## Features
- Create Task
- View Tasks
- Update Task
- Delete Task
- Search Tasks
- Filter by Status
- Filter by Priority
- Pagination
- Sorting
- Latest Tasks API
- Dashboard Statistics API
- Validation
- Exception Handling

## API Endpoints

POST /api/tasks

GET /api/tasks

GET /api/tasks/{id}

PUT /api/tasks/{id}

DELETE /api/tasks/{id}

GET /api/tasks/status/{status}

GET /api/tasks/priority/{priority}

GET /api/tasks/search?keyword=java

GET /api/tasks/page

GET /api/tasks/page-sort

GET /api/tasks/latest

GET /api/tasks/stats

## Author
Vinay Kumar