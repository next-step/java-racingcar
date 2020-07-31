package step2;

import step2.enums.RegexPattern;

import java.util.Arrays;

import static step2.enums.RegexPattern.*;

public class StringCalculatorVO {

    private final Integer[] numberElements;
    private final String[] operatorElements;

    private final StringCalculatorVOValidator stringCalculatorVOValidator = new StringCalculatorVOValidator();

    public StringCalculatorVO(String expression) {
        String[] splitElements = splitStringByWhiteSpace(expression);
        String[] operatorElements = filterOperatorStringFromStringArray(splitElements);
        Integer[] numberElements = transformStringArrayToIntegerArray(filterNumberStringFromStringArray(splitElements));

        stringCalculatorVOValidator.validateIsNotNullOrEmpty(expression)
                                .validateExpressionStartOrEndNumber(splitElements)
                                .validateOperatorPlacedBetweenNumbers(splitElements)
                                .validateOperatorCount(operatorElements.length, numberElements.length);

        this.numberElements = numberElements;
        this.operatorElements = operatorElements;
    }

    protected StringCalculatorVO() {
        this.numberElements = null;
        this.operatorElements = null;
    }

    public Integer[] getNumberElements() {
        return numberElements;
    }

    public String[] getOperatorElements() {
        return operatorElements;
    }

    protected String[] splitStringByWhiteSpace(String expression) {
        return WHITE_SPACE_REGEX.split(expression);
    }

    protected String[] filterNumberStringFromStringArray(String[] stringArray) {
        return filterStringArrayByRegex(stringArray,NUMBER_REGEX);
    }

    protected String[] filterOperatorStringFromStringArray(String[] stringArray) {
        return filterStringArrayByRegex(stringArray, OPERATOR_REGEX);
    }

    protected Integer parseStringToInteger(String numberString) {
        return Integer.parseInt(numberString);
    }

    protected Integer[] transformStringArrayToIntegerArray(String[] stringArray) {
        return Arrays.stream(stringArray).map(string -> parseStringToInteger(string)).toArray(Integer[]::new);
    }

    private String[] filterStringArrayByRegex(String[] stringArray, RegexPattern regexPattern) {
        return Arrays.stream(stringArray).filter(string -> regexPattern.matches(string)).toArray(String[]::new);
    }
}
