package step2;

import step2.domain.CarRace;
import step2.domain.Cars;
import step2.utils.NumberGenerator;
import step2.view.InputView;
import step2.view.OutputView;

public class CarRaceApplication {

    private static CarRace carRace;
    private static NumberGenerator numberGenerator;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        final int numberOfCars = inputView.getNumberOfCars();
        final int numberOfTrials = inputView.getNumberOfTrials();

        carRace.raceStart(numberOfCars, numberOfTrials);

        for (int i = 0; i < numberOfTrials; i++) {
            Cars raceResult = carRace.executeTrials(numberGenerator);
            new OutputView(raceResult);
        }
    }

}
