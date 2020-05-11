package calculator;

public class PlusCalculator implements Calculator {

    @Override
    public float calculate(float operand1, float operand2) {
        return operand1 + operand2;
    }
}
