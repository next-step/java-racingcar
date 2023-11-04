package me.namuhuchutong.step3;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(boolean moveCondition) {
        if (moveCondition) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getPositionToString() {
        return "-".repeat(this.position);
    }
}
