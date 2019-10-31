package step2.domain;

public final class EqualCarDistanceGenerator implements CarDistanceGenerator {
    private final int value;

    public EqualCarDistanceGenerator(final int value) {
        this.value = value;
    }

    @Override
    public int next() {
        return value;
    }
}
