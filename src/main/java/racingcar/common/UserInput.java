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
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

    public UserInput() {
        while (parsingCarName())
            ;
        while (parsingRacingTry())
            ;
    }

    private boolean parsingCarName() {
        try {
            log.write(RACING_CAR_INPUT);
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

    private boolean parsingRacingTry() {
        try {
            log.write(RACING_TRY_INPUT);
            log.flush();
            this.racingTryCounter = Integer.parseInt(bufferedReader.readLine());
            validateNumberRange(this.racingTryCounter);
        } catch (IOException | InputValidationException exception) {
            exception.printStackTrace();
            return true;
        }
        return false;
    }

    private void validateNumberRange(final int number){
        if(number<1 || number>9){
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

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public int getRacingTryCounter() {
        return racingTryCounter;
    }

}
