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

        // Collect student data
        for (int i = 0; i < studentSize; i++) {
            System.out.println("Enter name of student: ");
            String name = sc.nextLine();

            // Validate student level
            System.out.println("Enter student level: ");
            int level = sc.nextInt();

            if (level != 100 && level != 200 && level != 300 && level != 400 && level != 500 && level != 600) {
                System.out.println("Invalid Level. Program will terminate.");
                System.exit(0);
            }
            sc.nextLine();  // Consume newline

            // Validate matric number
            System.out.println("Enter Matric number: ");
            int matricNumber = sc.nextInt();

            if (matricNumber < 180000 || matricNumber > 235000) {
                System.out.println("Invalid Matric Number. Program will terminate.");
                System.exit(0);
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

        // Forever loop for changes
        while (true) {
            System.out.print("\nDo you want to make changes? (yes/no): ");
            String choice = sc.nextLine();

            // If the user says "no", break the loop and exit
            if (choice.equalsIgnoreCase("no")) {
                System.out.println("Exiting program...");
                break;  // Exit the loop
            }

            // Display options for editing, deleting, or adding students
            System.out.println("\n1. Delete Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Add Student");

            int selection = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (selection) {
                case 1: // Deleting a student
                    System.out.println("Enter the Matric number of the student to remove: ");
                    int matricNumberToRemove = sc.nextInt();
                    sc.nextLine();

                    boolean studentRemoved = false;
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
                    break;

                case 2: // Editing a student
                    System.out.println("Enter the Matric number of the student to edit: ");
                    int matricNumberToEdit = sc.nextInt();
                    sc.nextLine();

                    boolean studentFound = false;
                    for (Student student : studentDatabase) {
                        if (student.getMatricNumber() == matricNumberToEdit) {
                            System.out.println("Enter new name of student: ");
                            String newName = sc.nextLine();

                            System.out.println("Enter new level: ");
                            int newLevel = sc.nextInt();
                            sc.nextLine();  // Consume newline

                            System.out.println("Enter new Matric number: ");
                            int newMatricNumber = sc.nextInt();
                            sc.nextLine();  // Consume newline

                            // Update student info
                            student.setName(newName);
                            student.setLevel(newLevel);
                            student.setMatricNumber(newMatricNumber);
                            System.out.println("Student details updated.");
                            studentFound = true;
                            break;
                        }
                    }
                    if (!studentFound) {
                        System.out.println("No student found with that Matric number.");
                    }
                    break;

                case 3: // Adding a new student
                    System.out.println("Enter name of new student: ");
                    String newName = sc.nextLine();

                    System.out.println("Enter student level: ");
                    int newLevel = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Matric number: ");
                    int newMatricNumber = sc.nextInt();
                    sc.nextLine();

                    studentDatabase.add(new Student(newName, newLevel, newMatricNumber));
                    System.out.println("New student added.");
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }

            // Display updated student data
            System.out.println("\n----- Updated Student Database -----");
            for (Student student : studentDatabase) {
                System.out.println(student);
            }
        }
    }
}