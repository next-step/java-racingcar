package racingcar;

public final class Distance {
    private final PositiveInteger value;

    public Distance(PositiveInteger distance) {
        this.value = distance;
    }

    public PositiveInteger value() {
        return value;
    }
}
