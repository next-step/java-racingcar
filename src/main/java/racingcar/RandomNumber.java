package racingcar;

public class RandomNumber {
    private static final int STANDARD_TO_GO = 4;
    private final int number;

    public RandomNumber(int number) {
        this.number = number;
    }

    public boolean isMovable() {
        return this.number >= STANDARD_TO_GO;
    }
}
