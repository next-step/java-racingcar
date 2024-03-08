package model;

public class Car {
    private int position;

    public Car() {
        this(1);
    }

    public Car(int position) {
        this.position = position;
    }

    public void move(int random) {
        if (random >= 4) {
            this.position += 1;
        }
    }

    public boolean isSamePosition(int other) {
        return this.position == other;
    }
}
