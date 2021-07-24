package racing.domain.fuel;

public class Fuel {

    private static final String OVER_FULL_MESSAGE = "최대 충전 가능한 연료를 넘었습니다.";
    private static final String UNDER_EMPTY_MESSAGE = "연료는 음수르 충전할 수 없습니다.";

    private static final Object syncObject = new Object();
    protected static int MIN_VALUE = 0;
    protected static int MAX_VALUE = 9;
    private static Fuel empty;
    private static Fuel full;

    private final int value;

    public Fuel(int value) {
        validate(value);
        this.value = value;
    }

    public static Fuel empty() {
        if (empty == null) {
            synchronized (syncObject) {
                if (empty == null)
                    empty = new Fuel(MIN_VALUE);
            }
        }
        return empty;
    }

    public static Fuel full() {
        if (full == null) {
            synchronized (syncObject) {
                if (full == null)
                    full = new Fuel(MAX_VALUE);
            }
        }
        return full;
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
