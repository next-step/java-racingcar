package study.step3.service;

import study.step3.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceService {

    private static final int RANDOM_NUMBER_BOUND = 10;

    private final List<Car> cars;
    private final List<List<Integer>> roundRecords;

    public RaceService() {
        this.cars = new ArrayList<>();
        this.roundRecords = new ArrayList<>();
    }

    public List<List<Integer>> play(int carNumber, int roundNumber) {
        addCars(carNumber);
        startRace(roundNumber);
        return roundRecords;
    }

    private void addCars(int carNumber) {
        cars.clear();
        cars.addAll(getCars(carNumber));
    }

    private List<Car> getCars(int carNumber) {
        return IntStream.range(0, carNumber)
                .mapToObj(index -> new Car())
                .collect(Collectors.toList());
    }

    private void startRace(int roundNumber) {
        IntStream.range(0, roundNumber)
                .forEach(index -> startRound());
    }

    private void startRound() {
        moveCars();
        recorderCarPositions();
    }

    private void moveCars() {
        cars.forEach(car -> car.moveForwardIfNumberValid(getRandomNumber()));
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_BOUND);
    }

    private void recorderCarPositions() {
        roundRecords.add(getCarPositions());
    }

    private List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

}
