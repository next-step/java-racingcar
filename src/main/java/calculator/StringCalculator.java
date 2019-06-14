package calculator;

public class StringCalculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public boolean isNotEmpty(String s) {
        if (s == null || "".equals(s.trim())) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isOperation(String s) {
        if (!"+-*/".contains(s)) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
