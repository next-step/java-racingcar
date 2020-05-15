package racingcar;

import racingcar.moving.MovingStrategy;
import racingcar.moving.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

    public static void main(String[] args) {
        String[] carNames = InputView.inputNameOfCars();
        int loopCount = InputView.inputLoopCount();

        Racing racing = Racing.of(Cars.of(carNames));
        MovingStrategy movingStrategy = new RandomMovingStrategy();

        ResultView.printResultMessage();
        for (int i = 0; i < loopCount; i++) {
            racing.run(movingStrategy);
            ResultView.printResult(racing.getCars());
        }
        ResultView.printWinner(racing.getWinnerCars());
    }
}
