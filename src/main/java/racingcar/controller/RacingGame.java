package racingcar.controller;

import racingcar.model.CarCondition;
import racingcar.model.Cars;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

import java.util.List;

public class RacingGame {

    private static final ConsoleInput INPUT = new ConsoleInput();
    private static final ConsoleOutput OUTPUT = new ConsoleOutput();

    public void start() {
        List<String> carNames = INPUT.getCarNames();
        int movementCount = INPUT.getMovementCount();

        Cars cars = Cars.of(carNames);

        OUTPUT.resultMessage();
        for (int i = 0; i < movementCount; i++) {
            OUTPUT.status(cars.move(new CarCondition()));
        }
        OUTPUT.winner(cars.getWinners());
    }

}
