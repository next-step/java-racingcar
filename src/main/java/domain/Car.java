package domain;

public class Car {

    private Position position;
    private static final int MOVING_SIZE = 1;

    public Car() {
        this.position = new Position(0);
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.position = new Position(position.getPosition() + MOVING_SIZE);
        }
    }

    public int getPosition() {
        return position.getPosition();
    }
}
