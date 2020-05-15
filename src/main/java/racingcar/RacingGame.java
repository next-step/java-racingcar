package racingcar;

import racingcar.moving.MovingStrategy;
import racingcar.moving.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {

    public static void main(String[] args) {
        int numOfCar = InputView.inputNumOfCar();
        int loopCount = InputView.inputLoopCount();

        MovingStrategy movingStrategy = new RandomMovingStrategy();
        Racing racing = Racing.of(numOfCar);

        ResultView.printResultMessage();
        for (int i = 0; i < loopCount; i++) {
            racing.run(movingStrategy);
            List<Car> cars = racing.getCars();
            ResultView.printResult(cars);
        }
    }
}
