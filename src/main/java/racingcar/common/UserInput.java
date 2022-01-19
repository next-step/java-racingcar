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

    private List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER)).collect(Collectors.toList());
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

}
