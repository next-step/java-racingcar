package race;

import java.util.List;

public class InputValidator {
    private static final int MIN_GAME_COUNT = 1;
    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String GAME_COUNT_TOO_SMALL_MESSAGE = "회수는 1회 이상이어야 합니다";
    private static final String CAR_COUNT_TOO_SMALL_MESSAGE = "자동차는 2대 이상이어야 합니다";
    private static final String CAR_NAME_TOO_BIG_MESSAGE = "자동차 이름은 5글자 이내로 입력 가능합니다";

    public static void validateCarNames(List<String> carNames) {
        validateCarCount(carNames.size());
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    public static void validateGameCount(int gameCount) {
        if (isValidGameCount(gameCount)) {
            return;
        }
        throw new InvalidInputException(GAME_COUNT_TOO_SMALL_MESSAGE);
    }

    private static void validateCarCount(int carCount) {
        if (isValidCarCount(carCount)) {
            return;
        }
        throw new InvalidInputException(CAR_COUNT_TOO_SMALL_MESSAGE);
    }

    private static boolean isValidCarCount(int carCount) {
        return carCount >= MIN_CAR_COUNT;
    }

    private static void validateCarNameLength(String carName) {
        if (isValidCarNameLength(carName)) {
            return;
        }
        throw new InvalidInputException(CAR_NAME_TOO_BIG_MESSAGE);
    }

    private static boolean isValidCarNameLength(String carName) {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    private static boolean isValidGameCount(int gameCount) {
        return gameCount >= MIN_GAME_COUNT;
    }
}
