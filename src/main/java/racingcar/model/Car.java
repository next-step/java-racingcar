package racingcar.model;

import static racingcar.view.OutputView.NAME_POSITION_SEPERATOR;

public final class Car {

    private final CarName name;
    private final Position position;

    private static final int MOVE_CONDITION_NUMBER = 4;

    public Car(CarName name) {
        this(name, new Position(0));
    }

    public Car(CarName name, Position initialPosition) {
        this.name = name;
        this.position = initialPosition;
    }

    public Car move(int randomValue) {
        if (canMove(randomValue)) {
            return new Car(this.name, this.position.incrementPosition());
        }
        return this;
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MOVE_CONDITION_NUMBER;
    }

    public boolean matches(CarName carName) {
        return this.name.equals(carName);
    }

    public boolean isAtPosition(Position other) {
        return position.isSameAs(other);
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public String toString() {
        return name + NAME_POSITION_SEPERATOR + position;
    }
}
