package racing.model;

public class RacingCar implements Comparable<RacingCar> {
    private final RacingCarName name;
    private final RacingCarPosition position;

    RacingCar(String name) {
        this.name = new RacingCarName(name);
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

    boolean isEqualPosition(RacingCar racingCar) {
        return position.equals(racingCar.position);
    }

    @Override
    public int compareTo(RacingCar racingCar) {
        return position.compareTo(racingCar.position);
    }
}
