package step2;

public class Exceptions {
    final String[] ARITHMETIC_EXPRESSION = {"+", "-", "/", "*"};

    public boolean isStringEmpty(String testingValue) {
        try {
            if (testingValue.isBlank()) {
                throw new IllegalArgumentException("문자열이 공백 혹은 비어있습니다.");
            }

            return false;
        } catch (IllegalArgumentException exception) {

            System.err.println(exception.getMessage());
            return true;
        }
    }

    public boolean isArithmeticExpression(String testingValue) {
        boolean result = false;

        try {
            for (String expression : ARITHMETIC_EXPRESSION) {
                if (testingValue.equals(expression)) {
                    result = true;
                    break;
                }
            }
            if (!result) {
                throw new IllegalArgumentException("사칙연산이 아니에요.");
            }

            return true;
        } catch (IllegalArgumentException exception) {

            System.err.println(exception.getMessage());
            return false;
        }
    }
}
