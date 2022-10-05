package racing.strategy;

public class CarMoveStrategy {
    private final static int MOVE_THRESHOLD = 4;

    public boolean canMove(int randomNum) {
        return randomNum >= MOVE_THRESHOLD;
    }
}
