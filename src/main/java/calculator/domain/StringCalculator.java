package calculator.domain;


import java.util.List;

public class StringCalculator {
    private static final String VALID_EMPTY_INPUT_MESSAGE = "입력값이 없습니다.";
    private static final String VALID_BLANK_INPUT_MESSAGE = "공백 구분자가 없습니다.";
    private static final String NO_MATCH_INPUT_FORMAT_MESSAGE = "입력값의 포맷이 맞지않습니다.";
    private static final String BLANK_SEPARATOR = " ";

    private final List<Operator> calculateOperators;
    private final List<CalculateNumber> calculateNumbers;

    public StringCalculator(String input) {
        validStringCalculator(input);
        String[] splitBlankInputs = input.split(BLANK_SEPARATOR);
        matchInputFormat(splitBlankInputs);
        this.calculateOperators = new Operators(splitBlankInputs).operators();
        this.calculateNumbers = new CalculateNumbers(splitBlankInputs).numbers();
    }

    private void matchInputFormat(String[] splitBlankInputs) {
        int inputsLength = splitBlankInputs.length;
        int firstIndex = 0;
        int lastIndex = inputsLength -1;
        if (isEven(inputsLength)
                || isNotNumber(splitBlankInputs[firstIndex])
                || isNotNumber(splitBlankInputs[lastIndex])) {
            throw new IllegalArgumentException(NO_MATCH_INPUT_FORMAT_MESSAGE);
        }
    }

    private boolean isNotNumber(String splitBlankInput) {
        try {
            Integer.parseInt(splitBlankInput);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isEven(int num) {
        return (num % 2) == 0;
    }

    public int calculate() {
        int index = 0;
        int sum = calculateNumbers.get(index).number();
        for (Operator operator : calculateOperators) {
            index++;
            sum = operator.caculate(sum, calculateNumbers.get(index).number());
        }
        return sum;
    }

    private void validStringCalculator(String input) {
        validNullOrEmpty(input);
        validBlank(input);
    }

    private void validBlank(String input) {
        if (!input.contains(BLANK_SEPARATOR)) {
            throw new IllegalArgumentException(VALID_BLANK_INPUT_MESSAGE);
        }
    }

    private void validNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(VALID_EMPTY_INPUT_MESSAGE);
        }
    }

}
