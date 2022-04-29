package carrace.domain;

import carrace.util.Splitter;

import java.util.Collections;
import java.util.List;

public class CarRace {
    private final RaceWinner raceWinner = new RaceWinner();

    private List<Car> cars;

    private final int numberOfRaces;

    public CarRace(String carNames, int numberOfRaces) {
        cars = new Splitter().splitCarNames(carNames);
        this.numberOfRaces = numberOfRaces;
    }

    public void startEachRace() {
        for (Car car : this.cars) {
            car.race();
        }
    }

    public void endRace() {
        raceWinner.confirmWinners(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public List<Car> winners() {
        return Collections.unmodifiableList(raceWinner.getWinners());
    }
}
