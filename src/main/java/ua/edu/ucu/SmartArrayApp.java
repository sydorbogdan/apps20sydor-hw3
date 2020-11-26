package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.MapDecorator;


public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyByTwo(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object first, Object second) {
                return ((Integer) first) - ((Integer) second);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]

        SmartArray sa = new BaseArray(integers);


        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFromSecondYearWithGPAgt4AndOrderedBySurname(Student[] students) {
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
                return new Student(copInpStudent.getName(),
                        copInpStudent.getSurname(),
                        copInpStudent.getGPA(),
                        2 * copInpStudent.getYear());
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object first, Object second) {
                Student firstStud = (Student) first;
                Student secondStud = (Student) second;
                return firstStud.getSurname().compareTo(secondStud
                        .getSurname());
            }
        };


        SmartArray sa = new BaseArray(students);
        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa, pr);
        sa = new FilterDecorator(sa, prYear);
        sa = new SortDecorator(sa, cmp);
        Object[] arr = sa.toArray();
        String[] rezArr = new String[sa.size()];
        for (int i = 0; i < sa.size(); i++) {
            rezArr[i] = ((Student) arr[i]).getSurname() + " " + ((Student) arr[i]).getName();
        }
        return rezArr;
    }
}
