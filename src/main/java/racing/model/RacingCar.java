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

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    boolean isEqualPosition(int position) {
        return this.position.isEqual(position);
    }
}
