package racingcar.model;

import racingcar.ExceptionMessageUtils;

public final class Car {

    private final MovePolicy movePolicy;
    private final MoveCondition moveCondition;
    private Distance distance;

    public Car(final MovePolicy movePolicy, final MoveCondition moveCondition) {
        validateMovePolicy(movePolicy);
        validateMoveCondition(moveCondition);
        this.movePolicy = movePolicy;
        this.moveCondition = moveCondition;
        this.distance = Distance.ZERO;
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

}

