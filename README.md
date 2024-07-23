# Item Management Project

# About
The Item Management API Project focuses on building a robust item management API using Spring Boot, Spring Web, and Spring Data, facilitating CRUD operations for item management. All interactions are handled via HTTP, with proper utilization of status codes and HTTP verbs for efficient communication between the client and server. Data persistence is ensured through PostgreSQL, harnessing its relational capabilities for seamless storage and retrieval of item data.

# Technologies
- Java 17
- Maven
- PostgreSQL
- Postman(for testing)

# How to Run
Clone the repository to the desired location. Uisng a database admin tool, such as DBeaver, to create a database and run the data.sql script to create the necessary tables in the database and populate the tables with provided information. Next in the applications.properties file the datasource url, username, and password will need to be changed to work with your credentials. Ensure the maven dependencies are loaded by reloading the pom.xml file and then run the ProjzeroApplication.java file and then make requests using Postman or other desired http request testing software.

