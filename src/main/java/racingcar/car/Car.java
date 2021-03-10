package racingcar.car;

import racingcar.Position;

public interface Car {
    int moveForward(int randomNumber);

    String getName();

    Position getPosition();
}
