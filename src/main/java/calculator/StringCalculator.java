package calculator;

import org.apache.commons.lang3.ArrayUtils;

public class StringCalculator {

    private static final String SEPARATOR = " ";

    private static final int OPERATOR_INDEX = 1;
    private static final int LEFT_SIDE_INDEX = 0;
    private static final int RIGHT_SIDE_INDEX = 2;

    private StringCalculator() {

    }

    public static int calculate(String text) {
        return calculateUsingRecursion(text);
//        return calculateUsingLoop(text);
    }

    private static int calculateUsingRecursion(String text) {
        return accumulate(text.split(SEPARATOR));
    }

    private static int calculateUsingLoop(String text) {
        String[] values = text.split(SEPARATOR);
        int result = 0;
        while (values.length != 1) {
            String operator = values[OPERATOR_INDEX];
            int num1 = Integer.parseInt(values[LEFT_SIDE_INDEX]);
            int num2 = Integer.parseInt(values[RIGHT_SIDE_INDEX]);
            result = calculate(operator, num1, num2);
            values = applyCalculationResultToArray(values, result);
        }
        return result;
    }

    private static int accumulate(String[] values) {
        String operator = values[OPERATOR_INDEX];
        int leftSide = Integer.parseInt(values[LEFT_SIDE_INDEX]);
        int rightSide = Integer.parseInt(values[RIGHT_SIDE_INDEX]);

        int result = calculate(operator, leftSide, rightSide);

        return values.length <= 3 ?
                result :
                accumulate(applyCalculationResultToArray(values, result));
    }

    private static String[] applyCalculationResultToArray(String[] values, int result) {
        values = ArrayUtils.removeAll(values, LEFT_SIDE_INDEX, OPERATOR_INDEX, RIGHT_SIDE_INDEX);
        values = ArrayUtils.add(values, 0, String.valueOf(result));
        return values;
    }

    private static int calculate(String operator, int leftSide, int rightSide) {
        if(operator.equals("+")) {
            return leftSide + rightSide;
        }
        if(operator.equals("-")) {
            return leftSide - rightSide;
        }
        if(operator.equals("*")) {
            return leftSide * rightSide;
        }
        if(operator.equals("/")) {
            return leftSide / rightSide;
        }
        throw new IllegalArgumentException();
    }
}