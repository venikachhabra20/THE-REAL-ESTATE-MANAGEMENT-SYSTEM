\# Real Estate Management System



A Java-based web application project for managing real estate properties and displaying property information.



\## Technologies Used

\- Java

\- HTML and CSS

\- MySQL

\- JDBC

\- Jakarta Servlets

\- Apache Maven

\- Apache Tomcat



\## Project Features

\- Property listing webpage

\- Properties, agents, and contact pages

\- Java servlet-based web application

\- MySQL database connectivity

\- Properties API for retrieving property data



\## Requirements

\- JDK 17 or later

\- MySQL Server

\- Apache Maven

\- Apache Tomcat 10

\- A database named `real\_estate\_systemdb`



\## Database Setup

1\. Open MySQL Workbench.

2\. Open `real\_estate.sql/real\_estate.sql`.

3\. Execute the SQL script to create the database tables.

4\. Configure the database credentials using the `DB\_USERNAME` and `DB\_PASSWORD` environment variables.



\## Build the Project

From the project root directory, run:



```bash

mvn clean package

```



The WAR file will be generated at `target/real-estate.war`.



\## Run the Application

Deploy the WAR file to Apache Tomcat 10 and start the server.



Example local URLs:

\- `http://localhost:8080/real-estate/properties.html`

\- `http://localhost:8080/real-estate/api/properties`

\- `http://localhost:8080/real-estate/test-db`



Database credentials should be configured locally and must not be committed to GitHub.



\## Team

\- Venika Chhabra

\- Priyanshi

\- Ananya Roy



\## Project Purpose

This project demonstrates the use of Java web technologies, database connectivity, and a simple interface for viewing real estate information.



