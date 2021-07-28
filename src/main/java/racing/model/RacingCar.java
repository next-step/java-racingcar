package racing.model;

public class RacingCar {
    private final RacingCarName name;
    private final RacingCarPosition position;

    RacingCar(String name) {
        this.name = RacingCarName.valueOf(name);
        this.position = new RacingCarPosition();
    }

    void moveForwardOneStepOrStop(MovingCondition movingCondition) {
        if (movingCondition.isMovable()) {
            position.increaseOne();
        }
    }

    String getName() {
        return name.getName();
    }

    int getPosition() {
        return position.getPosition();
    }
}
