
public class Calculator {

    public int calculate(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return splitAndCalculate(input);
    }

    private static int splitAndCalculate(String input) {
        String[] split = split(input);
        int result = toInts(split[0]);
        for (int i = 0; i < split.length - 2; i += 2) {
            result = operate(result, toInts(split[i + 2]), split[i + 1]);
        }
        return result;
    }


    private static int toInts(String value) {
        int intValue = Integer.parseInt(value);
        if (intValue < 0) {
            throw new IllegalStateException("input should be greater than 0");
        }
        return intValue;
    }

    private static boolean isBlank(String input) {
        return input == null;
    }


    private static int operate(int a, int b, String operation) {
        switch (operation) {
            case "+": return sum(new int[]{a, b});
            case "-": return minus(new int[]{a, b});
            case "*": return multiply(new int[]{a, b});
            case "/": return divide(new int[]{a, b});
        }
        throw new IllegalStateException("this operation not support : " + operation);
    }

    private static int sum(int[] values) {
        return values[0] + values[1];
    }


    private static int minus(int[] values) {
        return values[0] - values[1];
    }


    private static int multiply(int[] values) {
        return values[0] * values[1];
    }


    private static int divide(int[] values) {
        return values[0] / values[1];
    }


    private static String[] split(String input) {
        return StringUtils.split(input, " ");
    }
}
