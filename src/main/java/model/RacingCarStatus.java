package model;

public class RacingCarStatus {
    private int value;

    public RacingCarStatus() {
        this.value = 0;
    }

    public RacingCarStatus(int value) {
        this.value = value;
    }

    public void add() {
        this.value += 1;
    }

    public int getValue() {
        return this.value;
    }
}
