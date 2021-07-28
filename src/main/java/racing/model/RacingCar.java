package racing.model;

public class RacingCar {
    private final Position position;

    RacingCar() {
        position = new Position();
    }

    void moveForwardOneStepOrStop(MovingCondition movingCondition) {
        if (movingCondition.isMovable()) {
            position.increaseOne();
        }
    }

    int getPosition() {
        return position.getPosition();
    }
}
