package step5.controller;

import step5.domain.Car;
import step5.util.CarUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private final List<Car> cars;
    private final int numberOfMove;
    private int carMoveCount;

    public RacingCarController(List<Car> cars, int numberOfMove) {
        this.cars = cars;
        this.numberOfMove = numberOfMove;
    }

    public static RacingCarController of(String[] carNames, int numberOfMove) {
        CarUtils.carNameMaxValid(carNames);
        return new RacingCarController(newCars(carNames), numberOfMove);
    }

    private static List<Car> newCars(String[] racingCars) {
        return Arrays.stream(racingCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void carMove() {
        cars.forEach(car -> car.move(CarUtils.getRandom()));
        hasNextRound();
    }

    private void hasNextRound() {
        carMoveCount++;
    }

    public List<Car> gameProgress() {
        carMove();
        return getCars();
    }

    public boolean isFinish() {
        return numberOfMove == carMoveCount;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
