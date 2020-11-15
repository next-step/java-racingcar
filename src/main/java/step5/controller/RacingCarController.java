package step5.controller;

import step5.domain.Car;
import step5.util.CarUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarController {
    private static List<Car> cars;
    private int carMoveCount = 0;

    public List<Car> start(String[] carNames) {
        CarUtils.carNameMaxValid(carNames);
        return newCars(carNames);
    }

    private List<Car> newCars(String[] racingCars) {
        cars = Arrays.stream(racingCars)
                .map(Car::new)
                .collect(Collectors.toList());
        return cars;
    }

    public static List<Car> carMove() {
        cars.forEach(car -> car.move(CarUtils.getRandom()));
        return cars;
    }

    public int carMove(int numberOfMove) {
        IntStream.range(0, numberOfMove)
                .forEach(count -> carMoveCount++);
        return carMoveCount;
    }
}
