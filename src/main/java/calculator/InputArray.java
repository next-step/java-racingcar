package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputArray {
    private static final List<String> OPERATORS = Arrays.asList("+", "-", "/", "*");
    private String[] inputArr;

    public InputArray(String[] inputArr) {
        validateOperator(inputArr);
        this.inputArr = inputArr;
    }

    private void validateOperator(String[] inputArr) {
        boolean present = extractEvenChar(inputArr).stream()
                .filter(it -> !OPERATORS.contains(it))
                .findAny()
                .isPresent();
        if(present){
            throw new IllegalArgumentException("사칙연산 기호만 입력 가능합니다.");
        }
    }

    public List<String> extractEvenChar(String[] inputArr) {
        List<String> operators = new ArrayList<>();
        for (int i = 1; i < inputArr.length; i += 2) {
            operators.add(inputArr[i]);
        }
        return operators;
    }
}
