package study.calculator;

public final class Calculator {
    private String expression;
    ExpressionTokenizer tokenizer;

    Calculator() { }

    Calculator(String expression) {
        this.expression = expression;
        this.tokenizer = new ExpressionTokenizer(expression);
    }

    int calculate() {
        Operand operand = null;

        while (tokenizer.hasMoreTokens()) {
            operand = tokenizer.nextToken();
        }

        return operand.value;
    }
}
