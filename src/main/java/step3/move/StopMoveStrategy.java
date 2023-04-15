package step3.move;

public class StopMoveStrategy implements MoveStrategy {
    private static final int distance = 0;
    @Override
    public int moveAmount() {
        return distance;
    }
}
