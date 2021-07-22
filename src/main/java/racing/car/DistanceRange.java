package racing.car;


import java.util.Arrays;
import java.util.stream.IntStream;

public enum DistanceRange {
    BACK_MOVEMENT(0),
    NOT_MOVEMENT(4),
    MOVEMENT(10),
    LIMIT_MOVEMENT(Integer.MAX_VALUE);

    public static int NOT_MOVEMENT_VALUE = 0;

    private int value;

    DistanceRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DistanceRange of(int distance) { // distance에 값에 따라 해당하는 범위의 객체 반환
        return Arrays.stream(values())
                .filter(r -> distance < r.getValue())
                .findFirst()
                .orElse(LIMIT_MOVEMENT);
    }
}