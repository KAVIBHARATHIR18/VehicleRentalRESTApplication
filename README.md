# Vehicle Rental REST Application

A query-based Vehicle Rental REST Application developed using **Spring Boot, MySQL, HTML, CSS, JavaScript, and Docker**.

The application demonstrates how SQL queries such as **JOIN, Subquery, ANY, and ALL** can be integrated with a Spring Boot REST API and displayed through a web frontend.

## Features

* Vehicle management
* Customer management
* Rental management
* Payment management
* Vehicle and branch JOIN queries
* Rental, customer, and vehicle JOIN queries
* Payment and rental JOIN queries
* Subquery to find vehicles above average rent
* Subquery to find the most expensive vehicle
* `ANY` query for vehicle rent comparison
* `ALL` query for vehicle rent comparison
* MySQL triggers for rental and payment summary
* REST APIs using Spring Boot
* HTML, CSS, and JavaScript frontend
* Dockerized application
* Docker Hub deployment

## Technologies Used

| Technology      | Purpose                |
| --------------- | ---------------------- |
| Java 17         | Backend programming    |
| Spring Boot     | REST API development   |
| Spring Data JPA | Database interaction   |
| MySQL           | Database               |
| HTML            | Frontend structure     |
| CSS             | Frontend styling       |
| JavaScript      | Frontend interaction   |
| Maven           | Project build          |
| Postman         | API testing            |
| Docker          | Containerization       |
| Git & GitHub    | Source code management |

## Project Architecture

```text
Frontend
HTML + CSS + JavaScript
        |
        v
Spring Boot REST API
        |
        v
Controller
        |
        v
Service
        |
        v
Repository
        |
        v
MySQL Database
```

## Database Structure

The application uses the following tables:

```text
Branch
   |
   | branch_id
   |
Vehicle
   |
   | vehicle_id
   |
Rental
   |
   | rental_id
   |
Payment

Customer
   |
   | customer_id
   |
Rental
```

### Main Tables

* `branch`
* `vehicle`
* `customer`
* `rental`
* `payment`
* `rental_summary`

## SQL Concepts Demonstrated

### 1. JOIN

Vehicle details are combined with branch information.

```sql
SELECT
    v.vehicle_id,
    v.vehicle_number,
    v.vehicle_type,
    v.rent_per_day,
    b.branch_name,
    b.city
FROM vehicle v
JOIN branch b
ON v.branch_id = b.branch_id;
```

### 2. Subquery

Find vehicles whose rent is greater than the average rent:

```sql
SELECT *
FROM vehicle
WHERE rent_per_day > (
    SELECT AVG(rent_per_day)
    FROM vehicle
);
```

### 3. ANY

Find vehicles whose rent is greater than at least one bike's rent:

```sql
SELECT *
FROM vehicle
WHERE rent_per_day > ANY (
    SELECT rent_per_day
    FROM vehicle
    WHERE vehicle_type = 'Bike'
);
```

### 4. ALL

Find vehicles whose rent is greater than every bike's rent:

```sql
SELECT *
FROM vehicle
WHERE rent_per_day > ALL (
    SELECT rent_per_day
    FROM vehicle
    WHERE vehicle_type = 'Bike'
);
```

## REST API Endpoints

### Vehicles

```text
GET /api/vehicles
GET /api/vehicles/with-branch
GET /api/vehicles/above-average-rent
GET /api/vehicles/most-expensive
GET /api/vehicles/greater-than-any-bike
GET /api/vehicles/greater-than-all-bikes
```

### Customers

```text
GET /api/customers
```

### Branches

```text
GET /api/branches
```

### Rentals

```text
GET  /api/rentals
POST /api/rentals
GET  /api/rentals/with-customer-vehicle
```

### Payments

```text
GET /api/payments
GET /api/payments/with-rental
```

### Summary

```text
GET /api/summary
```

## Trigger-Based Summary

The application uses MySQL triggers to automatically maintain the rental summary.

When a new rental is inserted:

```text
Total Rentals → +1
```

When a new payment is inserted:

```text
Total Payment → +Payment Amount
```

The summary can be accessed through:

```text
GET /api/summary
```

## Frontend

The frontend is built using:

* HTML
* CSS
* JavaScript
* Fetch API

The frontend communicates with the Spring Boot REST APIs and displays vehicle, rental, payment, and summary information.

## Running the Application Locally

### 1. Clone the repository

```bash
git clone https://github.com/KAVIBHARATHIR18/VehicleRentalRESTApplication.git
```

### 2. Open the project

Open the project in **Eclipse** or another Java IDE.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE vehicle_rental;
```

Create the required tables and insert the required data.

### 4. Configure Database Connection

Set the MySQL username and password using environment variables.

Example:

```properties
spring.datasource.username=root
spring.datasource.password=${MYSQL_PASSWORD}
```

### 5. Run the application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8081
```

## Running with Docker

Build the Docker image:

```bash
docker build -t vehicle-rental-app .
```

Run the container:

```bash
docker run --name vehicle-rental-container -p 8081:8081 -e MYSQL_PASSWORD="your_password" vehicle-rental-app
```

Open:

```text
http://localhost:8081
```

## Docker Hub

Docker image:

```text
kavibharathi2007/vehicle-rental-app
```

The Docker image contains the Spring Boot application and can be used to run the application inside a Docker container.

## Testing

REST APIs were tested using **Postman**.

The frontend was tested through the browser using:

```text
http://localhost:8081
```

## Project Structure

```text
VehicleRentalRESTApplication
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.vehicle.vehicle_rental
│   │   │       ├── controller
│   │   │       ├── entity
│   │   │       ├── repository
│   │   │       └── service
│   │   │
│   │   └── resources
│   │       ├── static
│   │       │   ├── index.html
│   │       │   ├── script.js
│   │       │   └── style.css
│   │       └── application.properties
│
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Author

**Kavibharathi R**

B.Tech Information Technology

## License

This project is created for educational and academic purposes.
