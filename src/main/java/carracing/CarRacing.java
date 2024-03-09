package carracing;

import carracing.model.Race;
import carracing.model.RaceStatus;

import java.util.List;

import static carracing.view.InputView.*;
import static carracing.view.OutputView.printRaceResult;

public class CarRacing {
    public static void main(String[] args) {
        try {
            int enteredNumberOfCars = enteredNumber(NUMBER_OF_CARS_INPUT_GUIDE_MESSAGE);
            int enteredNumberOfAttempts = enteredNumber(NUMBER_OF_ATTEMPTS_INPUT_GUIDE_MESSAGE);

            Race race = new Race(enteredNumberOfCars, enteredNumberOfAttempts);
            List<RaceStatus> raceStatusList = race.start();

            printRaceResult(raceStatusList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
