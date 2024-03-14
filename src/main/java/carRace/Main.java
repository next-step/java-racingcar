package carRace;

import static carRace.domain.Car.createCars;

import carRace.domain.Referee;
import carRace.view.InputView;
import carRace.domain.Car;
import carRace.domain.RaceHost;
import carRace.view.OutputView;
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
