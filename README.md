# Tomcat Dynamic Web Registration App

A Java Dynamic Web Application that allows users to register through a form and stores the data in a MySQL database.
The project demonstrates the use of **Java Servlets, JDBC, and Apache Tomcat** to build a simple backend-driven web application.

## Features

* User registration form
* Form data handled using Java Servlet
* Data stored in MySQL database using JDBC
* HTML and CSS used for frontend
* Deployable on Apache Tomcat

## Tech Stack

* Java
* Servlet
* JDBC
* MySQL
* HTML
* CSS
* Apache Tomcat

## Project Structure

tomcat-dynamic-webapp
│
├── src
│   └── servlet classes
│
├── web
│   ├── registration.html
│   ├── style.css
│   └── WEB-INF
│       └── web.xml

## Database

MySQL is used to store the registration data.

Example table structure:

CREATE TABLE registrationdata (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
email VARCHAR(100),
city VARCHAR(100)
);

## How to Run

1. Clone the repository
2. Configure MySQL database
3. Update JDBC connection details in the servlet
4. Deploy the project on Apache Tomcat
5. Open the registration page in the browser and submit the form
