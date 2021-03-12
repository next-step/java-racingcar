package racingcar;

public interface Car {

    Name getName();

    Distance getDistance();

    Distance forward(MovementCondition movementCondition);
}
