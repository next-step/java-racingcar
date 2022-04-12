package racingcar.model;

public class Car {
    private Position position;
    private PositionControl positionControl = new PositionControl();

    public Car() {
        this(new Position());
    }

    Car(Position position) {
        this.position = position;
    }

    public void move() {
        if (positionControl.matchMovementCondition(RandomRange.getRandomValue())) {
            position.increaseValue();
        }
    }

    public int currentPosition() {
        return position.getValue();
    }
}
