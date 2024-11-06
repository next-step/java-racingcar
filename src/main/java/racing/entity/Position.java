package racing.entity;

public class Position {
    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Position cannot be negative.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Position movePosition() {
        return new Position(value + 1);
    }
}