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

        if (operation.equals(Operation.ADD.getOperation())) return add(a, b);
        if (operation.equals(Operation.SUBTRACT.getOperation())) return subtract(a, b);
        if (operation.equals(Operation.MULTIPLY.getOperation())) return multiply(a, b);
        if (operation.equals(Operation.DIVISION.getOperation())) return division(a, b);
        return 0;
    }
}
