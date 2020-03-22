package calculator.operator;

import java.util.Arrays;

public enum OperatorEnum {

    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> {
        double result = operand1 * operand2;
        return Math.round(result * 100) / 100.0;
    }),
    DIVISION("/", (operand1, operand2) -> {
        double result = operand1 / operand2;
        return Math.round(result * 100) / 100.0;
    });

    private String keyword;
    Calculatable calculatable;

    OperatorEnum(String keyword, Calculatable calculatable) {
        this.keyword = keyword;
        this.calculatable = calculatable;
    }

    public String getKeyword() {
        return keyword;
    }

    public double calculate(double operand1, double operand2) {
        return this.calculatable.calculate(operand1, operand2);
    }

    public static OperatorEnum getOperatorEnumFromKeyword(String operatorKeyword) {
        return Arrays.stream(values())
                .filter(operator -> operator.getKeyword().equals(operatorKeyword))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("수식 중 사칙연산 기호가 잘못되었습니다."));
    }
}
