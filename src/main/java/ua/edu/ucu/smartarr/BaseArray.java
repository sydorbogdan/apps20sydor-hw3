package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] arr;

    public BaseArray(Object[] inpArr) {
        this.arr = Arrays.copyOf(inpArr, inpArr.length);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arr, this.arr.length);
    }

    @Override
    public String operationDescription() {
        return "Base class for wrappers";
    }

    @Override
    public int size() {
        return this.arr.length;
    }
}
