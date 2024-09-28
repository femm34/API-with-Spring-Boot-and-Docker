# Games API

## Description

A RESTful API for managing games, developed using Spring Boot and PostgreSQL. This project leverages Docker for containerization, providing an easy setup and deployment process. This project aims to implement good practices based on my experience. The API allows for CRUD operations on game data.

Feel free to modify it to better fit your project's specifics! If you need any adjustments or additional details, just let me know.

## Prerequisites

Make sure you have the following installed:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Setup

1. **`.env` File**: Ensure that the `.env` file is present in the root of the project. It should contain the following variables:

    ```env
    SPRING_APPLICATION_NAME=games
    SERVER_PORT=8080
    SPRING_DATASOURCE_URL= your database url
    SPRING_DATASOURCE_USERNAME= your db username
    SPRING_DATASOURCE_PASSWORD= your db password
    SPRING_JPA_HIBERNATE_DDL_AUTO=update
    ```

## Running the Application

Follow these steps to build and run the application:

1. **Build and Run Containers**:

   Open a terminal in the root of the project and run:

   ```bash
   docker-compose up --build
