package model;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(MoveStrategy condition) {
        if (condition.isMovable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
