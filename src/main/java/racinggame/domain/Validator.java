package racinggame.domain;

import java.util.List;
import racinggame.exception.InputBlankException;
import racinggame.exception.LackOfPlayerException;
import racinggame.exception.NameLengthOverException;

public class Validator {

    public static final int MINIMUM_PLAYER = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private Validator() {}

    public static void validatePossibleToStart(RacingCars racingCars) {
        if (isPossibleToStart(racingCars.get())) {
            throw new LackOfPlayerException(racingCars.get());
        }
    }

    private static boolean isPossibleToStart(List<RacingCar> racingCars) {
        return racingCars.size() < MINIMUM_PLAYER;
    }

    public static void validateNameLength(String carName) {
        if (carName.length() > MAXIMUM_NAME_LENGTH) {
            throw new NameLengthOverException(carName);
        }
    }

    public static void isNumber(String trial) {
        try {
            Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("시도횟수는 숫자로 입력해주세요.");
        }
    }

    public static void checkIsBlank(String removedBlankInput) {
        if (removedBlankInput.isEmpty()) {
            throw new InputBlankException();
        }
    }

    public static void checkNameIsBlank(String[] splitName) {
        for (int i = 0; i < splitName.length; i++) {
            if (splitName[i].isEmpty()) {
                throw new InputBlankException(i);
            }
        }
    }
}
