package racinggame;

import racinggame.domain.Car;
import racinggame.domain.Position;
import racinggame.domain.RacingGame;
import racinggame.domain.RandomMovingStrategy;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        RacingGame racingGame = new RacingGame(inputView.inputTryCount());
        racingGame.initcars(inputView.inputCarCount());
        resultView.printResultMessage();
        while (racingGame.getTryCount() > 0) {
            resultView.printResul(racingGame, randomMovingStrategy);
        }

    }
}
