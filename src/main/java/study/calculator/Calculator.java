package study.calculator;

import java.util.*;

public final class Calculator {
    private static Map<String, BiOperator> biOperatorMap = new HashMap<>();

    private String expression;

    static {
        Arrays.stream(BiOperator.values()).forEach(operator -> {
                biOperatorMap.put(operator.toString(), operator);
            }
        );
    }

    Calculator() { }

    Calculator(String expression) {
        this.expression = expression;
    }

    int calculate() {
        if (this.isValidExpression() == false) {
            throw new IllegalArgumentException();
        }

        StringTokenizer tokenizer = new StringTokenizer(expression, " ");

        if (tokenizer.countTokens() % 2 == 0) {
            throw new IllegalArgumentException();
        }

        Operand leftOperand = Operand.of(tokenizer.nextToken());
        String operator;
        Operand rightOperand;
        while (tokenizer.hasMoreTokens()) {
            operator = tokenizer.nextToken();
            rightOperand = Operand.of(tokenizer.nextToken());

            leftOperand = calculateBiOperand(leftOperand, operator, rightOperand);
        }

        return leftOperand.value;
    }

    int calculate(String expression) {
        // TODO: 상태를 멋대로 변경하는게 옳은걸까?
        this.expression = expression;
        return this.calculate();
    }

    boolean isValidExpression() {
        if (this.expression == null) {
            return false;
        }

        if (this.expression.trim() == "") {
            return false;
        }

        return true;
    }

    Operand calculateBiOperand(Operand leftOperand, String operator, Operand rightOperand) {
        return Optional.ofNullable(biOperatorMap.get(operator))
                .orElseThrow(() -> new IllegalArgumentException())
                .calculate(leftOperand, rightOperand);
    }
}
