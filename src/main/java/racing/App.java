package racing;

import racing.service.RacingGame;
import racing.view.InputView;
import racing.view.GameResultView;

public class App {

    public static void main(String[] args) {
        int carNumber = InputView.inputNumberOfCar();
        int countNumber = InputView.inputNumberOfCount();

        RacingGame racingGame = RacingGame.initialize(carNumber, countNumber);
        GameResultView resultView = racingGame.play();

        resultView.printResult();
    }
}