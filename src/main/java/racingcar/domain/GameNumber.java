package racingcar.domain;

public class GameNumber {

    private static final int VALID_MIN_NUMBER = 0;
    private static final int VALID_MAX_NUMBER = 9;

    public static final int MOVABLE_MIN_NUMBER = 4;

    private final int value;

    private GameNumber(int value) {
        this.value = value;
    }

    public static GameNumber newNumber(int number) {
        checkNumber(number);

        return new GameNumber(number);
    }

    private static void checkNumber(int number) {
        if (number < VALID_MIN_NUMBER || number > VALID_MAX_NUMBER) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
    }

    public int gameNumber() {
        return value;
    }

    public boolean isMovableNumber() {
        return value >= MOVABLE_MIN_NUMBER;
    }
}
