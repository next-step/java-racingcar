package racingcar.domain;

public interface Car {

    Name getName();

    Distance getDistance();

    Distance forward(MovementCondition movementCondition);
}
