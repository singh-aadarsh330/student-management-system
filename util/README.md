# Util Package

This package contains utility classes that provide reusable helper functions for the Student Management System.

## 📋 Overview

The `util` package provides validation and helper utilities used across the application. It represents the **utility layer** that supports other layers with common functionalities.

## 📄 Files

### ValidationUtil.java

A utility class containing static methods for validating student data before operations.

## 🎯 Purpose

- **Input Validation**: Ensure data meets business requirements
- **Data Integrity**: Prevent invalid data from entering the system
- **Reusability**: Common validation logic in one place
- **Separation of Concerns**: Keep validation separate from business logic
- **Error Prevention**: Catch invalid data early

## 🏗️ Class Structure

### Static Utility Class

```java
class ValidationUtil {
    // All methods are static - no instance needed
}
```

**Why Static?**
- No state to maintain
- Pure functions (same input → same output)
- Can be called without creating objects
- Memory efficient

**Usage**:
```java
// No need to instantiate
boolean valid = ValidationUtil.isValidEmail("test@email.com");
```

## 💻 Validation Methods

### 1. Email Validation

```java
public static boolean isValidEmail(String email)
```

**Purpose**: Validates email format

**Validation Rules**:
- Email must not be null
- Must contain `@` symbol
- Must contain `.` (dot)

**Examples**:
```java
ValidationUtil.isValidEmail("aadarsh@email.com")  // ✅ true
ValidationUtil.isValidEmail("rahul@test.co.in")   // ✅ true
ValidationUtil.isValidEmail("invalid-email")      // ❌ false
ValidationUtil.isValidEmail("test@")              // ❌ false
ValidationUtil.isValidEmail(null)                 // ❌ false
```

**Implementation Logic**:
```
1. Check if email is null → return false
2. Check if email contains "@" → continue or return false
3. Check if email contains "." → continue or return false
4. Return true
```

**Limitations**:
- Basic validation only
- Doesn't check proper email structure
- Doesn't verify domain existence
- Can be fooled by "@@.." format

### 2. Marks Validation

```java
public static boolean isValidMarks(int marks)
```

**Purpose**: Validates marks are in acceptable range

**Validation Rules**:
- Marks must be >= 0
- Marks must be <= 100

**Range**: 0 to 100 (inclusive)

**Examples**:
```java
ValidationUtil.isValidMarks(85)   // ✅ true
ValidationUtil.isValidMarks(0)    // ✅ true
ValidationUtil.isValidMarks(100)  // ✅ true
ValidationUtil.isValidMarks(-5)   // ❌ false
ValidationUtil.isValidMarks(105)  // ❌ false
```

**Why This Range?**
- Standard percentage scoring system
- 0 = No marks obtained
- 100 = Perfect score
- Negative marks don't make sense
- Over 100 is beyond maximum

### 3. Age Validation

```java
public static boolean isValidAge(int age)
```

**Purpose**: Validates age is within acceptable student age range

**Validation Rules**:
- Age must be >= 16
- Age must be <= 60

**Range**: 16 to 60 (inclusive)

**Examples**:
```java
ValidationUtil.isValidAge(20)   // ✅ true
ValidationUtil.isValidAge(16)   // ✅ true (minimum)
ValidationUtil.isValidAge(60)   // ✅ true (maximum)
ValidationUtil.isValidAge(15)   // ❌ false (too young)
ValidationUtil.isValidAge(65)   // ❌ false (too old)
```

**Why This Range?**
- 16: Typical minimum college admission age
- 60: Maximum for mature/returning students
- Covers undergraduate to mature students
- Business rule specific to academic institutions

## 📊 Validation Summary

| Method | Input Type | Valid Range/Format | Example Valid | Example Invalid |
|--------|-----------|-------------------|---------------|-----------------|
| `isValidEmail()` | String | Contains @ and . | test@email.com | invalid-email |
| `isValidMarks()` | int | 0 - 100 | 85 | -5 or 105 |
| `isValidAge()` | int | 16 - 60 | 20 | 10 or 70 |

## 🎨 Usage Examples

### Before Adding Student

```java
// Validate before creating Student object
String email = "aadarsh@email.com";
int marks = 85;
int age = 20;

if (ValidationUtil.isValidEmail(email) && 
    ValidationUtil.isValidMarks(marks) && 
    ValidationUtil.isValidAge(age)) {
    
    Student student = new Student(1, "Aadarsh", age, "CSE", marks, email);
    service.addStudent(student);
    System.out.println("Student added successfully!");
} else {
    System.out.println("Invalid student data!");
}
```

### In StudentService

```java
public void addStudent(Student s) {
    // Validate before adding
    if (!ValidationUtil.isValidEmail(s.getEmail())) {
        System.out.println("Invalid email format!");
        return;
    }
    
    if (!ValidationUtil.isValidMarks(s.getMarks())) {
        System.out.println("Marks must be between 0 and 100!");
        return;
    }
    
    if (!ValidationUtil.isValidAge(s.getAge())) {
        System.out.println("Age must be between 16 and 60!");
        return;
    }
    
    students.add(s);
}
```

### User Input Validation

```java
Scanner scanner = new Scanner(System.in);

// Email input
String email;
do {
    System.out.print("Enter email: ");
    email = scanner.nextLine();
    if (!ValidationUtil.isValidEmail(email)) {
        System.out.println("Invalid email! Must contain @ and .");
    }
} while (!ValidationUtil.isValidEmail(email));

// Marks input
int marks;
do {
    System.out.print("Enter marks (0-100): ");
    marks = scanner.nextInt();
    if (!ValidationUtil.isValidMarks(marks)) {
        System.out.println("Invalid marks! Must be between 0 and 100.");
    }
} while (!ValidationUtil.isValidMarks(marks));
```

## 🔮 Future Enhancements

### 1. Advanced Email Validation

```java
public static boolean isValidEmailAdvanced(String email) {
    // Regex pattern for proper email validation
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    return email != null && email.matches(emailRegex);
}
```

### 2. Name Validation

```java
public static boolean isValidName(String name) {
    // Check if name is not empty and contains only letters
    return name != null && 
           !name.trim().isEmpty() && 
           name.matches("[a-zA-Z ]+");
}
```

### 3. Course Validation

```java
public static boolean isValidCourse(String course) {
    // List of valid courses
    String[] validCourses = {"CSE", "ECE", "ME", "CE", "EE"};
    return Arrays.asList(validCourses).contains(course);
}
```

### 4. ID Validation

```java
public static boolean isValidId(int id) {
    return id > 0; // ID must be positive
}
```

### 5. Phone Number Validation

```java
public static boolean isValidPhone(String phone) {
    // 10 digits only
    return phone != null && phone.matches("\\d{10}");
}
```

### 6. Composite Validation

```java
public static String validateStudent(Student s) {
    StringBuilder errors = new StringBuilder();
    
    if (!isValidId(s.getId())) {
        errors.append("Invalid ID\n");
    }
    if (!isValidName(s.getName())) {
        errors.append("Invalid name\n");
    }
    if (!isValidAge(s.getAge())) {
        errors.append("Age must be 16-60\n");
    }
    if (!isValidMarks(s.getMarks())) {
        errors.append("Marks must be 0-100\n");
    }
    if (!isValidEmail(s.getEmail())) {
        errors.append("Invalid email format\n");
    }
    
    return errors.toString();
}
```

## 💡 Design Principles

### 1. Single Responsibility

Each method validates **one specific thing**:
- `isValidEmail()` → Only email
- `isValidMarks()` → Only marks
- `isValidAge()` → Only age

### 2. Pure Functions

Methods have **no side effects**:
- Don't modify input parameters
- Don't change any state
- Same input always gives same output
- No dependencies on external state

### 3. Static Utility Pattern

**Characteristics**:
- All methods are static
- No instance variables
- No constructor needed
- Stateless operations

**Benefits**:
- Easy to use (no object creation)
- Memory efficient
- Thread-safe (no shared state)
- Clear purpose (utility methods)

## ⚡ Performance

### Time Complexity

| Method | Time Complexity | Explanation |
|--------|----------------|-------------|
| `isValidEmail()` | O(n) | String contains() checks |
| `isValidMarks()` | O(1) | Simple comparison |
| `isValidAge()` | O(1) | Simple comparison |

*n = length of email string*

### Best Practices

✅ **Fast validation**: Simple checks, no complex regex
✅ **Early return**: Return false immediately when invalid
✅ **No exceptions**: Return boolean instead of throwing
✅ **Null safe**: Check for null before operations

## 🎓 Key Concepts Demonstrated

### Java Fundamentals

1. **Static Methods**: Called without object instance
2. **Boolean Returns**: True/false for validation status
3. **String Operations**: contains() method
4. **Comparison Operators**: >=, <=, &&, ||
5. **Type Safety**: Specific parameter types

### Best Practices

✅ **Descriptive naming**: `isValidEmail()` clearly states purpose
✅ **Single purpose**: Each method validates one thing
✅ **No side effects**: Pure functions
✅ **Consistent return**: Always boolean
✅ **Documentation**: Clear JavaDoc comments

## 📚 Common Use Cases

### 1. Form Validation

```java
// Validate user input from forms
if (ValidationUtil.isValidEmail(userInput)) {
    processEmail(userInput);
}
```

### 2. Data Import

```java
// Validate data from CSV/Excel import
for (StudentData data : importedData) {
    if (ValidationUtil.isValidMarks(data.marks) && 
        ValidationUtil.isValidAge(data.age)) {
        createStudent(data);
    }
}
```

### 3. API Input Validation

```java
// Validate data from REST API requests
if (!ValidationUtil.isValidEmail(request.email)) {
    return Response.error("Invalid email");
}
```

### 4. Database Constraints

```java
// Pre-check before database insert
if (ValidationUtil.isValidAge(student.getAge())) {
    database.insert(student);
}
```

## ⚠️ Limitations

### Current Implementation

1. **Basic Email Check**: Only checks for @ and .
2. **No Custom Messages**: Returns true/false only
3. **Fixed Ranges**: Hardcoded age and marks ranges
4. **English Only**: No internationalization
5. **No Logging**: Silent validation

### Improvement Needs

- [ ] Better email regex validation
- [ ] Return validation messages, not just boolean
- [ ] Configurable ranges (from properties file)
- [ ] Support for multiple formats
- [ ] Logging of validation failures

## 🔗 Dependencies

**Zero external dependencies!**
- Uses only Java standard library
- No third-party libraries needed
- Lightweight and portable

## 📖 Testing Strategies

### Unit Tests

```java
@Test
public void testValidEmail() {
    assertTrue(ValidationUtil.isValidEmail("test@email.com"));
    assertFalse(ValidationUtil.isValidEmail("invalid"));
    assertFalse(ValidationUtil.isValidEmail(null));
}

@Test
public void testValidMarks() {
    assertTrue(ValidationUtil.isValidMarks(50));
    assertTrue(ValidationUtil.isValidMarks(0));
    assertTrue(ValidationUtil.isValidMarks(100));
    assertFalse(ValidationUtil.isValidMarks(-1));
    assertFalse(ValidationUtil.isValidMarks(101));
}

@Test
public void testValidAge() {
    assertTrue(ValidationUtil.isValidAge(20));
    assertTrue(ValidationUtil.isValidAge(16));
    assertTrue(ValidationUtil.isValidAge(60));
    assertFalse(ValidationUtil.isValidAge(15));
    assertFalse(ValidationUtil.isValidAge(61));
}
```

### Test Coverage

| Method | Test Cases | Edge Cases |
|--------|-----------|------------|
| isValidEmail | Valid, Invalid, Null | Empty string, Special chars |
| isValidMarks | Min, Max, Middle | -1, 0, 100, 101 |
| isValidAge | Min, Max, Middle | 15, 16, 60, 61 |

## 🎯 When to Use

Use ValidationUtil when you need to:
- Validate user input before processing
- Ensure data integrity before database operations
- Check data during import/export
- Validate API request parameters
- Pre-check before creating objects

---

*Part of Student Management System by Aadarsh Singh*
