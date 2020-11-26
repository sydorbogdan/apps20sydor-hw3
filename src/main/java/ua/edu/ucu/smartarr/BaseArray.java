package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray  implements SmartArray{

    private Object[] arr;

    public BaseArray(Object[] inpArr){
        this.arr = inpArr;
    }

    @Override
    public Object[] toArray() {
        return this.arr;
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
