package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.domain.Round;
import racingcar.moving.MovingStrategy;
import racingcar.moving.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

    public static void main(String[] args) {
        String carNames = InputView.inputNameOfCars();
        int round = InputView.inputLoopCount();

        Racing racing = Racing.of(Cars.of(carNames), Round.of(round));
        MovingStrategy movingStrategy = new RandomMovingStrategy();

        ResultView.printResultMessage();
        while (!racing.isGameOver()) {
            racing.run(movingStrategy);
            ResultView.printResult(racing.getCars());
        }
        ResultView.printWinner(racing.getWinnerCars());
    }
}
