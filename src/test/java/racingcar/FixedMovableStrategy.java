package racingcar;

public final class FixedMovableStrategy implements MovableStrategy {

    private final int value;

    public FixedMovableStrategy(final int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return this.value;
    }
}
