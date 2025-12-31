class Main {
    public static void main(String[] args) {

        StudentService service = new StudentService();

        // Adding students
        service.addStudent(new Student(1, "Aadarsh", 20, "CSE", 85, "aadarsh@email.com"));
        service.addStudent(new Student(2, "Rahul", 21, "ECE", 78, "rahul@email.com"));

        // Display all students
        System.out.println("All Students:");
        service.displayStudents();

        // Search student by ID
        System.out.println("\nSearching for student with ID 1:");
        Student student = service.searchStudentById(1);
        if (student != null) {
            System.out.println("Found: " + student.getName());
        } else {
            System.out.println("Student not found.");
        }

        // Delete student
        System.out.println("\nDeleting student with ID 2");
        service.deleteStudent(2);

        // Display again
        System.out.println("\nAfter Deletion:");
        service.displayStudents();
    }
}
