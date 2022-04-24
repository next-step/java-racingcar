package carrace;


import carrace.util.Splitter;

import java.util.List;

public class CarRace {
    private final RecordCarRace recordCarRace = new RecordCarRace();

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
        return cars;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public RecordCarRace getRecordCarRace() {
        return recordCarRace;
    }

    public RaceWinner getRaceWinner() {
        return raceWinner;
    }
}
