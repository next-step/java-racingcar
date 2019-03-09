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
            int rightHandSideNumber = Integer.parseInt(values[idx++]);
            result = calculrate(result, rightHandSideNumber, expression);
        }

        return result;
    }

    private static int calculrate(int leftHandSideNumber, int rightHandSideNumber, String expression) {
        if ("+".equals(expression)) {
            return leftHandSideNumber + rightHandSideNumber;
        }

        if ("-".equals(expression)) {
            return leftHandSideNumber - rightHandSideNumber;
        }

        if ("*".equals(expression)) {
            return leftHandSideNumber * rightHandSideNumber;
        }

        if ("/".equals(expression)) {
            return leftHandSideNumber / rightHandSideNumber;
        }

        return Integer.MIN_VALUE;
    }

}
