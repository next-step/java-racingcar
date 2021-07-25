package racingcar.util;

import racingcar.exception.InvalidUserInputException;

public class ValidationUtil {

    private static final String INVALID_STRING_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String INVALID_CAR_COUNT_MESSAGE = "2개 이상의 자동차를 입력해야 시작 가능합니다.";
    private static final String INVALID_GAME_COUNT_MESSAGE = "1회 이상의 게임 횟수를 입력해야 시작 가능합니다.";

    public static void checkUserInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_STRING_MESSAGE);
        }
    }

    public static void checkCountOfCar(int number) {
        if (number <= 1) {
            throw new InvalidUserInputException(INVALID_CAR_COUNT_MESSAGE);
        }
    }

    public static void checkCountOfGame(int number) {
        if (number <= 0) {
            throw new InvalidUserInputException(INVALID_GAME_COUNT_MESSAGE);
        }
    }
}
