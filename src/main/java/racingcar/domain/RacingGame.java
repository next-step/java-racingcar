package racingcar.domain;

import java.util.List;

import racingcar.behavior.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;


public class RacingGame {
    public void start() {
        String [] nameOfCars = InputView.inputNameOfCars();
        int loopCount = InputView.inputLoopCount();

        RacingCars racingCars = RacingCars.of(nameOfCars, new RandomMovingStrategy());
        ResultView.printResultMessage();
        for (int i = 0; i < loopCount; i++) {
            racingCars.run();
            List<Car> cars = racingCars.getCars();
            ResultView.printResult(cars);
        }
    }
}
