package racingcar.domain;

import java.util.regex.Pattern;
import racingcar.view.UserConsole;

public class Turn {

    private static final String TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String TURN_NOT_NUMBER_ERROR_MESSAGE = "입력한 값은 숫자가 아닙니다.";
    private static final String TURN_NOT_NATURAL_NUMBER_ERROR_MESSAGE = "시도할 횟수는 1 이상이어야 합니다.";
    private static final Pattern DIGIT = Pattern.compile("[+-]?\\d*(\\.\\d+)?");
    private final int value;

    private Turn() {
        this.value = Integer.valueOf(setTurn());
    }

    public static Turn getInstance() {
        return new Turn();
    }

    private String setTurn() {
        String turn = UserConsole.getConsoleTextFrom(TURN_MESSAGE).trim();
        try {
            validateTurn(turn);
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
            return setTurn();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return setTurn();
        }

        return turn;
    }

    public static void validateTurn(String turn) {
        if (turn.trim().isEmpty()) {
            throw new IllegalArgumentException(TURN_MESSAGE);
        }
        if (!DIGIT.matcher(turn).matches()) {
            throw new NumberFormatException(TURN_NOT_NUMBER_ERROR_MESSAGE);
        }
        if (Integer.parseInt(turn) < 1) {
            throw new IllegalArgumentException(TURN_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }
}
