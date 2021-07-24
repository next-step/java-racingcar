package racingcar.util;

import racingcar.exception.InvalidUserInputException;

public class ValidationUtil {

    private final static String INPUT_STRING_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
    private final static String INPUT_CAR_COUNT_ERROR_MESSAGE = "2개 이상의 자동차를 입력해야 시작 가능합니다.";
    private final static String INPUT_GAME_COUNT_ERROR_MESSAGE = "1회 이상의 게임 횟수를 입력해야 시작 가능합니다.";

    public static void checkUserInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_STRING_ERROR_MESSAGE);
        }
    }

    public static void checkCountOfCar(int number) {
        if (number <= 1) {
            throw new InvalidUserInputException(INPUT_CAR_COUNT_ERROR_MESSAGE);
        }
    }

    public static void checkCountOfGame(int number) {
        if (number <= 0) {
            throw new InvalidUserInputException(INPUT_GAME_COUNT_ERROR_MESSAGE);
        }
    }
}
