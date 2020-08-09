package racing;

import racing.behavior.CarMovable;
import racing.domain.Car;
import racing.view.ResultView;

import java.util.List;

import static racing.domain.Car.listOf;
import static racing.domain.Car.raceOfCars;
import static racing.view.InputView.getNumberOfAttempt;
import static racing.view.InputView.getNumberOfCars;
import static racing.view.ResultView.printRacingGameResult;

public class RacingGame {

    public static void main(final String[] args) {
        final int numberOfCar = getNumberOfCars();
        final int numberOfAttempt = getNumberOfAttempt();

        printRacingGameResult();
        final List<Car> cars = listOf(numberOfCar, new CarMovable());
        for (int i = 0; i < numberOfAttempt; i++) {
            raceOfCars(cars);
            ResultView.printLocationsByCars(cars);
        }
    }
}
