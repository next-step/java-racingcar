package racing.model;

public class RacingCar {
    private static final int MOVABLE_MIN_NUMBER = 4;

    private Position position;

    RacingCar() {
        position = new Position();
    }

    void moveOrStop(Number number) {
        if (number.isGreaterThanOrEqualTo(MOVABLE_MIN_NUMBER)) {
            position.increaseOne();
        }
    }

    int getPosition() {
        return position.getPosition();
    }
}
