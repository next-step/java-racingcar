package racingcar.model;

import java.util.List;

public class Position {

    public static final int START_POSITION = 0;

    private int value;

    public Position() {
         this.value = START_POSITION;
    }

    public Position(int value) {
        this.value = value;
    }

    public static Position biggestPosition(List<Position> positions) {
        int biggestValue = positions.stream()
                .mapToInt(v -> v.value)
                .max()
                .orElse(START_POSITION);
        return new Position(biggestValue);
    }

    public void moveForward() {
        this.value++;
    }

    public boolean greaterThanOrEqual(Position position) {
        return this.value >= position.value;
    }

    public int getValue() {
        return value;
    }
}
