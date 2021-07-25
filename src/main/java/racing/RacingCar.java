package racing;

public class RacingCar {
    private static final int MOVABLE_MIN_VALUE = 4;

    private Position position;

    RacingCar() {
        position = new Position();
    }

    public void moveOrStop(int value) {
        if (value >= MOVABLE_MIN_VALUE) {
            moveForwardOneSpace();
        }
    }

    private void moveForwardOneSpace() {
        position.increaseOne();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
