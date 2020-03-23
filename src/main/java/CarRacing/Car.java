package CarRacing;

public class Car {
    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(final RacingStrategy racingStrategy) {
        if (racingStrategy.movable()) {
            this.currentPosition++;
        }
    }
}
