package carracing;

import carracing.model.*;

import java.util.List;

import static carracing.view.InputView.*;
import static carracing.view.OutputView.printRaceResult;

public class CarRacing {
    public static void main(String[] args) {
        try {
            List<NameOfCar> nameOfCarList = enteredNameOfCars();
            NumberOfAttempts numberOfAttempts = enteredNumberOfAttempts();

            Race race = Race.newRace(nameOfCarList, numberOfAttempts);
            RaceResult raceResult = race.start();
            printRaceResult(numberOfAttempts, raceResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
