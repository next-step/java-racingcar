package calculator;

public class StringCalculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int first = toInt(values[0]);
        int second = toInt(values[2]);
        String operator = values[1];

        return calculate(first, second, operator);
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
