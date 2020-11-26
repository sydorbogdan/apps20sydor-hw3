package ua.edu.ucu;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andrii_Rodionov
 */
public class SmartArrayAppTest {

    @Test
    public void testFilterPositiveIntegersSortAndMultiplyBy2() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};

        Integer[] res =
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyByTwo(integers);
        Integer[] expectedRes = {2, 4, 6};

        assertArrayEquals(expectedRes, res);
    }

    @Test
    public void testFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames =
                SmartArrayApp.findDistinctStudentNamesFromSecondYearWithGPAgtAndOrderedBySurname(students, 4);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Sutter Burr"};
        for (Object i : studentNames){
            System.out.println(i);
        }
        assertArrayEquals(expectedStudentNames, studentNames);
    }


    @Test
    public void testStudent() {
        SmartArrayApp test = new SmartArrayApp();
        Student studentOne = new Student("Ivar", "Grimstad", 3.9, 2);
        Student studentTwo = new Student("Philipp", "Krenn", 4.3, 3);
        assertEquals("Student{name=Ivar, surname=Grimstad, GPA=3.9, year=2}", studentOne.toString());
        assertEquals(false, studentOne.equals(null));
        assertEquals(false, studentOne.equals(new Object()));
        assertEquals(false, studentOne.equals(studentTwo));
    }


    @Test(expected = AssertionError.class)
    public void tesStudentHashCode() {
        Student studentTwo = new Student("Philipp", "Krenn", 4.3, 3);
        System.out.println(studentTwo.hashCode());
    }
}