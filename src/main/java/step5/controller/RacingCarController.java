package step5.controller;

import step5.domain.Car;
import step5.util.CarUtils;
import step5.view.RacingCarUi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    private List<Car> carMove() {
        cars.forEach(car -> car.move(CarUtils.getRandom()));
        return cars;
    }

    public void carMove(int numberOfMove) {
        IntStream.range(0, numberOfMove)
                .mapToObj(i -> this.carMove())
                .forEach(RacingCarUi::resultPrint);
    }
}
