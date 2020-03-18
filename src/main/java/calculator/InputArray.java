package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputArray {
    private static final List<String> OPERATORS = Arrays.asList("+", "-", "/", "*");
    private List<String> operators = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();

    public InputArray(String[] inputArr) {
        validateOperator(inputArr);
    }

    private void validateOperator(String[] inputArr) {
        boolean present = extractOperator(inputArr).stream()
                .filter(it -> !OPERATORS.contains(it))
                .findAny()
                .isPresent();
        if(present){
            throw new IllegalArgumentException("사칙연산 기호만 입력 가능합니다.");
        }
    }

    private List<String> extractOperator(String[] inputArr) {
        for (int i = 1; i < inputArr.length; i += 2) {
            operators.add(inputArr[i]);
        }
        return operators;
    }

    public List<String> getOperators() {
        return operators;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
