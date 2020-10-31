package step2;

public class Operator implements ExpressionFactor {

    private final char value;

    public Operator(String factor) {
        char ch =  factor.charAt(0);
        if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
            throw new IllegalArgumentException("연산자가 아님");
        }
        value = ch;
    }

    public char getValue() {
        return value;
    }
}
