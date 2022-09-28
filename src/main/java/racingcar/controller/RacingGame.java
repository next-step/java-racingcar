package racingcar.controller;

import racingcar.model.CarNameSeparator;
import racingcar.model.Cars;
import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

public class RacingGame {

    private static final ConsoleInput INPUT = new ConsoleInput();
    private static final ConsoleOutput OUTPUT = new ConsoleOutput();

    public void start() {
        String carQuantity = INPUT.getCarNames();
        int movementCount = INPUT.getMovementCount();

        Cars cars = new Cars(CarNameSeparator.separateNames(carQuantity));

        OUTPUT.resultMessage();
        for (int i = 0; i < movementCount; i++) {
            OUTPUT.status(cars.move());
        }
        OUTPUT.winner(cars.getWinners());
    }

}
