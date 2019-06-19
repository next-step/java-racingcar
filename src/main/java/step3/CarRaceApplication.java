package step3;

import step3.domain.CarRace;
import step3.domain.Cars;
import step3.view.InputView;
import step3.view.OutputView;

public class CarRaceApplication {

    private static CarRace carRace;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        final String inputCarNames = inputView.getCarNames();
        final int numberOfTrials = inputView.getNumberOfTrials();

        carRace = CarRace.raceStart(inputCarNames, numberOfTrials);

        OutputView outputView = new OutputView();
        outputView.showResultTitle();
        for (int i = 0; i < numberOfTrials; i++) {
            Cars raceResult = carRace.executeTrials();
            outputView.showResult(raceResult);
        }
    }

}
