package carrace;


import java.util.List;

public class CarRace {
    private final RecordCarRace recordCarRace = new RecordCarRace();
    private final RaceWinner raceWinner;

    private List<Car> cars;
    private final int numberOfRaces;

    public CarRace(String carNames, int numberOfRaces) {
        cars = new Splitter().splitCarNames(carNames);
        this.numberOfRaces = numberOfRaces;

        raceWinner = new RaceWinner(cars.size());
    }

    public void startRaces() {
        for (int i = 0; i < this.numberOfRaces; i++) {
            startEachRace();
        }
    }

    private void startEachRace() {
        for (Car car : this.cars) {
            recordCarRace.record(car.race(numberOfRaces));
        }
    }

    public void endRaces() {
        raceWinner.confirmWinners(recordCarRace.getRaceInfoBoards(), cars);
    }

    public List<Car> getCars() {
        return cars;
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
