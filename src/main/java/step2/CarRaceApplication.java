package step2;

import step2.domain.CarRace;
import step2.view.InputView;

public class CarRaceApplication {

    private static CarRace carRace;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        final int numberOfCars = inputView.getNumberOfCars();
        final int numberOfTrials = inputView.getNumberOfTrials();

        carRace.raceExecute(numberOfCars, numberOfTrials);
    }


}
