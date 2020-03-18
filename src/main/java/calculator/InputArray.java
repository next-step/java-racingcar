package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputArray {
    private static final List<String> OPERATORS = Arrays.asList("+", "-", "/", "*");
    private List<String> operators = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();

    public InputArray(InputView inputView) {
        validateOperator(inputView.getInputArr());
        extractNumbers(inputView.getInputArr());
    }

    private void validateOperator(String[] inputArr) {
        boolean present = extractOperators(inputArr).stream()
                .filter(it -> !OPERATORS.contains(it))
                .findAny()
                .isPresent();
        if (present) {
            throw new IllegalArgumentException("사칙연산 기호만 입력 가능합니다.");
        }
    }

    private List<String> extractOperators(String[] inputArr) {
        for (int i = 1; i < inputArr.length; i += 2) {
            operators.add(inputArr[i]);
        }
        return operators;
    }

    private void extractNumbers(String[] inputArr) {
        for (int i = 0; i < inputArr.length; i += 2) {
            numbers.add(Integer.parseInt(inputArr[i]));
        }
    }

    public List<String> getOperators() {
        return operators;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}