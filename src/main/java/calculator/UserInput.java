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

    private String pollInput() {
        return inputs.poll();
    }
}
