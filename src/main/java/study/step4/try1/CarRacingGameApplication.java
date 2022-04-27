package study.step4.try1;

import study.step4.try1.view.InputView;
import study.step4.try1.view.ResultView;
import study.step4.try1.domain.CarRacingGame;

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
