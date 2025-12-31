# Student Management System

A console-based Student Management System built with Java that demonstrates Object-Oriented Programming principles, data structures, and clean architecture design.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Principles-blue?style=flat-square)
![Console](https://img.shields.io/badge/Console-Application-green?style=flat-square)

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Usage](#-usage)
- [Class Documentation](#-class-documentation)
- [Design Principles](#-design-principles)
- [Future Enhancements](#-future-enhancements)
- [Contributing](#-contributing)

## 🎯 Overview

This Student Management System is a Java application that allows educational institutions to manage student records efficiently. It provides a simple yet robust solution for performing CRUD (Create, Read, Update, Delete) operations on student data.

### Purpose

- Demonstrate **Object-Oriented Programming** concepts
- Showcase **layered architecture** design
- Practice **data structure** implementation (ArrayList)
- Implement **validation** and error handling
- Build a foundation for scalable applications

## ✨ Features

### Core Functionality

- ✅ **Add Student** - Register new students with complete information
- ✅ **Display All Students** - View all registered students
- ✅ **Search Student** - Find students by unique ID
- ✅ **Delete Student** - Remove student records
- ✅ **Input Validation** - Ensure data integrity
- ✅ **Clean Console Interface** - User-friendly display

### Data Management

- **Student Information:**
  - ID (Unique identifier)
  - Name
  - Age
  - Course/Department
  - Marks
  - Email

### Validation Rules

- Email must contain `@` and `.`
- Marks range: 0-100
- Age range: 16-60
- ID must be unique

## 📁 Project Structure

```
student-management-system/
│
├── main/
│   └── Main.java                 # Application entry point
│
├── model/
│   └── Student.java              # Student entity class
│
├── service/
│   └── StudentService.java       # Business logic layer
│
├── util/
│   └── ValidationUtil.java       # Validation utilities
│
├── README.md                     # This file
└── .gitattributes               # Git configuration
```

### Architecture Layers

```
┌─────────────────────────────┐
│   Presentation Layer (Main) │  ← User Interface
├─────────────────────────────┤
│   Service Layer             │  ← Business Logic
├─────────────────────────────┤
│   Utility Layer             │  ← Validation & Helpers
├─────────────────────────────┤
│   Model Layer (Student)     │  ← Data Entities
└─────────────────────────────┘
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line terminal or Java IDE

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/singh-aadarsh330/student-management-system.git
   cd student-management-system
   ```

2. **Compile the project**
   ```bash
   javac main/Main.java model/Student.java service/StudentService.java util/ValidationUtil.java
   ```

3. **Run the application**
   ```bash
   java main.Main
   ```

### Using an IDE

1. Open project in IntelliJ IDEA, Eclipse, or VS Code
2. Navigate to `main/Main.java`
3. Run the Main class

## 💻 Usage

### Basic Operations

#### Adding a Student

```java
StudentService service = new StudentService();
service.addStudent(new Student(1, "Aadarsh", 20, "CSE", 85, "aadarsh@email.com"));
```

#### Displaying All Students

```java
service.displayStudents();
```

**Output:**
```
All Students:
Id      : 1
Name    : Aadarsh
Age     : 20
Course  : CSE
Marks   : 85
Email   : aadarsh@email.com
---------------------------
```

#### Searching for a Student

```java
Student student = service.searchStudentById(1);
if (student != null) {
    System.out.println("Found: " + student.getName());
} else {
    System.out.println("Student not found.");
}
```

#### Deleting a Student

```java
boolean deleted = service.deleteStudent(2);
if (deleted) {
    System.out.println("Student deleted successfully");
}
```

### Sample Workflow

```java
// Create service instance
StudentService service = new StudentService();

// Add students
service.addStudent(new Student(1, "Aadarsh", 20, "CSE", 85, "aadarsh@email.com"));
service.addStudent(new Student(2, "Rahul", 21, "ECE", 78, "rahul@email.com"));

// Display all
service.displayStudents();

// Search by ID
Student student = service.searchStudentById(1);

// Delete student
service.deleteStudent(2);

// Display after deletion
service.displayStudents();
```

## 📚 Class Documentation

### 1. Main Class (`main/Main.java`)

**Purpose:** Entry point of the application

**Responsibilities:**
- Initialize StudentService
- Demonstrate CRUD operations
- Handle user interactions

### 2. Student Class (`model/Student.java`)

**Purpose:** Represents a student entity

**Attributes:**
- `id` (int) - Unique identifier
- `name` (String) - Student's full name
- `age` (int) - Student's age
- `course` (String) - Course/Department
- `marks` (int) - Academic marks (0-100)
- `email` (String) - Contact email

**Constructors:**
- `Student()` - Default constructor
- `Student(int id, String name, int age, String course, int marks, String email)` - Parameterized constructor

**Methods:**
- Getters and Setters for all attributes

### 3. StudentService Class (`service/StudentService.java`)

**Purpose:** Manages student operations (Business logic)

**Data Structure:** `ArrayList<Student>`

**Methods:**

| Method | Parameters | Return Type | Description |
|--------|-----------|-------------|-------------|
| `addStudent()` | `Student` | `void` | Adds a new student |
| `displayStudents()` | None | `void` | Displays all students |
| `searchStudentById()` | `int id` | `Student` | Finds student by ID |
| `deleteStudent()` | `int id` | `boolean` | Removes student |

### 4. ValidationUtil Class (`util/ValidationUtil.java`)

**Purpose:** Provides validation utilities

**Methods:**

```java
// Email validation
public static boolean isValidEmail(String email)

// Marks validation (0-100)
public static boolean isValidMarks(int marks)

// Age validation (16-60)
public static boolean isValidAge(int age)
```

## 🎨 Design Principles

### Object-Oriented Programming

#### 1. **Encapsulation**
- All Student attributes are private
- Access through public getters/setters
- Data protection and controlled access

#### 2. **Single Responsibility Principle**
- Each class has one specific purpose
- Main: User interface
- Student: Data model
- StudentService: Business logic
- ValidationUtil: Input validation

#### 3. **Separation of Concerns**
- Clear layer boundaries
- Easy to maintain and extend
- Independent testing of components

### Best Practices Implemented

✅ **Meaningful naming** - Clear, descriptive names  
✅ **Code organization** - Logical folder structure  
✅ **Comments** - Inline documentation  
✅ **Validation** - Input checking  
✅ **Error handling** - Null checks and edge cases  
✅ **Consistent formatting** - Readable code style

## 📊 Complexity Analysis

### Time Complexity

| Operation | Time Complexity | Explanation |
|-----------|----------------|-------------|
| Add Student | O(1) | ArrayList add operation |
| Display All | O(n) | Iterate through all students |
| Search by ID | O(n) | Linear search through list |
| Delete by ID | O(n) | Find and remove operation |

### Space Complexity

- **O(n)** where n is the number of students
- ArrayList storage grows dynamically

## 🔮 Future Enhancements

### Planned Features

- [ ] **Update Student Information** - Modify existing records
- [ ] **Grade Calculation** - Automatic grade assignment
- [ ] **Attendance Tracking** - Student attendance management
- [ ] **Course Management** - Manage multiple courses
- [ ] **File Persistence** - Save/Load data from files
- [ ] **Database Integration** - MySQL/PostgreSQL support
- [ ] **GUI Interface** - JavaFX or Swing UI
- [ ] **Report Generation** - PDF/CSV exports
- [ ] **Advanced Search** - Filter by multiple criteria
- [ ] **Sorting Options** - Sort by name, marks, age
- [ ] **Bulk Operations** - Import/export multiple students
- [ ] **Authentication** - Admin and user roles

### Technical Improvements

- [ ] **Exception Handling** - Custom exceptions
- [ ] **Logging** - Track system operations
- [ ] **Unit Tests** - JUnit test cases
- [ ] **Design Patterns** - Singleton, Factory patterns
- [ ] **Input Validation** - More comprehensive checks
- [ ] **Performance Optimization** - Use HashMap for O(1) search

## 🧪 Testing

### Manual Testing Checklist

- [ ] Add student with valid data
- [ ] Add student with duplicate ID
- [ ] Display empty student list
- [ ] Display populated student list
- [ ] Search existing student
- [ ] Search non-existing student
- [ ] Delete existing student
- [ ] Delete non-existing student
- [ ] Validate email format
- [ ] Validate marks range
- [ ] Validate age range

## 🤝 Contributing

Contributions are welcome! Here's how:

1. Fork the repository
2. Create feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Contribution Guidelines

- Follow existing code style
- Add comments for complex logic
- Update documentation
- Test thoroughly before submitting

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Aadarsh Singh**

- GitHub: [@singh-aadarsh330](https://github.com/singh-aadarsh330)
- LinkedIn: [singh-aadarsh330](https://www.linkedin.com/in/singh-aadarsh330)
- GeeksforGeeks: [singhaadarsh330](https://www.geeksforgeeks.org/user/singhaadarsh330)

## 🙏 Acknowledgments

- Inspired by real-world educational systems
- Built as part of Java learning journey
- Thanks to the Java community for resources

## 📞 Support

For questions or issues:
- Open an issue on GitHub
- Connect via LinkedIn

---

<div align="center">

### ⭐ If you find this project helpful, please give it a star!

**Built with ❤️ using Java**

*Last Updated: January 2026*

</div>
