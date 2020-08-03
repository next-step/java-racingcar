package step2;

public class Operation {

    private static final String[] OPERATORS = {"+", "-", "*", "/"};

    public Operation() {
    }

    public int calculate(String expression) throws IllegalArgumentException {

        String[] ops = expression.split(" ");

        Integer operand = convert(ops[0]);
        String operator = null;
        for (int i = 1; i < ops.length; i++) {
            if (operator == null) {
                operator = ops[i];
                continue;
            }

            Integer value = convert(ops[i]);
            if (operand != null && operator != null) {
                operand = getValue(operator, operand, value);
                operator = null;
            }
        }

        return operand;
    }

    private int convert(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input number is null or empty");
        }
        return Integer.parseInt(s);
    }

    private int getValue(String operator, int a, int b) {
        switch (operator) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Possible operators are [" + OPERATORS + "]");
        }
    }

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by 0.");
        }
        return a / b;
    }
}
