package game.domain.policy;

public class StandardCarMovePolicy implements CarMovePolicy {
    @Override
    public boolean isMovable(int input) {
        return input > 4;
    }
}