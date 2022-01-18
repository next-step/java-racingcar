package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserInput {
    private static final String ERROR_MESSAGE_NULL = "[ERROR] 입력값은 NULL일 수 없습니다.";
    private static final String ERROR_MESSAGE_BLANK = "[ERROR] 입력값은 공백일 수 없습니다.";
    private static final String ERROR_MESSAGE_SIGN = "[ERROR] 입력값이 사칙 연산 기호가 아닙니다.";
    private static final List<String> SIGNS = new ArrayList<>(Arrays.asList("+", "-", "/", "*"));


    private List<Integer> numbers = new ArrayList<>();
    private List<String> signs = new ArrayList<>();
    private final String userInput ;

    public UserInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.userInput = bufferedReader.readLine();
        validateNull(userInput);
        validateBlank(userInput);
        splitStr(userInput);
    }

    public String getUserInput() {
        return userInput;
    }

    private List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(" ")).collect(Collectors.toList());
    }


    private void segregateSignAndNumber(final List<String> splits) {
        for (String split : splits) {
            if (SIGNS.contains(split)) {
                signs.add(split);
                continue;
            }
            numbers.add(Integer.valueOf(split));
        }
    }


    private void validateNull(final String userInput) {
        if (Objects.isNull(userInput)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NULL);
        }
    }

    private void validateBlank(final String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BLANK);
        }
    }


}
