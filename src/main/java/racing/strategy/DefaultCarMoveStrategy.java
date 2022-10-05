package racing.strategy;

public class DefaultCarMoveStrategy implements CarMoveStrategy {

    private final static int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove(int randomNum) {
        return randomNum >= MOVE_THRESHOLD;
    }
}
