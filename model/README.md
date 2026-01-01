# Model Package

This package contains the data model (entity) classes for the Student Management System.

## 📋 Overview

The `model` package defines the structure and behavior of data entities used throughout the application. It represents the **data layer** of the application architecture.

## 📄 Files

### Student.java

The `Student` class is a Plain Old Java Object (POJO) that represents a student entity with all relevant attributes and behaviors.

## 🎯 Purpose

- **Data Representation**: Models a real-world student entity
- **Encapsulation**: Protects data through private fields and public methods
- **Data Transfer**: Acts as a data container between layers
- **Type Safety**: Provides strong typing for student data

## 🏗️ Class Structure

### Attributes (Private Fields)

| Field | Type | Description | Constraints |
|-------|------|-------------|-------------|
| `id` | int | Unique student identifier | Must be positive, unique |
| `name` | String | Student's full name | 2-50 characters |
| `age` | int | Student's age | 16-60 years |
| `course` | String | Course/Department | Not empty |
| `marks` | int | Academic marks | 0-100 |
| `email` | String | Contact email | Valid email format |

### Constructors

#### 1. Default Constructor
```java
Student()
```
- Initializes all fields with default values
- Used when creating empty student objects
- Values: id=0, marks=0, age=0, name="", course="", email=""

#### 2. Parameterized Constructor
```java
Student(int id, String name, int age, String course, int marks, String email)
```
- Initializes student with provided values
- Most commonly used constructor
- Allows creating fully populated student objects in one step

### Methods

#### Getters (6 methods)
- `getId()` - Returns student ID
- `getName()` - Returns student name
- `getAge()` - Returns student age
- `getCourse()` - Returns course name
- `getMarks()` - Returns marks
- `getEmail()` - Returns email address

#### Setters (6 methods)
- `setId(int id)` - Updates student ID
- `setName(String name)` - Updates name
- `setAge(int age)` - Updates age
- `setCourse(String course)` - Updates course
- `setMarks(int marks)` - Updates marks
- `setEmail(String email)` - Updates email

## 💡 Design Principles

### 1. Encapsulation

All fields are **private**, ensuring:
- Data cannot be directly accessed from outside
- Controlled access through getters and setters
- Data integrity and validation can be added

```java
// ❌ Cannot access directly
student.id = 5; // Compilation error

// ✅ Must use setter
student.setId(5); // Correct way
```

### 2. Data Hiding

Internal representation is hidden from external classes:
- Only necessary methods are exposed
- Implementation can change without affecting other classes
- Easier maintenance and debugging

### 3. Object-Oriented Design

Follows OOP principles:
- **Abstraction**: Hides complexity, shows only necessary details
- **Encapsulation**: Bundles data and methods together
- **Single Responsibility**: Only handles student data

## 🎨 Usage Examples

### Creating a Student

```java
// Using default constructor
Student student1 = new Student();
student1.setId(1);
student1.setName("Aadarsh");
student1.setAge(20);
student1.setCourse("CSE");
student1.setMarks(85);
student1.setEmail("aadarsh@email.com");

// Using parameterized constructor (Preferred)
Student student2 = new Student(2, "Rahul", 21, "ECE", 78, "rahul@email.com");
```

### Accessing Student Data

```java
// Reading data
int studentId = student2.getId();
String studentName = student2.getName();
int studentMarks = student2.getMarks();

System.out.println("Student: " + studentName);
System.out.println("Marks: " + studentMarks);
```

### Modifying Student Data

```java
// Updating existing student
student2.setMarks(80);
student2.setEmail("rahul.new@email.com");
```

## 📊 Why This Design?

### Advantages

✅ **Flexibility**: Easy to add validation in setters later
✅ **Maintainability**: Changes don't affect other classes
✅ **Reusability**: Can be used across different parts of application
✅ **Type Safety**: Compiler checks data types
✅ **Documentation**: Clear structure shows what data a student has

### Comparison: With vs Without Encapsulation

**Without Encapsulation (BAD)**:
```java
class Student {
    public int id;
    public String name;
    // Anyone can modify directly
}

student.id = -5; // Invalid, but no way to prevent!
```

**With Encapsulation (GOOD)**:
```java
class Student {
    private int id;
    
    public void setId(int id) {
        if (id > 0) {  // Validation possible
            this.id = id;
        }
    }
}
```

## 🔮 Future Enhancements

### Potential Improvements

1. **Validation in Setters**
   ```java
   public void setMarks(int marks) {
       if (marks >= 0 && marks <= 100) {
           this.marks = marks;
       } else {
           throw new IllegalArgumentException("Invalid marks");
       }
   }
   ```

2. **Additional Fields**
   - Address (Street, City, State, ZIP)
   - Phone number
   - Date of birth
   - Enrollment date
   - Parent/Guardian details
   - Multiple courses (ArrayList)

3. **Calculated Fields**
   - Grade (based on marks)
   - Age from date of birth
   - Years in course

4. **Methods**
   - `calculateGrade()` - Determine letter grade
   - `isEligibleForScholarship()` - Check marks criteria
   - `toString()` - Better formatted output
   - `equals()` and `hashCode()` - For comparison

5. **Immutability**
   - Make fields `final`
   - Remove setters
   - Set all values in constructor only

## 🎓 Key Concepts Demonstrated

### Java Fundamentals

1. **Class Definition**: How to create a class
2. **Constructors**: Default vs Parameterized
3. **Access Modifiers**: private, public
4. **this Keyword**: Referring to current object
5. **Getters and Setters**: Standard JavaBean pattern

### Best Practices

✅ Private fields for data protection
✅ Public methods for controlled access
✅ Meaningful variable names
✅ Consistent naming convention (camelCase)
✅ Multiple constructor options

## 📚 Related Design Patterns

This class follows:
- **JavaBean Pattern**: Standard getter/setter naming
- **POJO Pattern**: Plain Old Java Object
- **Data Transfer Object (DTO)**: Transfers data between layers

## ⚠️ Current Limitations

1. **No Validation**: Setters accept any value
2. **No Business Logic**: Pure data container
3. **Mutable**: Fields can be changed after creation
4. **No toString()**: Default Object.toString() is not readable

## 🔗 Dependencies

This class has **NO dependencies** on other classes:
- Completely independent
- Can be used in any Java project
- Only uses Java standard library (String, int)

## 📖 When to Use

Use this Student class when you need to:
- Store student information temporarily
- Pass student data between methods
- Create collections of students (ArrayList, HashMap)
- Serialize/deserialize student data
- Display student information

## 🎯 Learning Outcomes

By studying this class, you'll understand:
- ✅ How to design a data model class
- ✅ Importance of encapsulation
- ✅ When to use constructors
- ✅ Getter and setter conventions
- ✅ Object-oriented design principles

---

*Part of Student Management System by Aadarsh Singh*
