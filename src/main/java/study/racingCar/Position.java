package study.racingCar;

public class Position {
    private final int currentPosition;

    public Position() {
        this(0);
    }

    public Position(int currentPosition) {
        if (currentPosition < 0) {
            throw new IllegalArgumentException();
        }
        this.currentPosition = currentPosition;
    }

    public Position increse() {
        return new Position(this.currentPosition + 1);
    }
}
