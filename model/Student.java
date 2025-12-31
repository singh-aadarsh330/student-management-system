class Student {
    private int id;
    private int marks;
    private int age;
    private String name;
    private String course;
    private String email;

    // Default constructor
    Student() {
        this.id = 0;
        this.marks = 0;
        this.age = 0;
        this.name = "";
        this.course = "";
        this.email = "";
    }

    // Parameterized constructor (VERY useful later)
    Student(int id, String name, int age, String course, int marks, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
