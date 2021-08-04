package stage2;

public class Calculator {
    public Integer calculate(String input) {
        inputValidate(input);
        final String[] data = expressionSplit(input);
        final Expression ep = new Expression(data);
        return ep.express();
    }

    private void inputValidate(String input) {
        if (" ".equals(input) || "".equals(input) || input == null)
            throw new IllegalArgumentException("잘못된 입력값 입니다 => " + input);
    }

    private String[] expressionSplit(String expression) {
        return expression.split(" ");
    }
}
