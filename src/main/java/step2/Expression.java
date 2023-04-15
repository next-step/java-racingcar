package step2;

public class Expression {

    private final String expression;
    private final String delimiter;

    public Expression(String expression, String delimiter) {
        this.expression = expression;
        this.delimiter = delimiter;
    }

    public String[] split() {
        return expression.split(delimiter);
    }
}
