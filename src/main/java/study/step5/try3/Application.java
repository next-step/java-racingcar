package study.step5.try3;

import study.step5.try3.domain.CarRacingGame;
import study.step5.try3.view.InputView;
import study.step5.try3.view.ResultView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNameWithComma();
        int numberOfAttempts = InputView.inputNumberOfAttempts();

        CarRacingGame carRacingGame = CarRacingGame.of(carNames, numberOfAttempts);
        ResultView resultView = carRacingGame.start();

        resultView.printRecodeResult();
        resultView.printWinners();
    }
}
