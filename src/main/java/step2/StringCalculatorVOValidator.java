package step2;

import static step2.enums.ExceptionMessages.INPUT_VALUE_IS_NULL_OR_EMPTY;
import static step2.enums.ExceptionMessages.NONE_VALID_INPUT_VALUE;
import static step2.enums.RegexPattern.NUMBER_REGEX;

public class StringCalculatorVOValidator {

    public StringCalculatorVOValidator validateIsNotNullOrEmpty(String string) {
        if(string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_VALUE_IS_NULL_OR_EMPTY.toString());
        }
        return this;
    }

    public StringCalculatorVOValidator validateExpressionStartOrEndNumber(String[] inputElements) {
        if(!NUMBER_REGEX.matches(inputElements[0]) || !NUMBER_REGEX.matches(inputElements[inputElements.length-1])) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE.toString());
        }
        return this;
    }

    public StringCalculatorVOValidator validateOperatorPlacedBetweenNumbers(String[] inputElements) {
        int inputElementsLength = inputElements.length;
        for(int i = 1 ; i < inputElementsLength ; i++) {
            String prevElement = inputElements[i-1];
            String nowElement = inputElements[i];
            validateParametersAreNotSameRegex(prevElement, nowElement);
        }
        return this;
    }

    public StringCalculatorVOValidator validateOperatorCount(int operatorCount, int numberCount) {
        if(numberCount - operatorCount != 1) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE.toString());
        }
        return this;
    }

    private void validateParametersAreNotSameRegex(String first, String second) {
        if(NUMBER_REGEX.matches(first) == NUMBER_REGEX.matches(second)) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE.toString());
        }
    }
}
