package racingcar.domain.movable;

public class FixedForwardStrategy implements MovableStrategy {

    private final boolean isMoved;

    public FixedForwardStrategy(final boolean isMoved) {
        this.isMoved = isMoved;
    }

    @Override
    public boolean move(final int number) {
        return isMoved;
    }
}
