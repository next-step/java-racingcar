package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.MoveCommand;

public class RacingCarService {
    private final MoveCommand moveCommand;

    public RacingCarService(MoveCommand moveCommand) {
        this.moveCommand = moveCommand;
    }

    public void moveCar(Car car) {
        car.move(moveCommand.command());
    }
}
