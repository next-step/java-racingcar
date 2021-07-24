package study.step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RaceManager {

    private static final int BOUND = 10;
    private static final int MOVE_FORWARD_BASIS = 4;
    public static final String LESS_THAN_OR_EQUAL_ZERO = "입력값은 0보다 커야합니다 -> ";

    private final CarManager carManager;
    private final RoundManager roundManager;
    private final List<Car> cars;
    private final List<List<Integer>> roundRecords;

    public RaceManager(CarManager carManager, RoundManager roundManager) {
        this.carManager = carManager;
        this.roundManager = roundManager;
        this.cars = new ArrayList<>();
        this.roundRecords = new ArrayList<>();
    }

    public List<List<Integer>> manageRace(int carNumber, int roundNumber) {
        validation(carNumber, roundNumber);
        addCars(carNumber);
        roundManager.startRace(roundNumber, getToDoList());
        return roundRecords;
    }

    private void addCars(int carNumber) {
        cars.clear();
        cars.addAll(carManager.getCars(carNumber));
    }

    private List<Runnable> getToDoList() {
        return Arrays.asList(moveCars(), recorderCarPositions());
    }

    private Runnable moveCars() {
        return () -> cars.stream()
                .filter(car -> canCarMoveForward())
                .forEach(Car::moveForward);
    }

    private Runnable recorderCarPositions() {
        return () -> roundRecords.add(getCarPositions());
    }

    private boolean canCarMoveForward() {
        return new Random().nextInt(BOUND) >= MOVE_FORWARD_BASIS;
    }

    private List<Integer> getCarPositions() {
        return cars.stream().map(Car::getPosition).collect(Collectors.toList());
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
