package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.Calculator.*;

public class InputArray {
    private static final int INCREMENT_FOR_NEXT_OPERATOR = 2;
    private static final int INCREMENT_FOR_NEXT_NUMBER = 2;
    private static final List<String> OPERATORS = Arrays.asList(PLUS, MINUS, TIMES, DIVIDED_BY);

    private List<String> operators = new ArrayList<>();
    private List<Double> numbers = new ArrayList<>();

    public InputArray(InputView inputView) {
        validateOperator(inputView.getInputArr());
        extractNumbers(inputView.getInputArr());
    }

    private void validateOperator(String[] inputArr) {
        boolean hasNonOperation = extractOperators(inputArr).stream()
                .filter(it -> !OPERATORS.contains(it))
                .findAny()
                .isPresent();
        if (hasNonOperation) {
            throw new IllegalArgumentException("사칙연산 기호만 입력 가능합니다.");
        }
    }

    private List<String> extractOperators(String[] inputArr) {
        for (int i = 1; i < inputArr.length; i += INCREMENT_FOR_NEXT_OPERATOR) {
            operators.add(inputArr[i]);
        }
        return operators;
    }

    private void extractNumbers(String[] inputArr) {
        for (int i = 0; i < inputArr.length; i += INCREMENT_FOR_NEXT_NUMBER) {
            numbers.add(Double.parseDouble(inputArr[i]));
        }
    }

    public List<String> getOperators() {
        return operators;
    }

    public List<Double> getNumbers() {
        return numbers;
    }
}