package study.step4;

import study.step4.domain.CarRacingGame;
import study.step4.domain.Cars;
import study.step4.view.InputView;
import study.step4.view.ResultView;

public class CarRacingGameApplication {
    public static void main(String[] args) {
        CarRacingGame carRacingGame = new CarRacingGame(new Cars(InputView.inputCarNameWithComma()), Integer.parseInt(InputView.inputNumberOfAttempts()));

        ResultView resultView = new ResultView(carRacingGame.start());
        resultView.printRecordResult();
        resultView.printWinner();

    }
}
