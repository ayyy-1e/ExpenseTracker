# Expense Tracker Web Application

## Table of Contents

* [Overview](#overview)
* [Features](#features)
* [Technologies Used](#technologies-used)
* [Project Structure](#project-structure)
* [Database Structure](#database-structure)
* [How to Run Locally](#how-to-run-locally)
* [Deployment](#deployment)
* [References](#references)
* [AI Usage Declaration](#ai-usage-declaration)

___

## Overview

Expense Tracker is a simple web application built using Spring Boot. Users can either add or delete expenses and all the expenses display in a table with calculated total expenses.
And all data is stored in a PostgreSQL database.

## Features

* Add new expense
* Delete expense
* View all expenses
* Automatic total expense calculation
* Data persistence using PostgreSQL

## Technologies Used

* Java : The main programming languge used to implement the backend logic of the web application.
* Spring Boot : The framework used to build the web application and handle controllers, application configuration and HTTP requests.
* Spring Data JPA : Used to simplyfy database opetations through repository interface.
* Thymeleaf : Server side template engine used to generate dynamic HTML pages and display data from the backend.
* PostgreSQL : The database used to store expenses records.
* Gradle : Used to manage dependencies and run the Spring Boot application.

## Project Structure

```
expense-tracker
│
├── src/main/java/com/example/expensetracker
│   ├── controller
│   │   └── HomeController.java
│   │
│   ├── model
│   │   └── Expense.java
│   │
│   └── repository
│       └── ExpenseRepository.java
│
├── src/main/resources
│   ├── templates
│   │   └── index.html
│   │
│   └── application.properties
│
├── build.gradle
└── README.md
```

## Database Structure

The application uses PostgreSQL to store expenses.

Table: **expense**

Fields included :
* id (Primary Key)
* name
* amount

<img width="1280" height="800" alt="Database_structure" src="https://github.com/user-attachments/assets/96f52431-dd2d-4af7-9fbd-ab56458b9596" />

## How to Run Locally

1. Clone the repository

```
git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
```

2. Open the project in IntelliJ IDEA.

3. Configure PostgreSQL in `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/expense_tracker
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

4. Run the Spring Boot application.

5. Open the browser:

```
http://localhost:8080
```

## Deployment

The application is deployed using Railway.

Deployment link:

___

## References

* [Spring Boot Documentation](https://spring.io/projects/spring-boot)
* [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
* [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
* [PostgreSQL Documentation](https://www.postgresql.org/docs/)
* [Railway Deployment Guide](https://www.youtube.com/watch?v=Q_Hr4KK8tsQ&authuser=0)

## AI Usage Declaration

**AI Usage**: This project was created with guidance from AI assistants for:
* Code structure and architecture recommendations
* UI/UX layout suggestions
* Debugging errors
* Project structure and UI enhancement
* Deployment preparation and documentation formatting

**No AI Code Generation**: All code was written by human, with AI providing architectural guidance only.





