package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static final String INVALID_NAME_ERROR_MESSAGE = "자동차 이름은 숫자와 문자 조합이고 5자를 초과할 수 없습니다.";
    public static final String INVALID_ROUND_ERROR_MESSAGE = "입력한 숫자는 0 보다 커야 합니다.";
    private static final String NO_NAME_ERROR_MESSAGE = "자동차 이름 입력값이 없습니다.";
    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final String SPACE = " ";
    public static final int MIN_VALUE = 1;

    private InputValidator() {
    }

    public static List<String> validateCarName(String inputCarName) {
        if (isEmpty(inputCarName)) {
            throw new IllegalArgumentException(NO_NAME_ERROR_MESSAGE);
        }

        inputCarName = removeBlank(inputCarName.trim());
        return Arrays.asList(inputCarName.split(COMMA));
    }

    private static String removeBlank(String input) {
        return input.replace(SPACE, BLANK);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static int validateRound(int count) {
        if(count < MIN_VALUE) {
            throw new IllegalArgumentException(INVALID_ROUND_ERROR_MESSAGE);
        }
        return count;
    }

}
