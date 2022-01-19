package stringcalculator.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserInput {

    private static final String DELIMITER = " ";
    private List<String> splitUserInput;
    private String userInput;

    public UserInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.userInput = bufferedReader.readLine();
            validateNull(userInput);
            validateBlank(userInput);
            splitUserInput = splitStr(userInput);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    private List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER)).collect(Collectors.toList());
    }


    private void validateNull(final String userInput) {
        if (Objects.isNull(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_NULL);
        }
    }

    private void validateBlank(final String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_BLANK);
        }
    }


}
