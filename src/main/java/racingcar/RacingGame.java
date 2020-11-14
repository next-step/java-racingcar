package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final int rounds;
    private final List<Car> cars;
    private final List<RaceRecord> raceRecords;

    final static int START_LOCATION = 0;

    public RacingGame(int cars, int rounds) {
        this.cars = makeCars(cars);
        this.rounds = rounds;
        this.raceRecords = new ArrayList<>();
    }

    public int getRounds() {
        return rounds;
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }

    private List<Car> makeCars(int cars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < cars; i++) {
            Car car = new Car(START_LOCATION);
            carList.add(car);
        }
        return carList;
    }

    public void play() {
        for (int i = 0; i < rounds; i++) {
            playSingleRound(i);
        }
    }

    private void playSingleRound(int round) {
        cars.forEach(Car::tryToMove);
        raceRecords.add(new RaceRecord(round, saveRecords()));
    }

    private List<Integer> saveRecords() {
        return cars.stream().map(Car::getLocation)
                .collect(Collectors.toList());
    }
}
