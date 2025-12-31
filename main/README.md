# Main Package

This package contains the entry point of the Student Management System application.

## 📋 Overview

The `main` package serves as the presentation layer of the application. It demonstrates the usage of the Student Management System by performing various CRUD operations and displaying the results to the console.

## 📄 Files

### Main.java

The `Main` class is the entry point of the application that demonstrates all core functionalities.

## 🎯 Purpose

- **Application Entry Point**: Contains the `main()` method where program execution begins
- **Demonstration**: Shows how to use the StudentService class
- **User Interface**: Acts as the console-based user interface layer
- **Testing**: Demonstrates various operations with sample data

## 💻 Current Implementation

### Operations Demonstrated

1. **Create Students**
   - Adding multiple student records
   - Using parameterized constructor
   - Sample data initialization

2. **Display All Students**
   - Viewing complete student list
   - Formatted console output

3. **Search by ID**
   - Finding specific student records
   - Handling found and not-found scenarios

4. **Delete Student**
   - Removing student records
   - Verifying deletion success

### Sample Output Format

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

## 🔄 Workflow

```
Start
  ↓
Initialize StudentService
  ↓
Add Sample Students (ID: 1, 2)
  ↓
Display All Students
  ↓
Search Student by ID (1)
  ↓
Display Search Result
  ↓
Delete Student (ID: 2)
  ↓
Display Updated List
  ↓
End
```

## 🎨 Code Structure

```java
public class Main {
    public static void main(String[] args) {
        // 1. Initialize service
        StudentService service = new StudentService();
        
        // 2. Add students
        service.addStudent(...);
        
        // 3. Display all
        service.displayStudents();
        
        // 4. Search operation
        Student student = service.searchStudentById(1);
        
        // 5. Delete operation
        service.deleteStudent(2);
        
        // 6. Display after changes
        service.displayStudents();
    }
}
```

## 🚀 How to Run

### Using Command Line

```bash
# Navigate to project root
cd student-management-system

# Compile
javac main/Main.java

# Run
java main.Main
```

### Using IDE

1. Open project in IDE (IntelliJ IDEA, Eclipse, VS Code)
2. Navigate to `main/Main.java`
3. Right-click and select "Run Main.main()"

## 🔧 Customization

### Adding More Students

```java
// Add additional students in main method
service.addStudent(new Student(3, "Priya", 19, "CSE", 92, "priya@email.com"));
service.addStudent(new Student(4, "Amit", 22, "ECE", 88, "amit@email.com"));
```

### Adding More Operations

```java
// Search by different criteria
ArrayList<Student> cseStudents = service.searchStudentsByCourse("CSE");

// Update student
service.updateStudent(1, updatedStudent);

// Get statistics
double avgMarks = service.calculateAverageMarks();
Student topStudent = service.getTopStudent();
```

## 🎓 Learning Points

### Demonstrated Concepts

1. **Object Creation**
   - Creating StudentService instance
   - Creating Student objects with constructor

2. **Method Invocation**
   - Calling service methods
   - Passing parameters

3. **Null Handling**
   - Checking if search returns null
   - Conditional output based on results

4. **Console Output**
   - Using System.out.println()
   - Formatted string display

## 🔮 Future Enhancements

### Planned Improvements

- [ ] **Interactive Menu**: Console menu for user input
- [ ] **Input Scanner**: Dynamic user input instead of hardcoded data
- [ ] **Error Messages**: Better error handling and user feedback
- [ ] **Validation Integration**: Use ValidationUtil before adding students
- [ ] **Batch Operations**: Load students from file
- [ ] **Export Functionality**: Save students to file

### Menu-Driven Approach

```java
// Future implementation
while (true) {
    displayMenu();
    int choice = scanner.nextInt();
    
    switch (choice) {
        case 1: // Add Student
        case 2: // View All
        case 3: // Search
        case 4: // Update
        case 5: // Delete
        case 6: // Exit
    }
}
```

## 📊 Dependencies

This class depends on:
- `model.Student` - Student entity class
- `service.StudentService` - Business logic layer

## ⚠️ Important Notes

- Currently uses **hardcoded data** for demonstration
- No user input functionality (planned for future)
- All operations are demonstrated sequentially
- Service instance is not reused across multiple runs

## 🐛 Known Limitations

1. **No Persistence**: Data is lost when program exits
2. **No User Input**: Cannot add custom students at runtime
3. **Fixed Demonstration**: Always runs same operations
4. **No Menu**: User cannot choose operations interactively

## 📚 Related Documentation

- [Student Model](../model/README.md) - Student entity documentation
- [StudentService](../service/README.md) - Business logic documentation
- [ValidationUtil](../util/README.md) - Validation utilities

## 🎯 Sample Output

```
All Students:
Id      : 1
Name    : Aadarsh
Age     : 20
Course  : CSE
Marks   : 85
Email   : aadarsh@email.com
---------------------------
Id      : 2
Name    : Rahul
Age     : 21
Course  : ECE
Marks   : 78
Email   : rahul@email.com
---------------------------

Searching for student with ID 1:
Found: Aadarsh

Deleting student with ID 2

After Deletion:
Id      : 1
Name    : Aadarsh
Age     : 20
Course  : CSE
Marks   : 85
Email   : aadarsh@email.com
---------------------------
```

---

*Part of Student Management System by Aadarsh Singh*
