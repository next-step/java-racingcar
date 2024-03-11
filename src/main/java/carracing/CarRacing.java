package carracing;

import carracing.model.NumberOfAttempts;
import carracing.model.NumberOfCars;
import carracing.model.Race;
import carracing.model.RaceRecord;

import java.util.List;

import static carracing.view.InputView.*;
import static carracing.view.OutputView.printRaceResult;

public class CarRacing {
    public static void main(String[] args) {
        try {
            NumberOfCars numberOfCars = new NumberOfCars(enteredNumber(NUMBER_OF_CARS_INPUT_GUIDE_MESSAGE));
            NumberOfAttempts numberOfAttempts = new NumberOfAttempts(enteredNumber(NUMBER_OF_ATTEMPTS_INPUT_GUIDE_MESSAGE));

            Race race = new Race(numberOfCars, numberOfAttempts);
            List<RaceRecord> raceRecordList = race.start();

            printRaceResult(raceRecordList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
