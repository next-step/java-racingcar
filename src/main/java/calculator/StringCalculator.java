package calculator;

public class StringCalculator {
    public static int calculator(String text) {
        String[] values = text.split(" ");

        int result = Integer.parseInt(values[0]);
        for (int i = 1, len = values.length; i < len; i+=2) {
            String operator = values[i];
            int target = Integer.parseInt(values[i + 1]);
            result = StringCalculator.calculate(result, target, operator);
        }

        return result;
    }

    public static int calculate(int source, int target, String operator) {
        if (operator.equals("+")) {
            return source + target;
        }

        if (operator.equals("-")) {
            return source - target;
        }

        if (operator.equals("*")) {
            return source * target;
        }

        if (operator.equals("/")) {
            return source / target;
        }

        return 0;
    }
}
