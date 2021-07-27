package racingcar;

import racingcar.car.Cars;
import racingcar.car.RacingGame;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        Cars cars = Cars.of(carNames);
        RacingGame racingGame = new RacingGame(cars);

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            racingGame.race(new RandomMoveStrategy());
            ResultView.show(racingGame.getCars());
        }
        ResultView.printRaceWinners(racingGame.getRaceWinners());
    }

}
