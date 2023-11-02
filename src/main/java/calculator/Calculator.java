package calculator;

public class Calculator {
    private CalculationResult result;

    public int sum(Operands operands) {
        int result = 0;
        for (int operand : operands.operands()) {
            result += operand;
        }
        return new CalculationResult(result).result();
    }
}
