package stage2;

public class Calculator {
    public int calculate(String input) {
        int result = 0;
        inputValidate(input);
        final String[] data = expressionSplit(input);
        try {
            final Expression ep = new Expression(data);
            result = ep.express();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return result;
    }

    private void inputValidate(String input) {
        if (" ".equals(input) || "".equals(input) || input == null)
            throw new IllegalArgumentException("잘못된 입력값 입니다 => " + input);
    }

    private String[] expressionSplit(String expression) {
        return expression.split(" ");
    }
}
