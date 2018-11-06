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
        return accumulate(text.split(SEPARATOR));
    }

    private static int accumulate(String[] values) {
        String operator = values[OPERATOR_INDEX];
        int leftSide = Integer.parseInt(values[LEFT_SIDE_INDEX]);
        int rightSide = Integer.parseInt(values[RIGHT_SIDE_INDEX]);

        int result = Calculator.calculate(operator, leftSide, rightSide);

        return values.length <= 3 ?
                result :
                accumulate(applyCalculationResultToArray(result, values));
    }

    private static String[] applyCalculationResultToArray(int result, String[] values) {
        values = ArrayUtils.removeAll(values, LEFT_SIDE_INDEX, OPERATOR_INDEX, RIGHT_SIDE_INDEX);
        values = ArrayUtils.add(values, 0, String.valueOf(result));
        return values;
    }
}