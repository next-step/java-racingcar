package racing.car;


import java.util.stream.IntStream;

public enum DistanceRange {
    BACK_MOVEMENT(-1),
    NOT_MOVEMENT(0),
    MIN_MOVEMENT(4),
    MAX_MOVEMENT(9);

    private int value;

    DistanceRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DistanceRange of(int distance) { // distance에 값에 따라 해당하는 범위의 객체 반환
        return IntStream.range(1, values().length)
                .filter(
                        i -> distance <= values()[i].getValue()
                ).mapToObj(
                        i -> values()[i - 1]
                ).findFirst()
                .orElse(MAX_MOVEMENT);
    }
}