package ua.edu.ucu.smartarr;


import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;
import java.util.Comparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    public SortDecorator(SmartArray smartArray, MyComparator inpComp) {
        super(SortDecorator.sort(smartArray, inpComp));
    }

    private static SmartArray sort(SmartArray inpSmartArray,
                                   MyComparator inpComp) {
        Object[] cop = inpSmartArray.toArray();
        Arrays.sort(cop, new Comparator<Object>() {
            @Override
            public int compare(Object firstStudent, Object secondStudent) {
                return inpComp.compare(firstStudent, secondStudent);
            }
        });
        return new BaseArray(cop);
    }

    @Override
    public String operationDescription() {
        return "Sorts elements using MyComparator to compare them";
    }

}
