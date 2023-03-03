package racingCar;

public enum RacingCarConfiguration {
    MAX_RANDOM_VALUE(10),
    LIMIT_RANDOM_VALUE(4);

    private final int value;

    RacingCarConfiguration(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}