package calculator;

public class Calculator {
    private static final String DELIMITER = " ";
    private static final int FIRST_SIGN_INDEX = 1;

    public static int calculate(String numericExpression) {
        validateNotEmpty(numericExpression);

        String[] splitNumericExpression = numericExpression.split(DELIMITER);
        int result = 0;

        for (int signIndex = FIRST_SIGN_INDEX; signIndex < splitNumericExpression.length; signIndex += 2) {
            String sign = splitNumericExpression[signIndex];
            int num1 = signIndex == FIRST_SIGN_INDEX ? Integer.parseInt(splitNumericExpression[signIndex - 1]) : result;
            int num2 = Integer.parseInt(splitNumericExpression[signIndex + 1]);
            result = Operator.operate(sign, num1, num2);
        }
        return result;
    }

    private static void validateNotEmpty(String numericExpression) {
        if (numericExpression == null || numericExpression.trim().isEmpty()) {
            throw new IllegalArgumentException("수식이 존재하지 않습니다.");
        }
    }
}
