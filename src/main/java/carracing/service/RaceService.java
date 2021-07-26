package carracing.service;

import carracing.domain.Car;
import carracing.domain.CarStatus;
import carracing.domain.RaceResult;
import carracing.domain.RoundRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceService {

    private static final int RANDOM_NUMBER_BOUND = 10;

    private final List<Car> cars;
    private final List<RoundRecord> roundRecords;

    public RaceService() {
        this.cars = new ArrayList<>();
        this.roundRecords = new ArrayList<>();
    }

    public RaceResult play(List<String> carNames, int roundNumber) {
        addCars(carNames);
        initRoundRecords();
        startRace(roundNumber);
        return new RaceResult(roundRecords);
    }

    private void addCars(List<String> carNames) {
        cars.clear();
        cars.addAll(getCars(carNames));
    }

    private void initRoundRecords() {
        roundRecords.clear();
        recordCarRecords();
    }

    private List<Car> getCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void startRace(int roundNumber) {
        IntStream.range(0, roundNumber)
                .forEach(index -> startRound());
    }

    private void startRound() {
        moveCars();
        recordCarRecords();
    }

    private void moveCars() {
        cars.forEach(car -> car.moveForwardIfNumberValid(getRandomNumber()));
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_BOUND);
    }

    private void recordCarRecords() {
        roundRecords.add(new RoundRecord(getRecords()));
    }

    private List<CarStatus> getRecords() {
        return cars.stream()
                .map(Car::getCarStatus)
                .collect(Collectors.toList());
    }

}
