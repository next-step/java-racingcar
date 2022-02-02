package racinggame.domain;

import static racinggame.exception.ExceptionBaseMessage.INPUT_BLANK_MESSAGE;
import static racinggame.exception.ExceptionBaseMessage.LACK_OF_PLAYER_MESSAGE;
import static racinggame.exception.ExceptionBaseMessage.NAME_LENGTH_OVER_MESSAGE;

import java.util.List;
import racinggame.exception.InputBlankException;
import racinggame.exception.LackOfPlayerException;
import racinggame.exception.NameLengthOverException;

public class Validator {

    public static final int MINIMUM_PLAYER = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private Validator() {}

    public static void validatePossibleToStart(final RacingCars racingCars) {
        if (isPossibleToStart(racingCars.get())) {
            throw new LackOfPlayerException(
                    LACK_OF_PLAYER_MESSAGE + " (현재 참여인원: " + racingCars.get().size() + ")");
        }
    }

    private static boolean isPossibleToStart(final List<RacingCar> racingCars) {
        return racingCars.size() < MINIMUM_PLAYER;
    }

    public static void validateNameLength(final String carName) {
        if (carName.length() > MAXIMUM_NAME_LENGTH) {
            throw new NameLengthOverException(
                    NAME_LENGTH_OVER_MESSAGE + " (Input: " + carName + ")");
        }
    }

    public static void isNumber(final String trial) {
        try {
            Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("시도횟수는 숫자로 입력해주세요.");
        }
    }

    public static void checkIsBlank(final String removedBlankInput) {
        if (removedBlankInput.isEmpty()) {
            throw new InputBlankException(INPUT_BLANK_MESSAGE);
        }
    }

    public static void checkNameIsBlank(final String[] splitName) {
        for (int i = 0; i < splitName.length; i++) {
            if (splitName[i].isEmpty()) {
                throw new InputBlankException(
                        INPUT_BLANK_MESSAGE + " (" + i + "번째 자동차 이름이 공백입니다.)");
            }
        }
    }
}
