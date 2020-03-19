package study.calculator;

public class Calculator {
    private Operator operator;

    Calculator() {
        operator = new Operator();
    }

    public Integer calculate(String expression) throws IllegalArgumentException {
        expression = expression.trim();
        if(expression.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] parts = expression.split(" ");
        if(parts.length < 3) {
            throw new IllegalArgumentException();
        }
        Integer result = Integer.parseInt(parts[0]);
        for (int i = 2; i < parts.length; i = i + 2) {
            result = operate(parts[i-1], result, Integer.parseInt(parts[i]));
        }

        return result;
    }

    private Integer operate(String stringOperator, Integer leftSide, Integer rightSide) {
        if ("+".equals(stringOperator)) return operator.plus(leftSide, rightSide);
        else if ("-".equals(stringOperator)) return operator.minus(leftSide, rightSide);
        else if ("/".equals(stringOperator)) return operator.divide(leftSide, rightSide);
        else if ("*".equals(stringOperator)) return operator.multiply(leftSide, rightSide);

        throw new IllegalArgumentException();
    }
}
