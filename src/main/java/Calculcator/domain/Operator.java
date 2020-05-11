package Calculcator.domain;

import java.util.function.ToDoubleBiFunction;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    MINUS("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> leftOperand / rightOperand);

    private final String symbol;
    private final ToDoubleBiFunction<Double, Double> operate;

    Operator(String symbol, ToDoubleBiFunction<Double, Double> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public static Operator findBySymbol(final String symbol) {
        validateNullOrEmpty(symbol);
        return Stream.of(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다. - " + symbol));
    }

    private static void validateNullOrEmpty(final String symbol) {
        if (symbol == null || symbol.trim().isEmpty()) {
            throw new IllegalArgumentException("Null 또는 공백 문자는 연산자가 될 수 없습니다.");
        }
    }

    public Operand compute(Operand leftOperand, Operand rightOperand) {
        validateDivideZero(rightOperand);

        double result = this.operate.applyAsDouble(leftOperand.getValue(), rightOperand.getValue());

        return new Operand(result);
    }

    private void validateDivideZero(Operand rightOperand) {
        if (this == Operator.DIVIDE && rightOperand.getValue() == 0) {
            throw new IllegalArgumentException("0 으로 나눌 수 없습니다.");
        }
    }
}
