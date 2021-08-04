package stage2;

public class Calculator {
    public Integer calculate(String input) {
        inputValidate(input);
        final Expression ep = parse(input);
        return ep.express();
    }

    private void inputValidate(String input) {
        if (" ".equals(input) || "".equals(input) || input == null) {
            throw new IllegalArgumentException("잘못된 입력값 입니다 => " + input);
        }
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
