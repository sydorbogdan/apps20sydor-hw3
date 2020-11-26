package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    public FilterDecorator(SmartArray inpSmartArray, MyPredicate inpPredicate) {
        super(FilterDecorator.filter(inpSmartArray, inpPredicate));
    }

    private static SmartArray filter(SmartArray inpSmartArray,
                                     MyPredicate inpPredicate) {
        Object[] nonRepElem = new Object[inpSmartArray.size()];
        int lastUsed = -1;
        for (Object i : inpSmartArray.toArray()) {
            if (inpPredicate.test(i)) {nonRepElem[++lastUsed] = i;}
        }
        return new BaseArray(Arrays.copyOfRange(nonRepElem, 0, lastUsed + 1));
    }
}