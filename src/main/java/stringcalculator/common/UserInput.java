package stringcalculator.common;

import static stringcalculator.common.ErrorMessage.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserInput {

    private static final String DELIMITER_BLANK = " ";
    private static final String DELIMITER_NO_BLANK = "";
    private static final String INPUT_OPERATION_PHRASE = "사칙 연산을 입력해주세요.\n";
    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_ONE = 1;
    private static final int EVEN_NUMBER_CONDITION = 2;

    private final BufferedReader bufferedReader;
    private final BufferedWriter log;

    private List<String> splitUserInput;
    private String userInput;

    public UserInput() {
        log = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        splitUserInput = new ArrayList<>();
        userInput = DELIMITER_NO_BLANK;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public boolean userInputValidCheck() {
        return parsingUserInput();
    }

    public void userInputRun() {
        userInput();
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public boolean parsingUserInput() {
        try {
            validateNull(userInput);
            validateBlank(userInput);
            splitUserInput = splitStr(userInput);
            validateFormat(splitUserInput);
        } catch (IllegalArgumentException exception) {
            exception.getMessage();
            return true;
        }
        return false;
    }

    public void validateFormat(final List<String> userInput) {
        IntStream.range(NUMBER_ZERO, userInput.size())
            .forEach(idx -> {
                if (idx % EVEN_NUMBER_CONDITION == NUMBER_ZERO && !Character.isDigit(
                    userInput.get(idx).charAt(NUMBER_ZERO))) {
                    throw new IllegalArgumentException(ERROR_MESSAGE_FORMAT);
                } else if (idx % EVEN_NUMBER_CONDITION == NUMBER_ONE && !"-*/+".contains(
                    userInput.get(idx))) {
                    throw new IllegalArgumentException(ERROR_MESSAGE_FORMAT);
                }
            });
    }

    public void validateNull(final String userInput) {
        if (Objects.isNull(userInput)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NULL);
        }
    }

    public void validateBlank(final String userInput) {
        if (userInput.isEmpty() || userInput.equals(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BLANK);
        }
    }

    private void userInput() {
        try {
            log.write(INPUT_OPERATION_PHRASE);
            log.flush();
            this.userInput = bufferedReader.readLine();
        } catch (IOException exception) {
            exception.getMessage();
        }
    }

    private List<String> splitStr(String userInput) {
        return Arrays.stream(
                userInput.replace(DELIMITER_BLANK, DELIMITER_NO_BLANK).split(DELIMITER_NO_BLANK))
            .collect(Collectors.toList());
    }
}

