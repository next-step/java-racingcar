package racingGame;

public class Car {

    private static final int MINIMUM_MOVABLE_SCORE = 4;

    private int position;

    public Car() {
        position = 0;
    }

    public void moveForward(int score) {
        if (canMove(score)) {
            position++;
        }
    }

    public int getCurrentPosition() {
        return position;
    }

    private boolean canMove(int score) {
        return score >= MINIMUM_MOVABLE_SCORE;
    }
}
