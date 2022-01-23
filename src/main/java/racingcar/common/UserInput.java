package racingcar.common;

import racingcar.common.exception.InputValidationException;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.common.SystemMessage.*;

public class UserInput {

    private static final String DELIMITER = ",";
    private static final int LENGTH_LIMIT_MAX = 5;
    private static final int LENGTH_LIMIT_MIN = 1;

    private List<String> splitUserInput;
    private String carNameInput;
    private int racingTime;

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    private UserInput() {
        while (parsingCarName())
            ;
        while (parsingRacingTime())
            ;
    }

    public static UserInput instance() {
        return new UserInput();
    }

    private boolean parsingCarName() {
        try {
            log.write(CAR_NAME_INPUT_INFO);
            log.flush();
            this.carNameInput = bufferedReader.readLine();
            splitUserInput = splitStr(carNameInput);
            validateLengthLimit(splitUserInput);
            validateDuplicateCar(splitUserInput);
        } catch (IOException | InputValidationException exception) {
            exception.printStackTrace();
            return true;
        }
        return false;
    }

    private boolean parsingRacingTime() {
        try {
            log.write(RACING_TIME_INPUT_INFO);
            log.flush();
            this.racingTime = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException | InputValidationException exception) {
            exception.printStackTrace();
            return true;
        }
        return false;
    }

    private void validateLengthLimit(final List<String> splitUserInput) {
        boolean match = splitUserInput.stream()
                .allMatch(input -> input.length() <= LENGTH_LIMIT_MAX && input.length() >= LENGTH_LIMIT_MIN);

        if (!match) {
            throw new InputValidationException(CAR_NAME_LENGTH_LIMIT_ERROR);
        }
    }

    private void validateDuplicateCar(final List<String> splitUserInput) {
        int size = splitUserInput.stream().distinct().collect(Collectors.toList()).size();

        if (size != splitUserInput.size()) {
            throw new InputValidationException(CAR_NAME_DUPLICATE_ERROR);
        }
    }

    private List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER)).collect(Collectors.toList());
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public int getRacingTime() {
        return racingTime;
    }

}
