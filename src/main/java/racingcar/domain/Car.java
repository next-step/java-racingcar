package racingcar.domain;

import racingcar.ExceptionMessageUtils;

public final class Car {

    private final CarName carName;
    private final MovePolicy movePolicy;
    private final MoveCondition moveCondition;
    private Distance distance;

    public Car(final CarName carName, final MovePolicy movePolicy,
        final MoveCondition moveCondition) {
        validateCarName(carName);
        validateMovePolicy(movePolicy);
        validateMoveCondition(moveCondition);
        this.carName = carName;
        this.movePolicy = movePolicy;
        this.moveCondition = moveCondition;
        this.distance = Distance.ZERO;
    }

    private static void validateCarName(final CarName carName) {
        if (carName == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "CarName cannot be null"));
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

    public boolean isFartherMovedThan(final Car other) {
        return distance.isGreaterThan(other.getDistance());
    }

    public boolean isLessMovedThan(final Car other) {
        return distance.isLessThan(other.getDistance());
    }

    public boolean hasSameDistanceWith(final Car other) {
        return distance.equals(other.getDistance());
    }

    public Distance getDistance() {
        return distance;
    }

    public CarName getName() {
        return carName;
    }
}

