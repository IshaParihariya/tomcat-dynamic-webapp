CREATE DATABASE tomcatregistrationdb;

USE tomcatregistrationdb;

CREATE TABLE registrationdata (
                                  id INT AUTO_INCREMENT PRIMARY KEY,
                                  name VARCHAR(100),
                                  email VARCHAR(100),
                                  city VARCHAR(100)
);

-- Sample data (optional for testing)

-- INSERT INTO registrationdata (name, email, city)
-- VALUES
-- ('Isha', 'isha@gmail.com', 'Jaipur'),
-- ('Rahul', 'rahul@gmail.com', 'Delhi');