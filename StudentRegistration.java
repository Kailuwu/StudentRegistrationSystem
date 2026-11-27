import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {

    static class Student {
        private final String name;
        private final int age;
        private final double grade;

        public Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("Name: %s | Age: %d | Grade: %.2f,", name, age, grade);
        }
    }

    public static final List<Student> students = new ArrayList<>();

    public static boolean addStudent(String name, int age, double grade) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Student name cannot be empty or null.");
            return false;
        }

        if (age < 5 || age > 120) {
            System.out.println("Error: Age must be between 5 and 120.");
            return false;
        }

        if (Double.isNaN(grade) || grade < 0 || grade > 100) {
            System.out.println("Error: Grade must be between 0 and 100.");
            return false;
        }

        String cleanName = name.trim();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(cleanName)) {
                System.out.println("Error: Student '" + cleanName + "' is already registered.");
                return false;
            }
        }

        Student newStudent = new Student(cleanName, age, grade);
        students.add(newStudent);
        System.out.println("Student Added! ->" + newStudent);
        return true;
    }

    public static void displayStudents() {
        System.out.println("\n--- Registered Students---");
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        addStudent("", 20, 85);
        addStudent("John", -5, 85);
        addStudent("John", 20, 150);
        addStudent("Maria", 21, 90);
        addStudent("Maria", 21, 90);

        displayStudents();
    }
}