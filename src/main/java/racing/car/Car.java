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
            int currentPosition = this.position().position();
            this.position = new Position(currentPosition + 1);
        }
    }

    private boolean isOverThreshHold(int input) {
        return THRESHOLD <= input;
    }
}
