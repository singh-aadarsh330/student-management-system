# ⚙️ Service Layer: Academic Business Logic

The service layer orchestrates the core business operations of the application, ensuring that the UI remains decoupled from data management.

## 📁 Files
- `StudentService.java`: Manages the `ArrayList` registry and performs CRUD operations.

## ✨ Responsibilities
- **Registry Management**: Handles the in-memory storage of students.
- **ID Validation**: Ensures every registered student has a unique identifier.
- **Search Optimization**: Implements linear search with early-exit logic.

## 📊 Performance
- **Add**: O(1)
- **Search/Delete**: O(n)
