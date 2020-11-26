package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray inpSmartArray) {
        super(DistinctDecorator.rmDist(inpSmartArray));
    }

    private static SmartArray rmDist(SmartArray inpSmartArray) {
        Object[] nonRepElem = new Object[inpSmartArray.size()];
        int lastUsed = -1;
        for (Object i : inpSmartArray.toArray()) {
            int j = 0;
            for (; j < lastUsed + 1; j++) {
                if (i.equals(nonRepElem[j])) {break; }
            }
            if (j == lastUsed + 1) {nonRepElem[++lastUsed] = i; }
        }
        return new BaseArray(Arrays.copyOfRange(nonRepElem, 0, lastUsed + 1));
    }
}
