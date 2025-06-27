# 🛒 EasyShop E-Commerce Backend (Capstone 3)

This is a Spring Boot REST API project for **EasyShop**, an e-commerce web store. It is the backend system for managing products, categories, user accounts, and shopping cart functionality. This application serves as Capstone 3 of the Pluralsight/Year Up curriculum.

---

## 📌 Project Highlights

- **Java 17**, **Spring Boot**, **MySQL**, **JDBC**, **Postman**
- Supports user registration, login (with JWT), product browsing, and filtering
- Admin-protected endpoints for managing products and categories
- Full shopping cart with persistent user-based item storage
- Designed with clean separation between controllers, DAOs, and models

---

## 📁 Features Implemented

### ✅ Core APIs
| Feature              | Endpoint(s)                                      | Access       |
|---------------------|--------------------------------------------------|--------------|
| View all categories | `GET /categories`                                | Public       |
| View one category   | `GET /categories/{id}`                           | Public       |
| Manage categories   | `POST`, `PUT`, `DELETE /categories/{id}`         | Admin only   |
| View products       | `GET /products`, `GET /products?cat=1&color=red` | Public       |
| Shopping cart       | `GET /cart`, `POST`, `PUT`, `DELETE`             | Logged in    |

---

## ⚙️ Getting Started

### ✅ Prerequisites

- Java 17+
- IntelliJ or any Java IDE
- MySQL installed and running
- Postman for API testing

---

### 📂 Project Setup

1. **Clone**


Create MySQL Database

Open create_database.sql from the /database/ folder in MySQL Workbench.

Execute the script to create the easyshop schema with sample data.

Run the Application

Open the project in IntelliJ

Run EasyshopApplication.java

Backend should launch at:

arduino
Copy
Edit
http://localhost:8080
🧪 Testing with Postman
Make sure to:

Authenticate and copy the JWT token

Use Bearer Token in Authorization tab for protected routes

🔐 Sample Login
http
Copy
Edit
POST /login
{
  "username": "admin",
  "password": "password123"
}
📦 Sample Cart Call
http
Copy
Edit
GET /cart
Headers:
Authorization: Bearer <your-jwt-token>
📸 Screenshots
Insert screenshots here showing:

Postman test results

Sample product JSON

Database table structure

🧠 Notable Code Snippets
Update Product in Cart

java
Copy
Edit
@PutMapping("/cart/products/{productId}")
public ShoppingCart updateProduct(...){ ... }
Secure Routes with Admin Role

java
Copy
Edit
@PreAuthorize("hasRole('ROLE_ADMIN')")
🧑‍💻 Author
A. Do
Backend Java Developer – Year Up Capstone 3
GitHub: @yourusername

✅ Future Enhancements (Optional)
Checkout system & order history

User profile management

Email confirmations for cart/checkout


##SCREENSHOTS

<img width="954" alt="image" src="https://github.com/user-attachments/assets/0c8aa125-28f6-4918-bc1a-8eb8b15c50bb" />
