package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {
    private static final String REGULAR_EXPRESSION_MATH_EXPRESSION = "[-+*/0-9]";
    private static final String WRONG_NUMBER = "숫자가 잘못되었습니다.";
    private static final int EMPTY_STRING_SIZE = 0;
    private static final String BLANK = " ";
    private static final int CURRENT_NUMBER = 0;
    private static final int FIRST_OPERATOR_INDEX = 1;
    private static final int NEXT_OPERATOR_INDEX = 2;
    private static final int NEXT_NUMBER_INDEX = 1;


    private int convertInteger(String stringNumber) {
        if (validateNumber(stringNumber)) {
            throw new IllegalArgumentException(WRONG_NUMBER);
        }
        return Integer.parseInt(stringNumber);
    }

    private boolean validateNumber(String stringNumber) {
        return Objects.isNull(stringNumber) || stringNumber.isEmpty() || !stringNumber.matches(REGULAR_EXPRESSION_MATH_EXPRESSION);
    }


    private boolean validateCalculator(final String inputExpression) {
        return inputExpression == null || inputExpression.trim().length() == EMPTY_STRING_SIZE;
    }

    public int calculate(final String inputExpression) {
        if (validateCalculator(inputExpression)) {
            throw new IllegalArgumentException();
        }

        List<String> inputGroup = Arrays.asList(inputExpression.split(BLANK));
        int result = convertInteger(inputGroup.get(CURRENT_NUMBER));

        for (int i = FIRST_OPERATOR_INDEX; i < inputGroup.size(); i += NEXT_OPERATOR_INDEX) {
            result = Operator.getOperator(inputGroup.get(i))
                    .calculate(result, convertInteger(inputGroup.get(i + NEXT_NUMBER_INDEX)));
        }

        return result;
    }
}
