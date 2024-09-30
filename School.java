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

        // Input student details
        for (int i = 0; i < studentSize; i++) {
            System.out.println("Enter name of student: ");
            String name = sc.nextLine();

            int level = getValidLevel(sc);
            int matricNumber = getValidMatricNumber(sc);

            // Add the student's info to the database
            studentDatabase.add(new Student(name, level, matricNumber));
        }

        // Display all valid student data
        displayStudents(studentDatabase);

        // Menu for editing, deleting, or adding students
        System.out.println("\n-----------------------------");
        System.out.println("Do you want to make changes? (yes/no)");
        if (sc.nextLine().equalsIgnoreCase("yes")) {

            System.out.println("1. Delete Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Add Student");

            int selection = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (selection) {
                case 1:  // Delete Student
                    deleteStudent(sc, studentDatabase);
                    break;

                case 2:  // Edit Student
                    editStudent(sc, studentDatabase);
                    break;

                case 3:  // Add New Student
                    addStudent(sc, studentDatabase);
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } else {
            System.out.println("No changes made. Exiting...");
        }

        // Display updated student data
        displayStudents(studentDatabase);
    }

    private static void displayStudents(ArrayList<Student> studentDatabase) {
        System.out.println("\n----- Student Database -----");
        for (Student student : studentDatabase) {
            System.out.println(student);  // Uses the overridden toString() method
        }
    }

    // Method to delete a student by matric number
    private static void deleteStudent(Scanner sc, ArrayList<Student> studentDatabase) {
        System.out.println("Enter the Matric number of the student to remove: ");
        int matricNumberToRemove = sc.nextInt();
        sc.nextLine();  // Consume newline
        boolean studentRemoved = false;

        // Find and remove the student
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
    }

    // Method to edit a student's information
    private static void editStudent(Scanner sc, ArrayList<Student> studentDatabase) {
        System.out.println("Enter the Matric number of the student to edit: ");
        int matricNumberToEdit = sc.nextInt();
        sc.nextLine();  // Consume newline
        boolean studentFound = false;

        // Find and edit the student
        for (Student student : studentDatabase) {
            if (student.getMatricNumber() == matricNumberToEdit) {
                System.out.println("Editing student: " + student);

                // Prompt for new name
                System.out.println("Enter new name (or press Enter to keep " + student.getName() + "): ");
                String newName = sc.nextLine();
                if (!newName.isEmpty()) {
                    student.setName(newName);
                }

                // Prompt for new level
                System.out.println("Enter new level (or press Enter to keep " + student.getLevel() + "): ");
                String newLevelInput = sc.nextLine();
                if (!newLevelInput.isEmpty()) {
                    int newLevel = Integer.parseInt(newLevelInput);
                    student.setLevel(newLevel);
                }

                // Prompt for new matric number
                System.out.println("Enter new matric number (or press Enter to keep " + student.getMatricNumber() + "): ");
                String newMatricInput = sc.nextLine();
                if (!newMatricInput.isEmpty()) {
                    int newMatricNumber = Integer.parseInt(newMatricInput);
                    student.setMatricNumber(newMatricNumber);
                }

                System.out.println("Student information updated.");
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("No student found with that Matric number.");
        }
    }

    // Method to add a new student to the database
    private static void addStudent(Scanner sc, ArrayList<Student> studentDatabase) {
        System.out.println("Enter name of student: ");
        String name = sc.nextLine();

        int level = getValidLevel(sc);
        int matricNumber = getValidMatricNumber(sc);

        // Add new student to the database
        studentDatabase.add(new Student(name, level, matricNumber));
        System.out.println("New student added.");
    }

    // Method to get a valid student level
    private static int getValidLevel(Scanner sc) {
        int level;
        while (true) {
            System.out.println("Enter student level: ");
            level = sc.nextInt();
            sc.nextLine();  // Consume newline
            if (level == 100 || level == 200 || level == 300 || level == 400 || level == 500 || level == 600) {
                break;
            } else {
                System.out.println("Invalid Level. Please enter a valid level (100, 200, 300, 400, 500, 600).");
            }
        }
        return level;
    }

    // Method to get a valid matric number
    private static int getValidMatricNumber(Scanner sc) {
        int matricNumber;
        while (true) {
            System.out.println("Enter Matric number: ");
            matricNumber = sc.nextInt();
            sc.nextLine();  // Consume newline
            if (matricNumber >= 180000 && matricNumber <= 235000) {
                break;
            } else {
                System.out.println("Invalid Matric Number. Please enter a valid matric number (between 180000 and 235000).");
            }
        }
        return matricNumber;
    }
}
