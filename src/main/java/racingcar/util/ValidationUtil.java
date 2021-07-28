package racingcar.util;

import racingcar.exception.InvalidCarSettingException;
import racingcar.exception.InvalidUserInputException;

import java.util.Arrays;

public class ValidationUtil {

    private static final String INVALID_STRING_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String INVALID_GAME_COUNT_MESSAGE = "1회 이상의 게임 횟수를 입력해야 시작 가능합니다.";
    private static final String INVALID_BLANK_STRING_MESSAGE = "공백은 입력이 불가합니다.";

    private static final String INVALID_DUPLICATE_CAR_NAME_MESSAGE = "중복된 자동차가 있습니다.";
    private static final String INVALID_BLANK_CAR_NAME_MESSAGE = "자동차 이름은 공백이 불가합니다.";
    private static final String INVALID_LENGTH_CAR_NAME_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String INVALID_CAR_COUNT_MESSAGE = "2개 이상의 자동차를 입력해야 시작 가능합니다.";

    public static void checkUserInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidUserInputException(INVALID_BLANK_STRING_MESSAGE);
        }
    }

    public static void checkCarsValidation(String[] names) {
        checkBlankCarName(names);
        checkLengthCarName(names);
        checkDuplicateCar(names);
        checkCountOfCar(names);
    }

    private static void checkBlankCarName(String[] names) {
        if (Arrays.stream(names).anyMatch(n -> n == null || n.trim().isEmpty())) {
            throw new InvalidCarSettingException(INVALID_BLANK_CAR_NAME_MESSAGE);
        }
    }

    private static void checkLengthCarName(String[] names) {
        if (Arrays.stream(names).anyMatch(n -> n.length() > 5)) {
            throw new InvalidCarSettingException(INVALID_LENGTH_CAR_NAME_MESSAGE);
        }
    }

    private static void checkDuplicateCar(String[] names) {
        if (names.length != Arrays.stream(names).distinct().count()) {
            throw new InvalidCarSettingException(INVALID_DUPLICATE_CAR_NAME_MESSAGE);
        }
    }

    private static void checkCountOfCar(String[] names) {
        if (names.length <= 1) {
            throw new InvalidCarSettingException(INVALID_CAR_COUNT_MESSAGE);
        }
    }

    public static void checkCountOfGame(String racingTime) {
        if (checkNumberValidation(racingTime) < 1) {
            throw new InvalidUserInputException(INVALID_GAME_COUNT_MESSAGE);
        }
    }

    private static int checkNumberValidation(String StrNumber) {
        try {
            Integer.parseInt(StrNumber);
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException(INVALID_STRING_MESSAGE);
        }

        return Integer.parseInt(StrNumber);
    }
}
