package racinggame;

public class FakeMoveStrategy implements MoveStrategy {

    private final boolean canMove;

    public FakeMoveStrategy(boolean canMove) {
        this.canMove = canMove;
    }

    @Override
    public boolean canMove() {
        return this.canMove;
    }
}
