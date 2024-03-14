package carRace;

import static carRace.domain.Car.createCars;

import carRace.view.InputView;
import carRace.view.OutputView;
import carRace.domain.Car;
import carRace.domain.RaceHost;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RaceHost raceHost = new RaceHost(InputView.inputRaceCarCount(), InputView.inputRaceTryCount());
        List<Car> cars = createCars(raceHost.carCount());
        raceHost.playGame(cars);
    }
}
