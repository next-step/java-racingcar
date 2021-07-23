package racing.car;

public class Fuel {
    public static Fuel EMPTY = new Fuel(0);
    public static Fuel FULL = new Fuel(9);

    private static final String OVER_FULL_MESSAGE = "최대 충전 가능한 연료를 넘었습니다.";
    private static final String UNDER_EMPTY_MESSAGE = "연료는 음수르 충전할 수 없습니다.";

    protected final int value;

    public Fuel(int value) {
        this.value = value;
    }

    private static void validate(int value) {
        if (value < 0)
            throw new IllegalArgumentException(UNDER_EMPTY_MESSAGE);
        if (value > FULL.value)
            throw new IllegalArgumentException(OVER_FULL_MESSAGE);
    }

    public boolean isMovable(int requireFuelValue) {
        validate(value); // 유효성 검사 Lazy
        return this.value >= requireFuelValue;
    }
}
