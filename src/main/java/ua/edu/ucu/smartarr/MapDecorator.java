package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;


// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    public MapDecorator(SmartArray smartArray,
                        MyFunction inpFunc) {
        super(MapDecorator.filter(smartArray, inpFunc));
    }

    private static SmartArray filter(SmartArray inpSmartArray,
                                     MyFunction inpFunction) {
        Object[] nonRepElem = new Object[inpSmartArray.size()];
        int lastUsed = -1;
        for (Object i : inpSmartArray.toArray()) {
            nonRepElem[++lastUsed] = inpFunction.apply(i);
        }
        return new BaseArray(nonRepElem);
    }

    @Override
    public String operationDescription() {
        return "Map every element to another object using MyFunction";
    }
}
