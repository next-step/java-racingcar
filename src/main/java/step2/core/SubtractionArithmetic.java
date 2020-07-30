package step2.core;

public class SubtractionArithmetic implements Arithmetic{
    @Override
    public int calculate(int firstVal, int secondVal) {
        return firstVal - secondVal;
    }
}
