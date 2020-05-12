package calculator;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import utils.IntegerUtil;

public enum Operator {
    PLUS("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    MINUS("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> leftOperand / rightOperand);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;
    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator findOperator(String symbol) {
        validateNullOrEmpty(symbol);

        return Stream.of(Operator.values())
            .filter(operator -> operator.symbol.equals(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 기호입니다. 사칙 연산 기호을 입력해주세요. " + symbol));
    }

    private static void validateNullOrEmpty(String value) {
        if(Objects.isNull(value) || value.isEmpty()) {
            throw new IllegalArgumentException("Null 또는 공백 문자는 연산자가 될 수 없습니다.");
        }
    }

    public Operand operate(Operand leftOperand, Operand rightOperand) {
        validateDivideByZero(rightOperand);
        int result = this.expression.apply(leftOperand.getValue(), rightOperand.getValue());

        return Operand.of(result);
    }

    private void validateDivideByZero(Operand rightOperand) {
        if (this == Operator.DIVIDE & IntegerUtil.isZero(rightOperand.getValue())) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
