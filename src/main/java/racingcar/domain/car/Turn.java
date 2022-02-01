package racingcar.domain.car;

import java.util.regex.Pattern;
import racingcar.domain.dto.TurnRequestDto;

public class Turn {

    private static final int MINIMUM_INPUT_VALUE = 1;
    private static final String TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String TURN_NOT_NUMBER_ERROR_MESSAGE = "입력한 값은 숫자가 아닙니다.";
    private static final String TURN_NOT_NATURAL_NUMBER_ERROR_MESSAGE = "시도할 횟수는 " + MINIMUM_INPUT_VALUE + " 이상이어야 합니다.";
    private static final Pattern DIGIT = Pattern.compile("[+-]?\\d*(\\.\\d+)?");

    private final int value;

    public Turn(String input) {
        validateTurn(input);
        this.value = Integer.valueOf(input);
    }

    public static Turn createTurn(String input) {
        return new Turn(input.trim());
    }

    public static void validateTurn(String turn) {
        if (turn.trim().isEmpty()) {
            throw new IllegalArgumentException(TURN_MESSAGE);
        }
        if (!DIGIT.matcher(turn).matches()) {
            throw new NumberFormatException(TURN_NOT_NUMBER_ERROR_MESSAGE);
        }
        if (Integer.parseInt(turn) < MINIMUM_INPUT_VALUE) {
            throw new IllegalArgumentException(TURN_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }
}
