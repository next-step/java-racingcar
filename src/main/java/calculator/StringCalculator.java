package calculator;

import spark.utils.StringUtils;

public class StringCalculator {

    static int calculate(String text) {

        //validation (null or empty)
        if (StringUtils.isEmpty(text)) return Integer.MIN_VALUE;

        String[] values = text.split(" ");
        int count = values.length;

        int result = Integer.parseInt(values[0]);
        int idx = 1;

        while (idx < count) {
            String expression = values[idx++];
            int y = Integer.parseInt(values[idx++]);
            result = calculrate(result, y, expression);
        }

        return result;
    }

    private static int calculrate(int x, int y, String expression) {
        if ("+".equals(expression)) {
            return x + y;
        }

        if ("-".equals(expression)) {
            return x - y;
        }

        if ("*".equals(expression)) {
            return x * y;
        }

        if ("/".equals(expression)) {
            return x / y;
        }

        return Integer.MIN_VALUE;
    }

}
