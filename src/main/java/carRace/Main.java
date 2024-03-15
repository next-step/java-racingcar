package carRace;

import static carRace.domain.car.Car.createCars;

import carRace.domain.car.Car;
import carRace.domain.RaceHost.RaceHost;
import carRace.view.InputView;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String input = InputView.inputCarsName();
        RaceHost raceHost = new RaceHost(InputView.inputRaceTryCount());

        List<Car> cars = createCars(Arrays.asList(input.split(",")));
        raceHost.playGame(cars);
        raceHost.progressAwardsCeremony(cars);
    }
}
