package racingcar.domain;

public class GameNumber {

    private final int value;

    public static final int MOVABLE_MIN_NUMBER = 4;

    private GameNumber(int value) {
        this.value = value;
    }

    public static GameNumber newNumber(int number) {
        checkNumber(number);

        return new GameNumber(number);
    }

    private static void checkNumber(int number) {
        if (number < 0 || number > 9) {
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
