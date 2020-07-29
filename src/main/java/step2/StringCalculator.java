package step2;

import java.util.Arrays;

public class StringCalculator {

    private static final String WHITE_SPACE_REGEX = "\\s+";
    private static final String NUMBER_REGEX = "\\d";
    private static final String OPERATOR_REGEX = "[+*-/]";

    private static final String PLUS_OPERATOR = "+";
    private static final String SUBTRACT_OPERATOR = "-";
    private static final String MULTIPLY_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";

    private static final String INPUT_VALUE_IS_NULL_OR_EMPTY = "입력값이 비어있습니다.";
    private static final String NONE_VALID_INPUT_VALUE = "올바른 입력값이 아닙니다.";
    private static final String IS_NOT_OPERATOR = "사칙 연산 기호가 아닙니다.";
    private static final String CAN_NOT_DIVIDE_ZERO = "0으로 나눌 수 없습니다.";

    public String[] splitStringByWhiteSpace(String expression) {
        String[] splitResult = expression.split(WHITE_SPACE_REGEX);
        if(splitResult.length < 2) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE);
        }
        return splitResult;
    }

    public void validateIsNotNullOrEmpty(String string) {
        if(string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_VALUE_IS_NULL_OR_EMPTY);
        }
    }

    public void validateExpressionStartOrEndNumber(String[] stringArray) {
        if(!stringArray[0].matches(NUMBER_REGEX) || !stringArray[stringArray.length-1].matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE);
        }
    }

    public void validateOperatorCount(int operatorCount, int numberCount) {
        if(numberCount - operatorCount != 1) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE);
        }
    }

    public Integer parseStringToInteger(String numberString) {
        return Integer.parseInt(numberString);
    }

    public Integer[] transformStringArrayToIntegerArray(String[] stringArray) {
        return Arrays.stream(stringArray).map(string -> parseStringToInteger(string)).toArray(Integer[]::new);
    }

    public String[] filterNumberStringFromStringArray(String[] stringArray) {
        return filterStringArrayByRegex(stringArray,NUMBER_REGEX);
    }

    public String[] filterOperatorStringFromStringArray(String[] stringArray) {
        return filterStringArrayByRegex(stringArray, OPERATOR_REGEX);
    }

    public Integer add(Integer one, Integer theOther) {
        return one + theOther;
    }

    public Integer multiply(Integer one, Integer theOther) {
        return one * theOther;
    }

    public Integer subtract(Integer one, Integer theOther) {
        return one - theOther;
    }

    public Integer divide(Integer one, Integer theOther) {
        if(theOther == 0) {
            throw new IllegalArgumentException(CAN_NOT_DIVIDE_ZERO);
        }
        return one / theOther;
    }

    public Integer computeWithRightOperator(Integer one, Integer theOther, String operator) {
        switch (operator) {
            case PLUS_OPERATOR :
                return add(one, theOther);
            case SUBTRACT_OPERATOR :
                return subtract(one, theOther);
            case MULTIPLY_OPERATOR :
                return multiply(one, theOther);
            case DIVIDE_OPERATOR :
                return divide(one, theOther);
            default :
                throw new IllegalArgumentException(IS_NOT_OPERATOR);

        }
    }

    public Integer calculate(String expression) {
        validateIsNotNullOrEmpty(expression);
        String[] splitElements = splitStringByWhiteSpace(expression);
        validateExpressionStartOrEndNumber(splitElements);
        String[] operatorElements = filterOperatorStringFromStringArray(splitElements);
        Integer[] numberElements = transformStringArrayToIntegerArray(filterNumberStringFromStringArray(splitElements));
        validateOperatorCount(operatorElements.length,numberElements.length);

        Integer result = numberElements[0];

        for(int i = 1 ; i < numberElements.length ; i++) {
            Integer number = numberElements[i];
            result = computeWithRightOperator(result,number,operatorElements[i-1]);
        }

        return result;

    }

    private String[] filterStringArrayByRegex(String[] stringArray, String regex) {
        return Arrays.stream(stringArray).filter(string -> string.matches(regex)).toArray(String[]::new);
    }

}
