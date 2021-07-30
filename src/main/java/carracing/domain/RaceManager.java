package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RaceManager {

    private static final int RANDOM_NUMBER_BOUND = 10;

    private final List<Car> cars;
    private final List<RoundRecord> roundRecords;

    public RaceManager() {
        this.cars = new ArrayList<>();
        this.roundRecords = new ArrayList<>();
    }

    public RaceResult play(CarNames carNames, RoundNumber roundNumber) {
        addCars(carNames);
        initRoundRecords();
        startRace(roundNumber);
        return new RaceResult(roundRecords);
    }

    private void addCars(CarNames carNames) {
        cars.clear();
        cars.addAll(getCars(carNames));
    }

    private void initRoundRecords() {
        roundRecords.clear();
        recordCarRecords();
    }

    private List<Car> getCars(CarNames carNames) {
        return carNames.getCarNamesStream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void startRace(RoundNumber roundNumber) {
        roundNumber.getRoundIntStream()
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
