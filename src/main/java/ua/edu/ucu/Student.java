package ua.edu.ucu;


public class Student {

    private double gPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double inpGPA, int year) {
        this.gPA = inpGPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return gPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname="
                + surname + ", " + "GPA=" + gPA + ","
                + " year=" + year + '}';
    }

    @Override
    public boolean equals(Object inpStudent) {
        Student copInpStudent = (Student) inpStudent;
        boolean eq = (this.gPA == copInpStudent.gPA)
                && (this.name.equals(copInpStudent.name))
                && (this.surname.equals(copInpStudent.surname))
                && (this.year == copInpStudent.year);
        return eq;
    }

}
