package racingcar;

import racingcar.moving.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        int numOfCar = InputView.inputNumOfCar();
        int loopCount = InputView.inputLoopCount();

        Racing racing = Racing.of(numOfCar, new RandomMovingStrategy());
        ResultView.printResultMessage();
        for (int i = 0; i < loopCount; i++) {
            racing.run();
            List<Car> cars = racing.getCars();
            ResultView.printResult(cars);
        }
    }
}
