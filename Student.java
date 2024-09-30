public class Student {
    private String name;
    private int level;
    private int matricNumber;

    public Student(String name, int level, int matricNumber) {
        this.name = name;
        this.level = level;
        this.matricNumber = matricNumber;
    }

    // Getter method
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMatricNumber() {
        return matricNumber;
    }

    // Setter method
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMatricNumber(int matricNumber) {
        this.matricNumber = matricNumber;
    }


    // Override the toString method
    @Override
    public String toString() {
        return "Student Name: " + name + ", Level: " + level + ", Matric Number: " + matricNumber;
    }
}
