package com.cheolhyeonpark.step2;

import java.util.List;

public class Expression {

    private List<Integer> numbers;
    private List<Operator> operators;

    public Expression(List<Integer> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
        validate();
    }

    private void validate() {
        if (!isRightExpression(numbers, operators)) {
            throw new IllegalArgumentException("Wrong input! Please check your input data.");
        }
    }

    private boolean isRightExpression(List<Integer> numbers, List<Operator> operators) {
        return numbers.size() - operators.size() == 1;
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operate(operators.get(i), result, numbers.get(i + 1));
        }
        return result;
    }

    private int operate(Operator operator, int a, int b) {
        return operator.operate(a, b);
    }
}
