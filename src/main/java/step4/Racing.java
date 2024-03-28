package step4;

import step4.domain.RacingCars;
import step4.view.InputView;
import step4.view.ResultView;

public class Racing {
    public static void main(String[] args) {

        InputView inputView = new InputView();

        String[] cars = inputView.inputNamesSplittedByComma();
        int countRound = inputView.inputCountRound();

        inputView.close();

        RacingCars racingCars = new RacingCars(cars);

        ResultView resultView = new ResultView();

        resultView.printResultTitle();
        for (int i = 0; i < countRound; i++) {
            racingCars.raceCars(racingCars);
            resultView.printRacingCars(racingCars);
        }
        resultView.printWinner(racingCars);
    }
}
