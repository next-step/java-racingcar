package racingcar;

import racingcar.car.Cars;
import racingcar.car.RacingGame;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int tryCount = InputView.getTryCount();

        Cars cars = Cars.of(numberOfCars);
        RacingGame racingGame = new RacingGame(cars, new RandomMoveStrategy());

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            racingGame.race();
            ResultView.show(racingGame.getCars());
        }
    }

}
