package step2;


import step2.enums.Operator;

import java.util.Arrays;

import static step2.enums.ExceptionMessages.INPUT_VALUE_IS_NULL_OR_EMPTY;
import static step2.enums.ExceptionMessages.NONE_VALID_INPUT_VALUE;

public class StringCalculator {

    private static final String WHITE_SPACE_REGEX = "\\s+";
    private static final String NUMBER_REGEX = "\\d";
    private static final String OPERATOR_REGEX = "[+*-/]";

    public String[] splitStringByWhiteSpace(String expression) {
        String[] splitResult = expression.split(WHITE_SPACE_REGEX);
        if(splitResult.length < 2) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE.toString());
        }
        return splitResult;
    }

    public void validateIsNotNullOrEmpty(String string) {
        if(string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_VALUE_IS_NULL_OR_EMPTY.toString());
        }
    }

    public void validateExpressionStartOrEndNumber(String[] stringArray) {
        if(!stringArray[0].matches(NUMBER_REGEX) || !stringArray[stringArray.length-1].matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE.toString());
        }
    }

    public void validateOperatorCount(int operatorCount, int numberCount) {
        if(numberCount - operatorCount != 1) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE.toString());
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

    public Integer computeWithRightOperator(Integer one, Integer theOther, String operator) {
        return Operator.get(operator).compute(one, theOther);
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
