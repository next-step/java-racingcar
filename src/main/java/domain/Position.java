package domain;

public class Position {
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Position move() {
        return new Position(this.value + 1);
    }
}
