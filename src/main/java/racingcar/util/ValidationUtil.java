package racingcar.util;

import racingcar.car.Position;
import racingcar.exception.InvalidCarException;
import racingcar.exception.InvalidUserInputException;

public class ValidationUtil {

    private final static String CAR_DISTANCE_MESSAGE = "위치가 올바르지 않습니다.";

    private final static String INPUT_STRING_MESSAGE = "숫자만 입력 가능합니다.";
    private final static String INPUT_ZERO_MESSAGE = "0은 입력이 불가합니다.";
    private final static String INPUT_CAR_NUMBER_MESSAGE = "2개 이상의 자동차를 입력해야 시작 가능합니다.";

    public static int checkUserInput(String input) {
        int inputValue;

        try {
            inputValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_STRING_MESSAGE);
        }

        if (inputValue == 0) {
            throw new InvalidUserInputException(INPUT_ZERO_MESSAGE);
        }

        return inputValue;
    }

    public static void checkNumberOfCar(int number) {
        if (number <= 1) {
            throw new InvalidUserInputException(INPUT_CAR_NUMBER_MESSAGE);
        }
    }

    public static void validatePosition(int position) {
        if (position < Position.defaultDistance || Position.forwardDistance < position) {
            throw new InvalidCarException(CAR_DISTANCE_MESSAGE);
        }
    }
}
