import java.util.*;

class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println("Id      : " + s.getId());
            System.out.println("Name    : " + s.getName());
            System.out.println("Age     : " + s.getAge());
            System.out.println("Course  : " + s.getCourse());
            System.out.println("Marks   : " + s.getMarks());
            System.out.println("Email   : " + s.getEmail());
            System.out.println("---------------------------");
        }
    }

    public Student searchStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
