public class Token {

    private static final String AVAILABLE_OPERATORS = "+ - * /";

    private String value;

    public Token(String rawToken) {
        value = rawToken;
    }

    public boolean isNumber() {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Integer getNumber() {
        if (isNumber()) {
            return Integer.valueOf(value);
        }
        return null;
    }

    public boolean isOperator() {
        if (isNumber()) {
            return false;
        }
        if (AVAILABLE_OPERATORS.contains(value)) {
            return true;
        }

        throw new IllegalArgumentException("숫자도 아니고 사칙연산도 아니고 이거 뭔가요 : " + value);
    }

    public String getOperator() {
        if (isOperator()) {
            return value;
        }
        return null;
    }

}
