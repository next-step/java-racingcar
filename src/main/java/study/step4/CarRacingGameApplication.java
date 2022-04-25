package study.step4;

import study.step4.domain.CarRacingGame;
import study.step4.view.InputView;
import study.step4.view.ResultView;

public class CarRacingGameApplication {
    public static void main(String[] args) {
        String carNameWithComma = InputView.inputCarNameWithComma();
        int numberOfAttempts = InputView.inputNumberOfAttempts();
        CarRacingGame carRacingGame = CarRacingGame.of(carNameWithComma, numberOfAttempts);

        ResultView resultView = new ResultView(carRacingGame.start());
        resultView.printRecordResult();
        resultView.printWinner();

    }
}
