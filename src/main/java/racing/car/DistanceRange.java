package racing.car;


import java.util.Arrays;

public enum DistanceRange {
    BACK_MOVEMENT(0),
    NOT_MOVEMENT(4),
    MOVEMENT(10),
    LIMIT_MOVEMENT(Integer.MAX_VALUE);

    public static int NOT_MOVEMENT_VALUE = 0;

    private final int rangeMinValue;

    DistanceRange(int rangeMinValue) {
        this.rangeMinValue = rangeMinValue;
    }

    @SuppressWarnings("all")
    public static DistanceRange of(int distance) { // distance에 값에 따라 해당하는 범위의 객체 반환
        return Arrays.stream(values())
                .filter(r -> distance < r.rangeMinValue)
                .findFirst()
                .get(); // 절대 Null 아닌 Optional
    }
}