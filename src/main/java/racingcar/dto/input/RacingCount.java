package racingcar.dto.input;

public class RacingCount {

    private final int value;

    public RacingCount(int value) {
        valid(value);
        this.value = value;
    }

    private void valid(int racingCount) {
        if (racingCount < 0) {
            throw new IllegalArgumentException("racing count is not available");
        }
    }

    public int getValue() {
        return value;
    }
}
