package study.step4.try2;

import study.step4.try2.domain.CarRacingGame;
import study.step4.try2.view.InputView;
import study.step4.try2.view.ResultView;

public class Application {
    public static void main(String[] args) {
        String[] carNamesArray = InputView.inputCarNameWithComma();
        int numberOfAttempts = InputView.inputNumberOfAttempts();

        CarRacingGame carRacingGame = CarRacingGame.of(carNamesArray, numberOfAttempts);
        ResultView resultView = carRacingGame.start();

        resultView.printRecodeResult();
        resultView.printWinners();
    }
}
