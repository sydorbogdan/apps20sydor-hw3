package ua.edu.ucu.smartarr;

import ua.edu.ucu.Student;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;
import java.util.Comparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    public SortDecorator(SmartArray smartArray, MyComparator inpComp) {
        super(SortDecorator.sort(smartArray, inpComp));
    }

    private static SmartArray sort(SmartArray inpSmartArray, MyComparator inpComp) {
        Object[] cop = inpSmartArray.toArray();
        Arrays.sort(cop, new Comparator<Object>() {
            @Override
            public int compare(Object s1, Object s2) {
                return inpComp.compare(s1, s2);
            }
        });
        return new BaseArray(cop);
    }

}
