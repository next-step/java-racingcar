package step2;

import java.util.function.BiFunction;

public enum CalculatingProcess {
    PLUS("+", (parameter1, parameter2) -> parameter1 + parameter2),
    SUBTRACT("-", (parameter1, parameter2) -> parameter1 - parameter2),
    MULTIPLY("*", (parameter1, parameter2) -> parameter1 * parameter2),
    DIVIDE("/", (parameter1, parameter2) -> parameter1 / parameter2);

    final private String operand;
    final private BiFunction<Integer, Integer, Integer> calculation;

    CalculatingProcess(String operand, BiFunction<Integer, Integer, Integer> calculation) {
        this.operand = operand;
        this.calculation = calculation;
    }

    public String getOperand() {
        return operand;
    }

    public Integer getCalculation(Integer parameter1, Integer parameter2) {
        return calculation.apply(parameter1, parameter2);
    }
}
