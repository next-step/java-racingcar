package step2;


import step2.enums.Operator;
import step2.enums.RegexPattern;

import java.util.Arrays;

import static step2.enums.ExceptionMessages.INPUT_VALUE_IS_NULL_OR_EMPTY;
import static step2.enums.ExceptionMessages.NONE_VALID_INPUT_VALUE;
import static step2.enums.RegexPattern.*;

public class StringCalculator {

    public String[] splitStringByWhiteSpace(String expression) {
        String[] splitResult = WHITE_SPACE_REGEX.split(expression);
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
        if(!NUMBER_REGEX.matches(stringArray[0]) || !NUMBER_REGEX.matches(stringArray[stringArray.length-1])) {
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

    private String[] filterStringArrayByRegex(String[] stringArray, RegexPattern regexPattern) {
        return Arrays.stream(stringArray).filter(string -> regexPattern.matches(string)).toArray(String[]::new);
    }

}
