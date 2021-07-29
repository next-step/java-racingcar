package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UserInput {
    String BLANK_CHARACTER = " ";
    String EMPTY_STRING = "";

    private Queue<String> inputs;

    UserInput(String input) {
        checkIfInputIsNull(input);
        inputs = new LinkedList<>(Arrays.asList(input.split(BLANK_CHARACTER)));
    }

    public Integer getNumber() {
        return Integer.valueOf(pollInput());
    }

    public String getOperator() {
        String operator = pollInput();
        checkInputIsArithmeticOperator(operator);
        return operator;
    }

    public boolean inputToCalculateIsRemaining() {
        return !inputs.isEmpty();
    }

    private void checkIfInputIsNull(String input) {
        if (EMPTY_STRING.equals(input.trim())) {
            throw new IllegalArgumentException("사용자 입력은 null이거나 빈 공백 문자열일 수 없습니다.");
        }
    }

    private void checkInputIsArithmeticOperator(String operator) {
        String[] validOperators = new String[]{"+", "-", "*", "/"};
        boolean isNotValidOperator = Arrays.stream(validOperators).noneMatch(operator::equals);
        if (isNotValidOperator) {
            throw new IllegalArgumentException("입력 값에서 홀수번째 문자는 사칙연산자만 가능합니다.");
        }
    }

    private String pollInput() {
        return inputs.poll();
    }
}
