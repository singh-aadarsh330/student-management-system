# 📐 Model Layer: Student Registry Entity

This package defines the core **Student** entity, following the Plain Old Java Object (POJO) pattern for high portability and modularity.

## 📁 Files
- `Student.java`: The primary data model containing fields for ID, Name, Age, Course, Marks, and Email.

## 🏗️ Design Strategy
The model layer implements **Strict Encapsulation**. All fields are `private`, with access restricted through standardized public Getters and Setters.

### Field Constraints:
| Attribute | Constraint |
|---|---|
| `id` | Unique Primary Key |
| `marks` | Range [0, 100] |
| `age` | Range [16, 60] |

## 🚀 Usage
```java
Student student = new Student(1, "Aadarsh", 20, "CSE", 95, "aadarsh@kiit.ac.in");
```
