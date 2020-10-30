public class Token {

    private String value;
    private static final String AVAILABLE_OPERATORS = "+ - * /";

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
        return AVAILABLE_OPERATORS.contains(value);
    }

    public String getOperator() {
        if (isOperator()) {
            return value;
        }
        return null;
    }

}
