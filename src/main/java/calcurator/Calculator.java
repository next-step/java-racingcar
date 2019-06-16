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

    public static boolean isValidSign(String str) {
        return Sign.getSignValues().contains(str);

    }

    public static int calculrate(String operation, int a, int b) {
        if (!isValidSign(operation)) {
            throw new IllegalArgumentException();
        }

        if (operation.equals(Sign.ADD.getSign())) return add(a, b);
        if (operation.equals(Sign.SUBTRACT.getSign())) return subtract(a, b);
        if (operation.equals(Sign.MULTIPLY.getSign())) return multiply(a, b);
        if (operation.equals(Sign.DIVISION.getSign())) return division(a, b);
        return 0;
    }
}
