package domain;

public class Calculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLE = "*";

    private long result;

    private Calculator() {
        this.result = 0;
    }

    public static Calculator of() {
        return new Calculator();
    }
}
