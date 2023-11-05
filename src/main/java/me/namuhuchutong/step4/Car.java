package me.namuhuchutong.step4;

public class Car {

    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
    }

    void move(int value) {
        if (3 < value) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
