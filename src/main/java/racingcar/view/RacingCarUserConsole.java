package racingcar.view;

import static racingcar.model.utils.info.RacingGameErrorInfo.CAR_NAME_DUPLICATED_ERROR;
import static racingcar.model.utils.info.RacingGameErrorInfo.CAR_NAME_LIMIT_ERROR;
import static racingcar.model.utils.info.RacingGameErrorInfo.TRY_NUMBER_COUNT_ERROR;
import static racingcar.model.utils.info.RacingGameInfo.RACING_CAR_INPUT;
import static racingcar.model.utils.info.RacingGameInfo.RACING_TRY_INPUT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.dto.InputDTO;
import racingcar.model.utils.exception.InputValidationException;

public class RacingCarUserConsole {

    private static final String DELIMITER = ",";
    private final BufferedReader bufferedReader;
    private final BufferedWriter log;
    private String carNameInput;
    private int racingTryCounter;
    private List<String> splitStrInput;
    private InputDTO inputDTO;

    public RacingCarUserConsole() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        log = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public InputDTO getInputDTO() {
        return inputDTO;
    }

    public void userInputRun() {
        do {
            inputCarName();
        } while (parsingCarName());

        do {
            inputRacingTry();
        } while (parsingRacingTry());
        inputDTO = new InputDTO(splitStrInput, carNameInput, racingTryCounter);
    }

    public boolean parsingCarName() {
        try {
            splitStrInput = splitStr(carNameInput);
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
            carNameInput = bufferedReader.readLine();
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
            racingTryCounter = Integer.parseInt(bufferedReader.readLine());
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

