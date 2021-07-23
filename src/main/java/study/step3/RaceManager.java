package study.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceManager {

    public static final String LESS_THAN_OR_EQUAL_ZERO = "입력값은 0보다 커야합니다 -> ";
    private final CarManager carManager;
    private final DriverRecruiter driverRecruiter;
    private final RoundManager roundManager;
    private final RaceRecorder raceRecorder;
    private final List<Car> cars;
    private final List<Driver> drivers;

    public RaceManager(CarManager carManager, DriverRecruiter driverRecruiter, RoundManager roundManager, RaceRecorder raceRecorder) {
        this.carManager = carManager;
        this.driverRecruiter = driverRecruiter;
        this.roundManager = roundManager;
        this.raceRecorder = raceRecorder;
        this.cars = new ArrayList<>();
        this.drivers = new ArrayList<>();
    }

    public String manageRace(int carNumber, int roundNumber) {
        validation(carNumber, roundNumber);
        addCars(carNumber);
        addDrivers();
        raceRecorder.prepareRecord(cars);
        roundManager.startRace(roundNumber, getToDoList());
        return raceRecorder.getAllRoundRecords();
    }

    private void addCars(int carNumber) {
        cars.clear();
        cars.addAll(carManager.getCars(carNumber));
    }

    private void addDrivers() {
        drivers.clear();
        drivers.addAll(driverRecruiter.recruit(cars));
    }

    private List<Runnable> getToDoList() {
        return Arrays.asList(notifyAllDrivers(), notifyRaceRecorder());
    }

    private Runnable notifyAllDrivers() {
        return () -> drivers.forEach(Driver::drive);
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
