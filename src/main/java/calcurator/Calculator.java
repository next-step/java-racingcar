package calcurator;


public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static int calculate(String operation, int a, int b) {
        if (!Operation.isValidOperation(operation)) {
            throw new IllegalArgumentException();
        }

        if (Operation.ADD.getOperation().equals(operation)) return add(a, b);
        if (Operation.SUBTRACT.getOperation().equals(operation)) return subtract(a, b);
        if (Operation.MULTIPLY.getOperation().equals(operation)) return multiply(a, b);
        if (Operation.DIVISION.getOperation().equals(operation)) return division(a, b);
        return 0;
    }
}
