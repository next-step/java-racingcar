package race;

import race.domain.MoveStrategy;
import race.domain.Cars;
import race.domain.RacingGame;
import race.domain.RnadomMoveStrategy;
import race.domain.Winners;
import race.view.InputView;
import race.view.ResultView;

public class RacingGameMain {

    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames().split(",");
        int numberOfTry = InputView.inputNumberOfTry();

        Cars cars = new Cars(carNames);
        MoveStrategy moveStrategy = new RnadomMoveStrategy();
        RacingGame racingGame = new RacingGame(cars, moveStrategy);

        for (int i = 0; i < numberOfTry; i++) {
            racingGame.play();
            ResultView.printCarPosition(cars);
        }

        Winners winners = new Winners(cars);

        ResultView.printResult(winners);
    }
}
