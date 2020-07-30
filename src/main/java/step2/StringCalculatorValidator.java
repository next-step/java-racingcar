package step2;

import static step2.enums.ExceptionMessages.INPUT_VALUE_IS_NULL_OR_EMPTY;
import static step2.enums.ExceptionMessages.NONE_VALID_INPUT_VALUE;
import static step2.enums.RegexPattern.NUMBER_REGEX;

public class StringCalculatorValidator {

    public StringCalculatorValidator validateIsNotNullOrEmpty(String string) {
        if(string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_VALUE_IS_NULL_OR_EMPTY.toString());
        }
        return this;
    }

    public StringCalculatorValidator validateExpressionStartOrEndNumber(String[] stringArray) {
        if(!NUMBER_REGEX.matches(stringArray[0]) || !NUMBER_REGEX.matches(stringArray[stringArray.length-1])) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE.toString());
        }
        return this;
    }

    public StringCalculatorValidator validateOperatorCount(int operatorCount, int numberCount) {
        if(numberCount - operatorCount != 1) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE.toString());
        }
        return this;
    }
}
