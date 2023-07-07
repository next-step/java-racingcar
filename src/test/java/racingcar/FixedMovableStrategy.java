package racingcar;

public final class FixedMovableStrategy implements MovableStrategy {

    private final boolean move;

    public FixedMovableStrategy(final boolean move) {
        this.move = move;
    }

    @Override
    public boolean isMove() {
        return this.move;
    }
}
