package calculator;

public class Calculator {
    private final Expression expression;

    public Calculator(Expression expression) {
        this.expression = expression;
    }

    public Long calculate() {
        Long resultNum = Long.parseLong(expression.of(0));
        for(int i = 1; i < expression.length() - 1; i = i + 2) {
            resultNum = calculate(expression.of(i), resultNum, Long.parseLong(expression.of(i + 1)));
        }
        return resultNum;
    }

    private Long calculate(String operator, Long num1, Long num2) {
        return Operation.of(operator).calculate(num1, num2);

    }
}
