package domain;

import util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarList {
    private final List<RacingCar> cars;

    public RacingCarList(int carCount) {
        this.cars = createCars(carCount);
    }

    public RacingCarList(String[] carNames) {
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

    public void moveCars() {
        for (RacingCar car : cars) {
            car.moveForward(RandomNumberGenerator.generateRandomNumber());
        }
    }

    public List<RacingCar> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
