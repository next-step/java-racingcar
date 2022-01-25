package racingcar.common;

import static racingcar.common.info.RacingGameErrorInfo.*;
import static racingcar.common.info.RacingGameInfo.*;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import racingcar.common.exception.InputValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.info.RacingGameErrorInfo;
import racingcar.common.info.RacingGameInfo;

public class UserInput {

    private static final String DELIMITER = ",";
    private List<String> splitUserInput;
    private String carNameInput;
    private int racingTryCounter;
    private final BufferedReader bufferedReader;
    private final BufferedWriter log;

    public UserInput() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        log = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void userInputRun() {

        do{
            inputCarName();
        }while(parsingCarName());

        do{
            inputRacingTry();
        }while(parsingRacingTry());

    }

    public void setCarNameInput(String carNameInput) {
        this.carNameInput = carNameInput;
    }

    public void setRacingTryCounter(int racingTryCounter) {
        this.racingTryCounter = racingTryCounter;
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public int getRacingTryCounter() {
        return racingTryCounter;
    }

    public boolean parsingCarName() {
        try {
            splitUserInput = splitStr(carNameInput);
            validateLengthLimit(splitUserInput);
            validateDuplicateCar(splitUserInput);
        } catch (InputValidationException exception) {
            exception.getMessage();
            return true;
        }
        return false;
    }

    public boolean parsingRacingTry() {
        try {
            validateNumberRange(racingTryCounter);
        } catch (InputValidationException exception) {
            exception.getMessage();
            return true;
        }
        return false;
    }

    private boolean inputCarName() {
        try {
            log.write(RACING_CAR_INPUT);
            log.flush();
            this.carNameInput = bufferedReader.readLine();
        } catch (IOException exception) {
            exception.getMessage();
            return true;
        }
        return false;
    }

    private boolean inputRacingTry() {
        try {
            log.write(RACING_TRY_INPUT);
            log.flush();
            this.racingTryCounter = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException exception) {
            exception.getMessage();
            return true;
        }
        return false;
    }

    private void validateNumberRange(final int number) {
        if (number < 1 || number > 9) {
            throw new InputValidationException(TRY_NUMBER_COUNT_ERROR);
        }
    }

    private void validateLengthLimit(final List<String> splitUserInput) {
        boolean match = splitUserInput.stream()
            .allMatch(input -> input.length() <= 5 && input.length() >= 1);
        if (!match) {
            throw new InputValidationException(CAR_NAME_LIMIT_ERROR);
        }
    }

    private void validateDuplicateCar(final List<String> splitUserInput) {
        int size = splitUserInput.stream().distinct().collect(Collectors.toList()).size();

        if (size != splitUserInput.size()) {
            throw new InputValidationException(CAR_NAME_DUPLICATED_ERROR);
        }
    }

    private List<String> splitStr(final String userInput) {
        return Arrays.stream(userInput.split(DELIMITER)).collect(Collectors.toList());
    }
}

