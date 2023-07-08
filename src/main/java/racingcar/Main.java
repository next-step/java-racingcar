package racingcar;

import racingcar.car.CarRacingGame;
import racingcar.car.view.InputView;
import racingcar.car.view.OutputView;

public class Main {

    public static void main(String[] args) {
        CarRacingGame racingGame = new CarRacingGame(InputView.getCarNames(), InputView.getPlayCount());
        while (racingGame.isRunning()) {
            racingGame.play();
            OutputView.printStatus(racingGame.getMiddleState());
        }
        OutputView.printWinners(racingGame.getResult());
    }
}
