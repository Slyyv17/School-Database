import java.util.ArrayList;
import java.util.Scanner;

public class School {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a database to store students info
        ArrayList<Student> studentDatabase = new ArrayList<>();

        System.out.println("Enter the number of students: ");
        int studentSize = sc.nextInt();
        sc.nextLine();  // Consume newline

        for (int i = 0; i < studentSize; i++) {
            System.out.println("Enter name of student: ");
            String name = sc.nextLine();

            // Validate student level
            System.out.println("Enter student level: ");
            int level = sc.nextInt();

            if (level != 100 && level != 200 && level != 300 && level != 400 && level != 500 && level != 600) {
                System.out.println("Invalid Level. Program will terminate.");
                System.exit(0);  // Terminate program if invalid level is entered
            }
            sc.nextLine();  // Consume newline

            // Validate matric number
            System.out.println("Enter Matric number: ");
            int matricNumber = sc.nextInt();

            if (matricNumber < 180000 || matricNumber > 235000) {
                System.out.println("Invalid Matric Number. Program will terminate.");
                System.exit(0);  // Terminate program if invalid matric number is entered
            }
            sc.nextLine();  // Consume newline

            // Feature: Add the student's info to the database
            studentDatabase.add(new Student(name, level, matricNumber));
        }

        // Display all valid student data
        System.out.println("\n----- Student Database -----");
        for (Student student : studentDatabase) {
            System.out.println(student);  // Uses the overridden toString() method
        }

        // Feature: Removing a student
        System.out.println("\nDo you want to delete a student’s information? (yes/no)");
        String options = sc.nextLine();

        if (options.equalsIgnoreCase("yes")) {
            System.out.println("Enter the Matric number of the student to remove: ");
            int matricNumberToRemove = sc.nextInt();
            boolean studentRemoved = false;

            // Find the student with the matching matric number and remove them
            for (Student student : studentDatabase) {
                if (student.getMatricNumber() == matricNumberToRemove) {
                    studentDatabase.remove(student);
                    System.out.println("Student with Matric number " + matricNumberToRemove + " removed.");
                    studentRemoved = true;
                    break;
                }
            }

            if (!studentRemoved) {
                System.out.println("No student found with that Matric number.");
            }
        } else {
            System.out.println("No student removed. Continuing...");
        }

        // Display updated student data
        System.out.println("\n----- Updated Student Database -----");
        for (Student student : studentDatabase) {
            System.out.println(student);  // Uses the overridden toString() method
        }
    }
}
