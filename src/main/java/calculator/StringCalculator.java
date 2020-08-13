package calculator;

public class StringCalculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int result = toInt(values[0]);

        for (int i = 1; i < values.length; i+=2) {
            String operator = values[i];
            int second = toInt(values[i + 1]);
            result = calculate(result, second, operator);
        }
        return result;
    }

    private static int calculate(int first, int second, String operator) {
        if (operator.equals("+")) {
            return first + second;
        }
        if (operator.equals("-")) {
            return first - second;
        }
        if (operator.equals("*")) {
            return first * second;
        }
        if (operator.equals("/")) {
            return first / second;
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
