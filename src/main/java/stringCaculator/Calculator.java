package stringCaculator;

public class Calculator {
    public static int calculate(String value) {
        String trimmedValue = value.trim();
        if (trimmedValue.isEmpty()) {
            throw new IllegalArgumentException("입력값이 공백입니다.");
        }

        String[] values = trimmedValue.split(" ");
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i+=2) {
            int first = result;
            int second = Integer.parseInt(values[i + 1]);
            String operator = values[i];

            if (operator.equals("+")) {
                result = first + second;
            } else if (operator.equals("-")) {
                result = first - second;
            } else if (operator.equals("/")) {
                result = first / second;
            } else if (operator.equals("*")) {
                result = first * second;
            } else {
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
            }
        }

        return result;
    }
}
