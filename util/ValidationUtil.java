class ValidationUtil {

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean isValidMarks(int marks) {
        return marks >= 0 && marks <= 100;
    }

    public static boolean isValidAge(int age) {
        return age >= 16 && age <= 60;
    }
}
