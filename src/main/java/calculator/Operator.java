package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    PLUS("+" , (firstOperand , secondOperand) -> firstOperand + secondOperand),
    MINUS("-" , (firstOperand , secondOperand) -> firstOperand - secondOperand),
    TIMES("*" , (firstOperand , secondOperand) -> firstOperand * secondOperand),
    DIVIDE("/" , (firstOperand , secondOperand) -> firstOperand / secondOperand);

    private final String sign;
    private final IntBinaryOperator functionalInterface;

    Operator(String sign, IntBinaryOperator functionalInterface) {
        this.sign = sign;
        this.functionalInterface = functionalInterface;
    }

    public static Operator valueOfOperator(String operator) {
        return Arrays.stream(values()).filter(op -> op.sign.equals(operator)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public int apply(int firstOperand, int secondOperand) {
        return functionalInterface.applyAsInt(firstOperand, secondOperand);
    }
}
