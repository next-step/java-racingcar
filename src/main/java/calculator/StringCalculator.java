package calculator;

public class StringCalculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int result = toInt(values[0]);
        for(int i=1; i < values.length; i+=2) {
            String operator = values[i];
            int second = toInt(values[i + 1]);
            result = calculate(result, second, operator);
        }
        return result;
    }

    private static int calculate(int first, int second, String operator) {
        return Operator.of(operator)
                       .operate(first, second);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
