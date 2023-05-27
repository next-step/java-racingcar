package racinggame.domain;

public class NonMovableMoveStrategy implements MoveStrategy {
    private static final int THRESHOLD = 4;
    public boolean canMove() {
        int randomNumber = 3;
        return randomNumber >= THRESHOLD;
    }
}
