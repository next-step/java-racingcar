package racing.domain;

public class Car {
    private final int MOVE_THRESHOLD = 4;
    private final Position position;

    public Car() {
        this.position = new Position(0);
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public void move(int input) {
        if (isMovable(input)) {
            position.setValue(position.getValue() + 1);
        }
    }

    private boolean isMovable(int input) {
        return input >= MOVE_THRESHOLD;
    }
}
