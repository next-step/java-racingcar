package step3;

import step3.domain.RacingCars;
import step3.view.InputView;
import step3.view.ResultView;

public class Racing {
    public static void main(String[] args) {

        InputView inputView = new InputView();

        int numberOfCars = inputView.inputNumberOfCars();
        int countRound = inputView.inputCountRound();

        RacingCars racingCars = new RacingCars(numberOfCars);

        ResultView resultView = new ResultView();

        for (int i = 0; i < countRound; i++) {
            racingCars.raceCars(racingCars);
            resultView.printRacingCars(racingCars);
        }
    }
}
