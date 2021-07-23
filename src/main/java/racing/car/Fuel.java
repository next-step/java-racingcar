package racing.car;

import util.RandomUtils;

public class Fuel {
    public static Fuel EMPTY = new Fuel(0, true);
    public static Fuel FULL = new Fuel(9, true);

    private static final String OVER_FULL_MESSAGE = "최대 충전 가능한 연료를 넘었습니다.";
    private static final String UNDER_EMPTY_MESSAGE = "연료는 음수르 충전할 수 없습니다.";

    protected final int value;

    private Fuel(int value, boolean skipValidate) {
        // init 문제를 막기 위한 생성자
        if (!skipValidate)
            validate(value);
        this.value = value;
    }

    public Fuel(int value) {
        validate(value);
        this.value = value;
    }

    protected Fuel() {
        this.value = EMPTY.value;
    }


    private static void validate(int value) {
        if (value < 0)
            throw new IllegalArgumentException(UNDER_EMPTY_MESSAGE);
        if (value > FULL.value)
            throw new IllegalArgumentException(OVER_FULL_MESSAGE);
    }

    public boolean isMovable(int requireFuelValue) {
        return this.value >= requireFuelValue;
    }
}
