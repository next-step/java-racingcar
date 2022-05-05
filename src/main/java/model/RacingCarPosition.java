package model;

public class RacingCarPosition {
    private int value;

    public RacingCarPosition() {
        this.value = 0;
    }

    public RacingCarPosition(int value) {
        this.value = value;
    }

    public void add() {
        this.value += 1;
    }

    public int getValue() {
        return this.value;
    }
}
