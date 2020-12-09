package race.applicantion;

import race.domain.CarNames;
import race.domain.RacingCars;
import race.view.ConsoleView;

public class RaceApplication {

    private static String NAME_DELIMITER = ",";

    public static void main(String[] args) {
        String carNames = ConsoleView.inputCarNames();
        int numOfTry = ConsoleView.inputNumOfTry();

        try {
            race(carNames, numOfTry);
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }
    }

    private static void race(String strCarNames, int numOfTry) {
        CarNames carNames = CarNames.createWithDelimiter(strCarNames, NAME_DELIMITER);
        RacingCars cars = RacingCars.createRandomMoveCars(carNames);
        for (int i = 0; i < numOfTry; i++) {
            cars.step();
            ConsoleView.showResult(cars);
        }
    }
}
