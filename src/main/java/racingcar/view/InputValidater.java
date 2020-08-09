package racingcar.view;

import racingcar.model.RacingCar;

import java.util.Arrays;
import java.util.List;

public class InputValidater {
    private static final String INVALID_NAME_ERROR_MESSAGE = "자동차 이름은 숫자와 문자 조합이고 5자를 초과할 수 없습니다.";
    private static final String NO_NAME_ERROR_MESSAGE = "자동차 이름 입력값이 없습니다.";
    private static final String NOT_INTEGER_ERROR_MESSAGE = "입력된 횟수가 숫자가 아니라 문자 입니다.";
    private static final String COMMA = ",";

    private InputValidater() {
    }

    public static final List<String> validateCarNames(String inputCarName) {

        if (inputCarName == null || inputCarName.isEmpty()) {
            throw new IllegalArgumentException(NO_NAME_ERROR_MESSAGE);
        }

        List<String> carNames = Arrays.asList(inputCarName.split(COMMA));
        boolean isCorrectCarName = carNames.stream().allMatch(carName -> RacingCar.validateCarName(carName));
        if(!isCorrectCarName) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR_MESSAGE);
        }
        return carNames;
    }

    public static final int validateRound(String round) {
        try {
            return Integer.parseInt(round);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }
}
