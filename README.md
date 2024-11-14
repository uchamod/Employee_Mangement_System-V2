# Employee Management System

A full-stack Employee Management System built with Spring Boot backend and React frontend, providing comprehensive employee data management capabilities with a modern, responsive user interface.

## System Architecture

```
┌─────────────┐     ┌──────────────┐     ┌──────────────┐
│             │     │  Spring Boot │     │    MySQL     │
│  Frontend   │────▶│   Backend    │────▶│   Database   │
│             │     │              │     │              │
└─────────────┘     └──────────────┘     └──────────────┘
```

## Technology Stack

### Backend
- Spring Boot 3.x
- Spring Security with JWT
- Spring Data JPA
- MySQL 8.x
- Maven
- Java 17

### Frontend
- HTML
- JavaScript
- Ajax
- Boostrap

## Features

- User Authentication & Authorization
- Employee CRUD Operations
- Profile Management
- Report Generation
- Responsive Design
- Role-based Access Control
- Search and Filter Capabilities

## Prerequisites

- JDK 17 or higher
- Node.js 18.x or higher
- MySQL 8.x
- Maven 3.6+
- npm or yarn

## Getting Started

### Backend Setup

1. **Clone the Repository**
```bash
git clone https://github.com/uchamod/Employee_Mangement_System-V2.git
cd employee-management/backend
```

2. **Configure Database**
```sql
CREATE DATABASE emp_management;
```

3. **Update application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/emp_management
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Configuration
jwt.secret=your_jwt_secret
jwt.expiration=86400000
```

4. **Run the Backend**
```bash
mvn spring-boot:run
```

### Frontend Setup

 **Navigate to Frontend Directory**
```bash
cd ../frontend
```

## API Documentation

### Authentication Endpoints
```
POST /api/auth/login - Login
POST /api/auth/register - Register new user
POST /api/auth/refresh - Refresh token
```

### Employee Endpoints
```
GET /api/employees - Get all employees
POST /api/employees - Create employee
GET /api/employees/{id} - Get employee by ID
PUT /api/employees/{id} - Update employee
DELETE /api/employees/{id} - Delete employee
```

### Department Endpoints
```
GET /api/departments - Get all departments
POST /api/departments - Create department
GET /api/departments/{id} - Get department
PUT /api/departments/{id} - Update department
DELETE /api/departments/{id} - Delete department
```

```

## Security

The application implements the following security measures:

- JWT-based authentication
- Password encryption using BCrypt
- Role-based authorization
- CORS configuration
- XSS protection
- CSRF protection

## Available Scripts

### Backend
```bash
mvn clean install - Build the project
mvn test - Run tests
mvn spring-boot:run - Run the application
```

```

## Docker Support

Build and run using Docker:

```bash
# Build images
docker-compose build

# Run services
docker-compose up
```

## Testing

### Backend Testing
```bash
# Run unit tests
mvn test

# Run integration tests
mvn verify
```

## Deployment

### Backend Deployment
1. Build the JAR file:
```bash
mvn clean package
```

2. Run the JAR:
```bash
java -jar target/employee-management-0.0.1-SNAPSHOT.jar
```

2. Serve using nginx or other web server

## Troubleshooting

Common issues and solutions:

1. **Database Connection Issues**
   - Verify MySQL service is running
   - Check database credentials
   - Confirm database exists

2. **Frontend API Connection Issues**
   - Verify backend is running
   - Check CORS configuration
   - Confirm API URL in environment variables

3. **Authentication Issues**
   - Check JWT token expiration
   - Verify credentials
   - Clear browser cache/cookies

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Push to the branch
5. Create Pull Request

## Development Guidelines

1. **Code Style**
   - Follow Java code conventions
   - Use ESLint for JavaScript
   - Write meaningful commit messages

2. **Testing**
   - Write unit tests for new features
   - Maintain minimum 80% code coverage
   - Include integration tests for critical paths

3. **Documentation**
   - Update README for new features
   - Document API changes
   - Include JSDoc comments

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support, please:
1. Check the documentation
2. Search existing issues
3. Create a new issue if needed

## Acknowledgments

- Spring Boot team
- Material-UI team
- Open source community

For more detailed information or support, please open an issue in the repository.
