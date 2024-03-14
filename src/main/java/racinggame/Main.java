package racinggame;

import racinggame.domain.*;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        String cars = inputView.inputCarsName();
        RacingGame racingGame = new RacingGame(inputView.inputTryCount());
        racingGame.initCars(cars);
        resultView.printResultMessage();
        while (racingGame.getTryCount() > 0) {
            resultView.printResul(racingGame, randomMovingStrategy);
        }
        resultView.printWinner(racingGame);
    }
}
