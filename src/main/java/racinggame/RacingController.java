package racinggame;

import racinggame.car.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingController {

    public static void main(String[] args) {
        String carNames = InputView.inputNameOfCar();
        int countNumber = InputView.inputNumberOfCount();

        RacingGame racingGame = RacingGame.of(carNames, countNumber);
        ResultView resultView = racingGame.play();

        resultView.printResult();
    }
}
