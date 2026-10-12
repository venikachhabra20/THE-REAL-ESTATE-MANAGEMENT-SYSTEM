# Online Real Estate Management System

**A Java-Based Web Application**

## Project Overview

The Online Real Estate Management System is a web-based application designed to simplify property searching and management. It provides a platform for users to explore property listings and for property managers to organize property and agent information.

## Objectives

- Provide a user-friendly property browsing interface.
- Organize property and agent information.
- Store and retrieve information using MySQL.
- Demonstrate Java, Object-Oriented Programming (OOP), and database connectivity.
- Develop a modular web application.

## Key Features

- **Home Page:** Introduction to the platform.
- **Properties:** Interface for browsing property listings.
- **Agents:** Section for displaying agent information.
- **Contact:** Contact information and inquiry interface.
- **Database:** MySQL-based data storage.
- **Java Backend:** Server-side application logic.

## Technologies Used

| Technology | Purpose |
|---|---|
| HTML5 | Web page structure |
| CSS3 | Styling and layout |
| JavaScript | Client-side interactions, where implemented |
| Java | Backend logic |
| Jakarta Servlets | Web request handling |
| JDBC | Database connectivity |
| MySQL | Database management |
| Apache Maven | Build and dependency management |
| Apache Tomcat | Web application server |
| Git and GitHub | Version control |

## Project Structure

```text
THE-REAL-ESTATE-MANAGEMENT-SYSTEM/
├── frontend/
├── src/
│   └── main/
├── real_estate.sql/
├── pom.xml
├── README.md
└── .gitignore
```

## Prerequisites

- Java JDK
- Apache Maven
- MySQL Server
- MySQL Workbench (optional)
- Compatible Apache Tomcat server
- Visual Studio Code or another Java IDE

## Installation and Setup

### 1. Clone the Repository

```bash
git clone https://github.com/venikachhabra20/THE-REAL-ESTATE-MANAGEMENT-SYSTEM.git
```

### 2. Set Up the Database

1. Open MySQL Workbench.
2. Locate the SQL file in the repository.
3. Execute the SQL script.
4. Verify the database and tables created.

### 3. Configure Database Connectivity

Update the database connection settings in the relevant Java configuration file using your local MySQL credentials. Never upload database passwords or other private credentials to GitHub.

### 4. Build the Project

Open a terminal in the directory containing `pom.xml` and run:

```bash
mvn clean package
```

Resolve any build errors before deployment.

### 5. Run the Application

If the project is configured for WAR packaging, deploy the generated WAR file to a compatible Apache Tomcat server. Start Tomcat and open the application using its configured URL.

## Database

The project uses MySQL for storing and managing real estate information. Refer to the included SQL files for the database schema and table definitions.

## Application Architecture

1. **Presentation Layer:** HTML, CSS, and frontend resources.
2. **Application Layer:** Java backend logic and servlet request handling.
3. **Data Layer:** MySQL database access through JDBC.

## Future Enhancements

- User registration and login.
- Advanced property search and filtering.
- Property booking and inquiry management.
- Administrative dashboard.
- Property image uploads.
- Improved validation and error handling.
- Responsive design enhancements.
- Additional security and testing.

## Project Team

- Venika Chhabra
- Priyanshi
- Ananya

## Academic Project

Developed as an academic project to demonstrate Java programming, web application development, database management, and software engineering concepts.

## License

This project is intended for educational and academic purposes.

---

**GitHub Repository:** [THE-REAL-ESTATE-MANAGEMENT-SYSTEM](https://github.com/venikachhabra20/THE-REAL-ESTATE-MANAGEMENT-SYSTEM)
