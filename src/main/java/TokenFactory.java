public class TokenFactory {

    public static Token buildToken(String rawValue) {
        try {
            int value = Integer.parseInt(rawValue);
            return new Operand(value);
        } catch (NumberFormatException e) {
            // do nothing
        }

        return buildOperator(rawValue);
    }

    private static Token buildOperator(String rawValue) {
        if ("+".equals(rawValue)) {
            return new AddOperator();
        }
        if ("-".equals(rawValue)) {
            return new SubOperator();
        }
        if ("*".equals(rawValue)) {
            return new MultiplyOperator();
        }
        if ("/".equals(rawValue)) {
            return new DivideOperator();
        }
        throw new IllegalArgumentException("숫자도 아니고 사칙연산도 아니고 이거 뭔가요 : " + rawValue);
    }
}
