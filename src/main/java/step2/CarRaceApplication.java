package step2;

import step2.domain.CarRace;
import step2.view.InputView;
import step2.view.OutputView;

public class CarRaceApplication {

    private static CarRace carRace;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        final int numberOfCars = inputView.getNumberOfCars();
        final int numberOfTrials = inputView.getNumberOfTrials();

        carRace.raceStart(numberOfCars);

        OutputView.showResultTitle();
        for (int i = 0; i < numberOfTrials; i++) {
            new OutputView(carRace.executeTrials());
        }
    }

}
