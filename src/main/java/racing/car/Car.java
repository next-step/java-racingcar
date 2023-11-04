package racing.car;

public class Car {
    private int THRESHOLD = 4;
    private Position position;

    public Car() {
        this.position = new Position(0);
    }

    public Position position() {
        return this.position;
    }

    public void move(int input) {
        if (isOverThreshHold(input)) {
            Position currentPosition = this.position();
            this.position = currentPosition.move(1);
        }
    }

    private boolean isOverThreshHold(int input) {
        return THRESHOLD <= input;
    }
}
