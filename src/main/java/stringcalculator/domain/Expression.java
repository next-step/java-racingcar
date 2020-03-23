package stringcalculator.domain;

import java.util.Objects;

public class Expression {
    private String[] expressions;

    private Numbers numbers;
    private Operators operators;

    public Expression(String source) {
        if (isEmpty(source)) {
            throw new IllegalArgumentException(Constant.NOT_NULL);
        }
        this.expressions = source.split(Constant.BLANK);
        numbers = new Numbers(expressions);
        operators = new Operators(expressions);
    }

    public Double calculate() {
        double leftNumber = numbers.get();
        while (numbers.hasNext()) {
            leftNumber = Calculator.calculate(operators.get(), leftNumber, numbers.get());
        }
        return leftNumber;
    }

    private boolean isEmpty(String source) {
        return Objects.isNull(source) || Constant.NULL_STRING.equals(source.trim());
    }

}
