public class Student {
    private String name;
    private int level;
    private int matricNumber;

    public Student(String name, int level, int matricNumber) {
        this.name = name;
        this.level = level;
        this.matricNumber = matricNumber;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMatricNumber() {
        return matricNumber;
    }

    // Override the toString method
    @Override
    public String toString() {
        return "Student Name: " + name + ", Level: " + level + ", Matric Number: " + matricNumber;
    }
}
