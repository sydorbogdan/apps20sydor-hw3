import ua.edu.ucu.Student;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;
import ua.edu.ucu.Student;

public class test {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student copInpStudent = (Student) t;
                return copInpStudent.getGPA() >= 4;
            }
        };

        MyPredicate prYear = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student copInpStudent = (Student) t;
                return copInpStudent.getYear() == 2;
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                Student copInpStudent = (Student) t;
                return new Student(copInpStudent.getName(), copInpStudent.getSurname(), copInpStudent.getGPA(), 2*copInpStudent.getYear());
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student s1 = (Student) o1;
                Student s2 = (Student) o2;
                return s1.getSurname().compareTo(s2.getSurname());
            }
        };


        SmartArray sa = new BaseArray(students);
        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa, pr);
        sa = new FilterDecorator(sa, prYear);
        sa = new SortDecorator(sa, cmp);

        for (Object i : sa.toArray()) {
            System.out.println(i.toString());
        }
    }
}
