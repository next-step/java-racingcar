package calculator;

public class StringCalculator {
    static int calculate(String text) {
        String[] values = text.split(" ");

        int result = 0;
        int first = Integer.parseInt(values[0]);
        for (int i = 0; i <= values.length; i ++) {
            String operator = values[i + 1];
            int second = Integer.parseInt(values[i + 2]);
            result = calculate(first, operator, second);
            first = result;
        }
        return result;
    }

    private static int calculate(int first, String operator, int second) {
        if (operator.equals("+")) {
            return add(first, second);
        }
        if (operator.equals("-")) {
            return sub(first, second);
        }

        if (operator.equals("*")) {
            return multi(first, second);
        }

        if (operator.equals("%")) {
            return dividen(first, second);
        }
        return 0;
    }

    static int add(int first, int second) {
        return first + second;
    }

    static int sub(int first, int second) {
        return first - second;
    }

    static int multi(int first, int second) {
        return first * second;
    }

    static int dividen(int first, int second) {
        return first / second;
    }

}
