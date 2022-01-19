package racingcar.common;

import racingcar.common.exception.InputValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    private static final String DELIMITER = ",";
    private List<String> splitUserInput;
    private String userInput;

    public UserInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.userInput = bufferedReader.readLine();
            splitUserInput = splitStr(userInput);
            validateLengthLimit(splitUserInput);
            validateDuplicateCar(splitUserInput);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void validateLengthLimit(final List<String> splitUserInput) {
        boolean match = splitUserInput.stream()
                .allMatch(input -> input.length() <= 5 && input.length() >= 1);

        if (!match) {
            throw new InputValidationException("자동차 이름은 5글자를 넘을 수 없습니다.");
        }

    }

    private void validateDuplicateCar(final List<String> splitUserInput) {
        int size = splitUserInput.stream().distinct().collect(Collectors.toList()).size();

        if (size != splitUserInput.size()) {
            throw new InputValidationException("중복된 자동차 이름이 존재합니다.");
        }
    }

    private List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER)).collect(Collectors.toList());
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

}
