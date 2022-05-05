package model;

public class RacingCarPosition {
    private final int value;

    public RacingCarPosition() {
        this.value = 0;
    }

    public RacingCarPosition(int value) {
        this.value = value;
    }

    public RacingCarPosition add() {
        return new RacingCarPosition(this.value + 1);
    }

    public int getValue() {
        return this.value;
    }
}
