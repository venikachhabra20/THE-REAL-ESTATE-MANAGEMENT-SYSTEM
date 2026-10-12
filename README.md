# Online Real Estate Management System

A Java-based web application designed to simplify property management and help users explore real estate listings through a clean, user-friendly interface.

## Project Overview

The Online Real Estate Management System provides a central platform for displaying property information and organizing real estate-related details. It combines a web interface with Java technologies and a MySQL database.

## Key Features

- **Home Page:** Introduction to the real estate platform.
- **Property Listings:** Browse and view available property information.
- **Agent Directory:** View real estate agent details.
- **Contact Page:** Access contact information.
- **Login and Registration Interfaces:** Pages for user sign-in and account registration.
- **Database Integration:** MySQL database support for storing and managing project data.
- **Java Backend:** Uses Java web technologies and Jakarta Servlets.

*Note: Features requiring backend authentication or database operations depend on the relevant code and database configuration being implemented and tested.*

## Technologies Used

| Technology | Purpose |
|---|---|
| Java (JDK 17+) | Backend development |
| HTML5 | Web page structure |
| CSS3 | Styling and layout |
| MySQL | Database management |
| JDBC | Java–database connectivity |
| Jakarta Servlets | Server-side request handling |
| Apache Maven | Project build and dependency management |
| Apache Tomcat 10 | Web application server |

## Project Structure

```text
THE-REAL-ESTATE-MANAGEMENT-SYSTEM/
├── frontend/
├── real_estate.sql/
│   └── real_estate.sql
├── src/
│   └── main/
│       ├── java/
│       └── webapp/
├── pom.xml
└── README.md
```

The exact files inside `src/main/` may vary according to the current project version.

## Requirements

Before running the project, install:

- JDK 17 or later
- MySQL Server and MySQL Workbench
- Apache Maven
- Apache Tomcat 10.1 or another compatible Tomcat 10 release

## Database Setup

1. Start MySQL Server and open MySQL Workbench.
2. Open the SQL script at `real_estate.sql/real_estate.sql`.
3. Execute the script to create the database and its tables.
4. Configure the database connection settings for your local environment.
5. Ensure the database name, username, password, host, and port match your configuration.

**Security:** Never commit database passwords, API keys, or other private credentials to GitHub.

## Build the Project

Open a terminal in the project root directory and run:

```bash
mvn clean package
```

After a successful build, the WAR file should be generated at:

```text
target/real-estate.war
```

## Run the Application

1. Build the project using Maven.
2. Deploy `target/real-estate.war` to a compatible Apache Tomcat 10 server.
3. Start Tomcat.
4. Open the application in your browser.

Example local URLs:

- Home page: `http://localhost:8080/real-estate/`
- Properties page: `http://localhost:8080/real-estate/properties.html`
- Properties API: `http://localhost:8080/real-estate/api/properties`
- Database test endpoint: `http://localhost:8080/real-estate/test-db`

These endpoints work only if the corresponding pages, servlets, and database configuration are present and running correctly.

## Project Objectives

- Organize real estate property information in one place.
- Provide a simple interface for exploring property listings.
- Demonstrate Java web application development.
- Apply database concepts using MySQL and JDBC.
- Practice modular project organization and web application deployment.

## Team Members

- Venika Chhabra
- Priyanshi
- Ananya Roy

## Repository

GitHub: https://github.com/venikachhabra20/THE-REAL-ESTATE-MANAGEMENT-SYSTEM

## Conclusion

The Online Real Estate Management System is an academic project demonstrating the use of Java web technologies, a web-based user interface, and relational database concepts in a real estate application.
