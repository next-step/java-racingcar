package calculator;

public class DivideCalculator implements Calculator{
    @Override
    public float calculate(float dividend, float divisor) {
        return dividend / divisor;
    }
}
