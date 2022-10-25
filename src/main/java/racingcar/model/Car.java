package racingcar.model;

import racingcar.ExceptionMessageUtils;

public final class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final MovePolicy movePolicy;
    private final MoveCondition moveCondition;
    private Distance distance;

    public Car(final String name, final MovePolicy movePolicy, final MoveCondition moveCondition) {
        validateName(name);
        validateMovePolicy(movePolicy);
        validateMoveCondition(moveCondition);
        this.name = name.trim();
        this.movePolicy = movePolicy;
        this.moveCondition = moveCondition;
        this.distance = Distance.ZERO;
    }

    private static void validateName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "Car name cannot be null"));
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "Car name cannot be blank"));
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "Car name is too long"));
        }
    }

    private static void validateMoveCondition(final MoveCondition moveCondition) {
        if (moveCondition == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "MoveCondition cannot be null"));
        }
    }

    private static void validateMovePolicy(final MovePolicy movePolicy) {
        if (movePolicy == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "MovePolicy cannot be null"));
        }
    }

    public void move() {
        if (!moveCondition.isMovable()) {
            return;
        }
        distance = distance.plus(movePolicy.getSteps());
    }

    public Distance getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}

