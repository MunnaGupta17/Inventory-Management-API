# Inventory Management API

This is a RESTful API for managing inventory, including products, categories, suppliers, and customer orders. It is built using Java and Spring Boot and provides a secure and scalable solution for inventory management.

## 👉 Features this API has

❖ You can add, edit, delete, and fetch Products.<br>
❖ You can add, edit, delete, and fetch Categories.<br>
❖ You can add, edit, delete, and fetch Suppliers.<br>
❖ You can add, edit, delete, and fetch Customer Orders.<br>
❖ Comprehensive error handling and validation.<br>

## Getting Started

To run this project locally, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/inventory-management-api.git
   cd inventory-management-api
2. **Set Up the Database**:

   Create a MySQL database named `inventory_management`.

   Update the `src/main/resources/application.properties` file with your MySQL credentials:

   ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/inventory_management
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
3. **Build and Run the Application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
4. **Access the API**:

   The API will be running at http://localhost:8080/api.

   
