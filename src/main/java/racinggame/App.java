package racinggame;

import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class App {

    public static void main(String[] args) {
        int carNumber = InputView.inputNumberOfCar();
        int countNumber = InputView.inputNumberOfCount();

        RacingGame racingGame = new RacingGame(new Cars(carNumber), new Count(countNumber));
        ResultView resultView = racingGame.play();
        resultView.printResult();
    }
}
