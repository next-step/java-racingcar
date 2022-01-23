package racingcar.domain;

import racingcar.view.UserConsole;

public class Turns {

    private static final String TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String TURN_NOT_NUMBER_ERROR_MESSAGE = "입력한 값은 숫자가 아닙니다.";
    private static final String TURN_NOT_NATURAL_NUMBER_ERROR_MESSAGE = "시도할 횟수는 1 이상이어야 합니다.";
    private static final String ERROR_LOG = "[ERROR] ";

    public static int setTurn() {
        String turn;
        try {
            turn = UserConsole.getConsoleTextFrom(TURN_MESSAGE).trim();
            validateTurn(turn);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_LOG + e.getMessage());
            return setTurn();
        }
        return Integer.parseInt(turn);
    }

    public static void validateTurn(String turn) {
        if (turn.trim().isEmpty()) {
            throw new IllegalArgumentException(TURN_MESSAGE);
        }
        if (!turn.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new NumberFormatException(TURN_NOT_NUMBER_ERROR_MESSAGE);
        }
        if (Integer.parseInt(turn) < 1) {
            throw new IllegalArgumentException(TURN_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }
}
