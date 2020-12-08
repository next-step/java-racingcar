package race.applicantion;

import race.domain.RacingCars;
import race.domain.RandomMovePolicy;
import race.view.ConsoleView;

public class RaceApplication {

    public static void main(String[] args) {
        int numOfCar = ConsoleView.inputNumOfCar();
        int numOfTry = ConsoleView.inputNumOfTry();

        race(numOfCar, numOfTry);
    }

    private static void race(int numOfCar, int numOfTry) {
        RacingCars cars = RacingCars.createCars(numOfCar, new RandomMovePolicy());
        for (int i = 0; i < numOfTry; i++) {
            cars.step();
        }
    }
}
