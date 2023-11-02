package calculator;

public class Calculator {
    public static int sum(Operands operands) {
        int result = 0;
        for (int operand : operands.operands()) {
            result += operand;
        }
        return result;
    }
}
