# Blogging Platform API

------

## **Project Overview**

This project is a blogging platform API developed using **Spring Boot** and **MySQL 8.0**. The API supports operations for creating, updating, deleting, and querying blog posts, including search functionality. It follows RESTful standards and provides clear HTTP responses.

------

## **Environment Requirements**

To run this project, ensure the following environment setup:

1. **Java Development Kit (JDK)**: Version 1.8 or higher
2. **Spring Boot**: Version 2.x
3. **MySQL Database**: Version 8.0
4. **Maven**: For dependency and project management
5. **IDE**: IntelliJ IDEA, Eclipse, or other preferred Java IDE
6. **Postman or cURL**: For API testing

------

## **Project Dependencies**

The project relies on the following major libraries:

1. **Spring Web**: For building RESTful APIs.
2. **MyBatis Plus**: To simplify database operations.
3. **MySQL Connector**: To connect and interact with MySQL database.
4. **Apache Commons Lang**: Utility methods for String handling.

All dependencies are managed using Maven.

------

## **Project Structure**

```plaintext
blogging_platform_api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── kirito/
│   │   │   │       └── blogging_platform_api/
│   │   │   │           ├── controller/        # Controller classes for API endpoints
│   │   │   │           ├── common/            # Common utilities and constants
│   │   │   │           ├── dtos/              # Data Transfer Objects (DTOs)
│   │   │   │           ├── mapper/            # MyBatis Mapper interfaces
│   │   │   │           ├── service/           # Service layer interfaces and implementations
│   │   │   │           └── pojo/              # POJO classes (e.g., BlogPost)
│   │   └── resources/
│   │       ├── application.yml               # Application configuration (e.g., database settings)
│   │       ├── application-pro.properties
│   │       └── blog_post.sql                       
└── pom.xml                                 # Maven build file with project dependencies
```

------

## **Project Setup**

Follow these steps to set up and run the project:

1. **Clone the Project**:

   ```bash
   git clone https://github.com/whsad/Blogging-Platform-API.git
   cd Blogging-Platform-API
   ```

2. **Configure MySQL Database**:

   - Create a database named `blogging_platform`.

   - Update application.yml  (or application.properties) with your MySQL connection details:

     ```yaml
     spring:
       datasource:
         url: jdbc:mysql://localhost:3306/blogging_platform?useSSL=false&serverTimezone=UTC
         username: your-username
         password: your-password
         driver-class-name: com.mysql.cj.jdbc.Driver
     ```

3. **Run the Project**:
    Use Maven to build and run the project:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the API**:
    The project will start on `http://localhost:8080`.

------

## **API Endpoints**

### 1. **Create a Blog Post**

- **Method**: `POST`

- **URL**: `/posts`

- **Request Body**:

  ```json
  {
    "title": "My First Blog",
    "content": "This is the content of the blog.",
    "category": "Technology",
    "tags": ["Java", "Spring Boot"]
  }
  ```

- **Response**:

  - Success: HTTP 201 Created with the created blog entity.
  - Failure: HTTP 400 Bad Request.

------

### 2. **Update a Blog Post**

- **Method**: `PUT`

- **URL**: `/posts/{id}`

- **Request Body**:

  ```json
  {
    "title": "Updated Blog Title",
    "content": "Updated content here.",
    "category": "Programming",
    "tags": ["Java", "Spring"]
  }
  ```

- **Response**:

  - Success: HTTP 200 OK with the updated blog post.
  - Failure: HTTP 404 Not Found if the ID does not exist.

------

### 3. **Delete a Blog Post**

- **Method**: `DELETE`
- **URL**: `/posts/{id}`
- **Response**:
  - Success: HTTP 204 No Content.
  - Failure: HTTP 404 Not Found if the ID does not exist.

------

### 4. **Retrieve a Blog Post by ID**

- **Method**: `GET`
- **URL**: `/posts/{id}`
- **Response**:
  - Success: HTTP 200 OK with the blog post data.
  - Failure: HTTP 404 Not Found.

------

### 5. **Retrieve All Blog Posts or Search by Term**

- **Method**: `GET`
- **URL**: `/posts`
- **Optional Query Parameter**:
  - `term` (String): Search term for titles, content, or tags.
- **Example**:
   `GET /posts?term=Java`
- **Response**:
  - Success: HTTP 200 OK with a list of matching blog posts.

------

## **Functionality Overview**

1. **Create Blog Posts**: Add new blog entries with title, content, category, and tags.
2. **Update Blog Posts**: Modify existing blog posts.
3. **Delete Blog Posts**: Remove blog posts by their ID.
4. **Retrieve Blog Posts**:
   - Fetch all blog posts.
   - Fetch a specific blog post by ID.
   - Search blog posts based on a keyword that matches the title, content, or tags.

------

## **Response Structure**

All responses follow a uniform structure for consistency:

```json
{
   "code": 200,
   "message": "Success",
   "data": {...}
}
```

- `code`: HTTP status code.
- `message`: Descriptive message for the response.
- `data`: The returned data (if any).

------

## **Testing**

Use tools like Postman or cURL to test the above endpoints. Ensure the MySQL server is running and accessible.

------

This is a solution to a project challenge in [roadmap.sh](https://roadmap.sh/projects/blogging-platform-api).
