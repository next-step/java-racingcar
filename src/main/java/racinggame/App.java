package racinggame;

import racinggame.car.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class App {

    public static void main(String[] args) {
        String carNames = InputView.inputNameOfCar();
        int countNumber = InputView.inputNumberOfCount();

        RacingGame racingGame = RacingGame.of(carNames, countNumber);
        ResultView resultView = racingGame.play();

        resultView.printResult();
    }
}
