package racing;

import racing.domain.CarRacing;
import racing.domain.Cars;

import static racing.view.CarRacingInputView.countOfCars;
import static racing.view.CarRacingInputView.countOfRace;
import static racing.view.CarRacingResultView.*;

public class CarRacingMain {
    public static void main(String[] args) {
        Cars cars = new Cars(countOfCars());
        CarRacing carRacing = new CarRacing(cars, countOfRace());

        printRacingResultHeader();

        carRacing.race(printRacingResult(), printRaceFooter());

    }
}
