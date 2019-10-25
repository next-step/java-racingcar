package calculator;

public class StringCalculator {

    public int calculate(int a, int b, String calculate) {
        if ("+".equals(calculate)) {
            return add(a, b);
        }
        if ("-".equals(calculate)) {
            return subtract(a, b);
        }
        if ("*".equals(calculate)) {
            return multiply(a, b);
        }
        return division(a, b);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        return a / b;
    }
}
