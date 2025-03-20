package racingcar.model;

import racingcar.message.ErrorMessage;

public final class Car {

    private final String name;
    private final Position position;

    private static final int MOVE_CONDITION_NUMBER = 4;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String SEPERATOR = ":";

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = new Position(0);
    }

    public Car(String name, Position initialPosition) {
        validateName(name);
        this.name = name;
        this.position = initialPosition;
    }

    private void validateName(String name) {
        if (invalidName(name)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME);
        }
    }

    private boolean invalidName(String name) {
        return name.isBlank() || name.length() > MAXIMUM_NAME_LENGTH;
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

    public boolean isAtPosition(Position other) {
        return position.isSameAs(other);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public String toString() {
        return name + SEPERATOR + position;
    }
}
