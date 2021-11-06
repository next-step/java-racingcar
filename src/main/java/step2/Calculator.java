package step2;

public class Calculator {

    public static int calculate(String text) {
        final String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        String operator = values[1];
        int second = Integer.parseInt(values[2]);

        if (operator.equals("+")) {
            return Calculator.add(first, second);
        } else if (operator.equals("-")) {
            return Calculator.sub(first, second);
        } else if (operator.equals("*")) {
            return Calculator.mul(first, second);
        } else if (operator.equals("/")) {
            return Calculator.div(first, second);
        }

        return 0;
    }

    private static int div(int first, int second) {
        return first / second;
    }

    private static int mul(int first, int second) {
        return first * second;
    }

    private static int sub(int first, int second) {
        return first - second;
    }

    public static int add(int first, int second) {
        return first + second;
    }

}
