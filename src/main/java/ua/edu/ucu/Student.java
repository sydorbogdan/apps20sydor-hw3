package ua.edu.ucu;


public class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
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
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object inpStudent) {
        Student copInpStudent = (Student) inpStudent;
        boolean eq = (this.GPA == copInpStudent.GPA)
                && (this.name.equals(copInpStudent.name))
                && (this.surname.equals(copInpStudent.surname))
                && (this.year == copInpStudent.year);
        return eq;
    }

}
