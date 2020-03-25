package calculator.operator;

import calculator.exception.OperatorNotFoundException;

import java.util.Arrays;

public enum OperatorEnum {

    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> round(operand1 * operand2)),
    DIVISION("/", (operand1, operand2) -> round(operand1 / operand2));

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
                .orElseThrow(() -> new OperatorNotFoundException("일치하는 연산자를 찾을 수 없습니다."));
    }

    public static double round(double number) {
        return Math.round(number * 100) / 100.0;
    }
}
