import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super("Error :- CourseFullException - " + message);
    }
}
class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super("Error :- PrerequisiteNotMetException - " + message);
    }
}

class Course {
    private String name;
    private String prerequisite;
    private int capacity;
    private int enrolledStudents;

    public Course(String name, String prerequisite, int capacity) {
        this.name = name;
        this.prerequisite = prerequisite;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }

    public String getName() {
        return name;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void enrollStudent(boolean prerequisiteCompleted) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents >= capacity) {
            throw new CourseFullException("The Course " + name + " is Already Full.");
        }
        if (!prerequisiteCompleted && prerequisite != null && !prerequisite.isEmpty()) {
            throw new PrerequisiteNotMetException("Complete " + prerequisite + " Before Enrolling in " + name + ".");
        }
        enrolledStudents++;
        System.out.println("Enrollment Successful! You are Enrolled in " + name);
    }
}

public class E3C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Course Name :- ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Prerequisite Course (If Any, Else Leave Empty) :- ");
        String prerequisite = scanner.nextLine();

        System.out.print("Enter Course Capacity :- ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Course course = new Course(courseName, prerequisite, capacity);

        System.out.print("Have you Completed the Prerequisite (Yes/No)?: ");
        String prerequisiteStatus = scanner.nextLine();
        boolean prerequisiteCompleted = prerequisiteStatus.equalsIgnoreCase("Yes");

        try {
            course.enrollStudent(prerequisiteCompleted);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}