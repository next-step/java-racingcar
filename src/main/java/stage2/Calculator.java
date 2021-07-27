package stage2;

public class Calculator {
    public Integer calculate(String input) {
        if (" ".equals(input) || "".equals(input) || input == null) {
            throw new IllegalArgumentException();
        }

        final Expression ep = parse(input);
        return ep.express();
    }

    private Expression parse(String text) {
        String[] data = expressionSplit(text);
        Integer init = Integer.parseInt(data[0]);

        return new Expression(data, init);
    }

    private String[] expressionSplit(String expression) {
        return expression.split(" ");
    }
}
