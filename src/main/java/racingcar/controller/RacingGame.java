package racingcar.controller;

import racingcar.domain.CarCondition;
import racingcar.domain.Cars;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

import java.util.List;

public class RacingGame {

    public void start() {
        List<String> carNames = ConsoleInput.getCarNames();
        int movementCount = ConsoleInput.getMovementCount();

        Cars cars = Cars.of(carNames);

        ConsoleOutput.resultMessage();
        for (int i = 0; i < movementCount; i++) {
            ConsoleOutput.printStatus(cars.move(new CarCondition()));
        }
        ConsoleOutput.printWinner(cars.findWinners());
    }

}
