package stage2;

public class Calculator {
    public int calculate(String input) {
        int result = 0;
        validateInputString(input);
        final String[] data = expressionSplit(input);
        try {
            final Expression ep = new Expression(data);
            result = ep.express();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

    private void validateInputString(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private boolean isBlank(String input) {
        return " ".equals(input) || "".equals(input) || input == null;
    }

    private String[] expressionSplit(String expression) {
        return expression.split(" ");
    }
}
