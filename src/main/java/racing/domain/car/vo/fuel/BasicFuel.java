package racing.domain.car.vo.fuel;

public class BasicFuel implements Fuel {
    private static final String OVER_FULL_MESSAGE = "최대 충전 가능한 연료를 넘었습니다.";
    private static final String UNDER_EMPTY_MESSAGE = "연료는 음수르 충전할 수 없습니다.";

    private final int value;

    public BasicFuel(int value) {
        validate(value);
        this.value = value;
    }

    public int value() {
        return value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE)
            throw new IllegalArgumentException(UNDER_EMPTY_MESSAGE);
        if (value > MAX_VALUE)
            throw new IllegalArgumentException(OVER_FULL_MESSAGE);
    }
}
