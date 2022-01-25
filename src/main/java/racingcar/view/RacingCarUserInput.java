package racingcar.view;

import static racingcar.model.utils.info.RacingGameErrorInfo.*;
import static racingcar.model.utils.info.RacingGameInfo.*;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import racingcar.controller.dto.InputDTO;
import racingcar.model.utils.exception.InputValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.utils.info.RacingGameErrorInfo;
import racingcar.model.utils.info.RacingGameInfo;

public class RacingCarUserInput {

    private static final String DELIMITER = ",";
    private final BufferedReader bufferedReader;
    private final BufferedWriter log;
    private final InputDTO inputDTO;

    public RacingCarUserInput() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        log = new BufferedWriter(new OutputStreamWriter(System.out));
        inputDTO = new InputDTO();
    }

    public void userInputRun() {
        do{
            inputCarName();
        }while(parsingCarName());

        do{
            inputRacingTry();
        }while(parsingRacingTry());
    }

    public boolean parsingCarName() {
        try {
            List<String> splitStrInput = splitStr(inputDTO.getCarNameInput());
            validateLengthLimit(splitStrInput);
            validateDuplicateCar(splitStrInput);
        } catch (InputValidationException exception) {
            exception.getMessage();
            return true;
        }
        return false;
    }

    public boolean parsingRacingTry() {
        try {
            validateNumberRange(inputDTO.getRacingTryCounter());
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
            inputDTO.setCarNameInput(bufferedReader.readLine());
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
            inputDTO.setRacingTryCounter(Integer.parseInt(bufferedReader.readLine()));
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

