package racinggame.domain;

public class MovableMoveStrategy implements MoveStrategy {
    private static final int THRESHOLD = 4;
    public boolean canMove() {
        int randomNumber = 4;
        return randomNumber >= THRESHOLD;
    }
}
