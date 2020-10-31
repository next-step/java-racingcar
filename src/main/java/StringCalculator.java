public class StringCalculator {
    public int addition (int a, int b) {
        return a + b;
    }

    public int subtraction (int a, int b) {
        return a - b;
    }

    public int multiply (int a, int b) {
        return a * b;
    }

    public int division (int a, int b) {
        return a / b;
    }

    public boolean isNotBlank (String blank) {
        if ("".equals(blank) || " ".equals(blank)) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public boolean isOperator (String operator) {
        if (!"+".equals(operator) && !"-".equals(operator) && !"*".equals(operator) && !"/".equals(operator)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int calculator (int a, String operator, int b) {
        int result = 0;

        if ("+".equals(operator)) {
            result = addition(a, b);
        }
        if ("-".equals(operator)) {
            result = subtraction(a, b);
        }
        if ("*".equals(operator)) {
            result = multiply(a, b);
        }
        if ("/".equals(operator)) {
            result = division(a, b);
        }

        return result;
    }
}
