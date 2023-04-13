package domain;

import util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGame {
    private final List<RacingCar> cars;

    public RacingCarGame(int carCount) {
        this.cars = createCars(carCount);
    }

    public RacingCarGame(String[] carNames) {
        this.cars = createCars(carNames);
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private static List<RacingCar> createCars(int carCount) {
        return Stream.generate(RacingCar::new)
                .limit(carCount)
                .collect(Collectors.toList());
    }

    private static List<RacingCar> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public List<RacingCar> playAndReturnCars() {
        moveCars();
        return this.cars;
    }

    public void moveCars() {
        for (RacingCar car : cars) {
            car.moveForward(RandomNumberGenerator.generateRandomNumber());
        }
    }

    public List<RacingCar> getWinners() {
        return findWinningCars(this.cars);
    }

    private List<RacingCar> findWinningCars(List<RacingCar> cars) {
        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
