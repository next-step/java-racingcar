package pobiStringCalculator;

public class StringCalculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int first = toInt(values[0]);
        for (int i = 1 ; i < values.length; i+=2){
            // 0 아닌 1 (base 이미 first values[0]), ++(+1)아닌 +=2, 연산자와 정수 구분
            String operator = values[i];
            int second = toInt(values[i+1]);
            first = calculate(first, second, operator);
        }
        return first;

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
        throw new IllegalArgumentException("not supported operator");
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);  // i, values -> value
    }
}
