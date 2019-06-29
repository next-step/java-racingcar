package racingcar.domain.moving;

public class MockMovingStrategy implements MovingStrategy {

    private boolean move;

    public MockMovingStrategy(boolean move) {
        this.move = move;
    }

    @Override
    public boolean movable() {
        return move;
    }
}
