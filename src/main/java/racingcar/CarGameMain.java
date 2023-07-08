package racingcar;

import racingcar.car.domain.CarGameManager;
import racingcar.car.view.InputView;
import racingcar.car.view.OutputView;

public class CarGameMain {

    public static void main(String[] args) {
        CarGameManager racingGame = new CarGameManager(InputView.getCarNames(), InputView.getPlayCount());
        while (racingGame.isRunning()) {
            racingGame.race();
            OutputView.printStatus(racingGame.getMiddleState());
        }
        OutputView.printResult(racingGame.getResult());
    }
}
