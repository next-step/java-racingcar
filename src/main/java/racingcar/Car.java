package racingcar;

public interface Car {
    String getName();

    Distance getDistance();

    Distance forward(MovementCondition movementCondition);
}
