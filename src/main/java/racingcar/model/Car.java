package racingcar.model;

public class Car {
    private Position position;
    private MovingStrategy movingStrategy = new PositionControl();


    public Car() {
        this(new Position());
    }

    Car(Position position) {
        this.position = position;
    }

    public void move(int randomValue) {
        if (movingStrategy.matchMovementCondition(randomValue)) {
            position.increaseValue();
        }
    }


    public int currentPosition() {
        return position.getValue();
    }
}
