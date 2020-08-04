package step2;

import step2.collections.InputNumbers;
import step2.collections.InputOperators;

import java.util.Arrays;
import java.util.regex.Pattern;

import static step2.constants.ExceptionMessages.INPUT_VALUE_IS_NULL_OR_EMPTY;
import static step2.constants.ExceptionMessages.NONE_VALID_INPUT_VALUE;
import static step2.constants.RegexPattern.*;

/**
 * 입력 받은 문자열 계산식을
 * 숫자와 연산자로 올바르게 나눠주는 클래스
 */
public class ExpressionSeparator {

    private final InputNumbers inputNumbers;

    private final InputOperators inputOperators;

    public ExpressionSeparator(String expression) {
        String[] split = splitByWhiteSpace(expression);

        InputNumbers inputNumbers = new InputNumbers(split);
        InputOperators inputOperators = new InputOperators(split);
        validateOperatorCount(inputNumbers, inputOperators);

        this.inputNumbers = inputNumbers;
        this.inputOperators = inputOperators;
    }

    /**
     * 입력 받은 숫자들을 담고있는 일급콜렉션을 리턴
     *
     * @return the input numbers
     */
    public InputNumbers getInputNumbers() {
        return inputNumbers;
    }

    /**
     * 입력 받은 연산자들을 담고있는 일급콜렉션을 리턴
     *
     * @return the input operators
     */
    public InputOperators getInputOperators() {
        return inputOperators;
    }

    private String[] splitByWhiteSpace(String expression) {
        validateBeforeSplit(expression);
        String[] split = WHITE_SPACE_REGEX.split(expression);
        validateAfterSplit(split);
        return WHITE_SPACE_REGEX.split(expression);
    }

    private void validateBeforeSplit(String expression) {
        if(expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_VALUE_IS_NULL_OR_EMPTY);
        }
    }

    private void validateAfterSplit(String[] split) {
        validateExpressionStartOrEndNumber(split);
        validateOperatorPlacedBetweenNumbers(split);
    }

    private void validateExpressionStartOrEndNumber(String[] split) {
        if(!NUMBER_REGEX.matcher(split[0]).matches() || !NUMBER_REGEX.matcher(split[split.length-1]).matches()) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE);
        }
    }

    private void validateOperatorPlacedBetweenNumbers(String[] split) {
        int splitLength = split.length;
        for(int i = 1 ; i < splitLength ; i++) {
            String prevElement = split[i-1];
            String nowElement = split[i];
            validateParametersAreNotSameRegex(prevElement, nowElement);
        }
    }

    private void validateParametersAreNotSameRegex(String first, String second) {
        if(NUMBER_REGEX.matcher(first).matches() == NUMBER_REGEX.matcher(second).matches()) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE);
        }
    }

    private void validateOperatorCount(InputNumbers inputNumbers, InputOperators inputOperators) {
        if(inputNumbers.size() - inputOperators.size() != 1) {
            throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE);
        }
    }
}
