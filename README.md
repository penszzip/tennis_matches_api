# Tennis Matches Tracker API

This project is a REST API that scrapes and stores results of tennis matches from the last 24 hours. It's a comprehensive solution for tracking tennis matches, developed using Java, Spring Boot, JDBC, Selenium, and Azure SQL.

## Features

- **Web-Scraping Service**: Implemented a service that collects data from the internet using Selenium. This service is responsible for scraping the results of tennis matches from the last 24 hours.

- **Database Connection and Population**: Used JDBC to connect to an Azure SQL database. The scraped data is then populated into this database, providing a robust and reliable storage solution.

- **RESTful API Endpoints**: Developed API endpoints using Spring Boot. These endpoints make the scraped data accessible through the web. This allows for easy integration with other services or applications that might need this data.

## Technologies Used

- Java
- Spring Boot
- JDBC
- Selenium
- Azure SQL

This project is a great example of how various technologies can be combined to create a powerful and useful service. It showcases the use of web scraping to collect data, the use of a SQL database to store this data, and the development of a REST API to make this data accessible.
