package study.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RaceManager {

    private static final int BOUND = 10;
    private static final int MOVE_FORWARD_BASIS = 4;
    public static final String LESS_THAN_OR_EQUAL_ZERO = "입력값은 0보다 커야합니다 -> ";

    private final CarManager carManager;
    private final RoundManager roundManager;
    private final RaceRecorder raceRecorder;
    private final List<Car> cars;

    public RaceManager(CarManager carManager, RoundManager roundManager, RaceRecorder raceRecorder) {
        this.carManager = carManager;
        this.roundManager = roundManager;
        this.raceRecorder = raceRecorder;
        this.cars = new ArrayList<>();
    }

    public String manageRace(int carNumber, int roundNumber) {
        validation(carNumber, roundNumber);
        addCars(carNumber);
        raceRecorder.prepareRecord(cars);
        roundManager.startRace(roundNumber, getToDoList());
        return raceRecorder.getAllRoundRecords();
    }

    private void addCars(int carNumber) {
        cars.clear();
        cars.addAll(carManager.getCars(carNumber));
    }

    private List<Runnable> getToDoList() {
        return Arrays.asList(moveCars(), notifyRaceRecorder());
    }

    private Runnable moveCars() {
        return () -> cars.stream()
                .filter(car -> canCarMoveForward())
                .forEach(Car::moveForward);
    }

    private boolean canCarMoveForward() {
        return new Random().nextInt(BOUND) >= MOVE_FORWARD_BASIS;
    }

    private Runnable notifyRaceRecorder() {
        return raceRecorder::recordRound;
    }

    private void validation(int carNumber, int roundNumber) {
        requireGreaterThanZero(carNumber);
        requireGreaterThanZero(roundNumber);
    }

    private void requireGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(LESS_THAN_OR_EQUAL_ZERO + number);
        }
    }

}
