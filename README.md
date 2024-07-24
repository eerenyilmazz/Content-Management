# Content Management (Under Development)

## Overview

This project is a Spring Boot-based backend system designed to manage content-related entities such as Cast, Content, and Metadata. The system provides CRUD operations for these entities and integrates with the OMDb API to fetch additional metadata.

### Current Status
This project is actively under development. It aims to provide a robust backend solution for managing various types of content and associated metadata efficiently.

## Features

- **Java 17**: The project is developed using Java 17, leveraging its latest features.
- **RESTful API**: Provides comprehensive endpoints for managing Cast, Content, and Metadata.
- **OMDb Integration**: Fetches detailed metadata from the OMDb API to enrich content information.

## Technologies Used

- Spring Boot
- Hibernate with MySQL (configured via Spring Data JPA)

## Getting Started

### Prerequisites

- Java 17 JDK installed
- Maven or Gradle
- MySQL database instance

### Installation and Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/eerenyilmazz/Content-Management.git
    cd content-management
    ```

2. **Set up database:**

    - Update `application.properties` with your database credentials:

        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        ```

3. **Configure OMDb API key:**

    Obtain an API key from [OMDb API](http://www.omdbapi.com/apikey.aspx) and add it to `application.properties`:

    ```properties
    omdb.api.key=your_api_key_here
    ```

4. **Build and run the application:**

    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

    The application will start on `http://localhost:8080`.

### API Endpoints

#### Cast

- **Create Cast**
  - `POST /api/casts`
- **Update Cast**
  - `PUT /api/casts/{id}`
- **Get Cast**
  - `GET /api/casts/{id}`
- **Get All Casts**
  - `GET /api/casts`
- **Delete Cast**
  - `DELETE /api/casts/{id}`

#### Content

- **Create Content**
  - `POST /api/contents`
- **Update Content**
  - `PUT /api/contents/{id}`
- **Get Content**
  - `GET /api/contents/{id}`
- **Get All Contents**
  - `GET /api/contents`
- **Delete Content**
  - `DELETE /api/contents/{id}`

#### Metadata

- **Create Metadata**
  - `POST /api/metadata`
- **Update Metadata with OMDb**
  - `POST /api/metadata/update-omdb/{id}`
- **Get Metadata**
  - `GET /api/metadata/{id}`
- **Get All Metadata**
  - `GET /api/metadata`

### Testing

- Automated tests ensure API endpoints function correctly.
- Use tools like Postman for manual testing and verification.
