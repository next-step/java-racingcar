package step4;

import step3.domain.RacingCars;
import step4.view.InputView;
import step4.view.ResultView;

public class Racing {
    public static void main(String[] args) {

        InputView inputView = new InputView();

        int numberOfCars = inputView.inputNumberOfCars();
        int countRound = inputView.inputCountRound();

        inputView.close();

        RacingCars racingCars = new RacingCars(numberOfCars);

        ResultView resultView = new ResultView();

        for (int i = 0; i < countRound; i++) {
            racingCars.raceCars(racingCars);
            resultView.printRacingCars(racingCars);
        }
    }
}
