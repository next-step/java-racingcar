package domain;

import java.util.Arrays;

public class CarPosition {
    private static final String COMMA = ",";
    private final int[] position;

    public CarPosition(String position) {
        this.position = intArray(position);
    }

    private int[] intArray(String position) {
        return Arrays.stream(position.split(COMMA))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int size() {
        return position.length;
    }
}
