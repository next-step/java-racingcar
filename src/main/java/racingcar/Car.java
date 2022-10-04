package racingcar;

public class Car {

    private static final int AVAILABLE_MOVE_BOUND = 4;

    private int totalMoveCount;

    public int totalMoveCount() {
        return totalMoveCount;
    }

    public void move(int number) {
        if (number >= AVAILABLE_MOVE_BOUND) {
            this.totalMoveCount += 1;
        }
    }
}
