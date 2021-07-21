package racinggame;

import racinggame.car.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class App {

    public static void main(String[] args) {
        int carNumber = InputView.inputNumberOfCar();
        int countNumber = InputView.inputNumberOfCount();

        RacingGame racingGame = RacingGame.of(carNumber, countNumber);
        ResultView resultView = racingGame.play();

        resultView.printResult();
    }
}
