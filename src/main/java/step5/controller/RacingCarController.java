package step5.controller;

import step5.domain.Car;
import step5.util.CarUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private List<Car> cars;

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

    public List<Car> carMove() {
        cars.forEach(car -> car.move(CarUtils.getRandom()));
        return cars;
    }

}
