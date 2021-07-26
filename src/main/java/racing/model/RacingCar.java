package racing.model;

public class RacingCar {
    private static final int MOVABLE_MIN_NUMBER = 4;

    private Position position;

    RacingCar() {
        position = new Position();
    }

    void moveOrStop(int number) {
        if (number >= MOVABLE_MIN_NUMBER) {
            position.increaseOne();
        }
    }

    int getPosition() {
        return position.getPosition();
    }
}
