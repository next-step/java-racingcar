package stringcalculator;

public class CommonException {

    public static void inputExpressionInValidException(String inputExpression) {
        if (inputExpression == null || inputExpression.trim().isEmpty()) {
            throw new IllegalArgumentException(CommonConstant.INVALID_INPUT_EXPRESSION);
        }
    }

}
