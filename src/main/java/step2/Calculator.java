package step2;

public class Calculator {

    private final String SPACE = " ";

    public String[] splitInputValBySpace(String inputVal) throws IndexOutOfBoundsException{
        return inputVal.split(SPACE);
    }

    public int add(int firstVal, int secondVal){
        return firstVal + secondVal;
    }

    public int minus(int firstVal, int secondVal){
        return firstVal - secondVal;
    }

    public int multiply(int firstVal, int secondVal){
        return firstVal * secondVal;
    }

    public int devide(int firstVal, int secondVal){
        return firstVal / secondVal;
    }


}
