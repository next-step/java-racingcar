package step5.domain;

import step5.util.CarUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    public List<Car> start(String[] carNames) {
        CarUtils.carNameMaxValid(carNames);
        return newCars(carNames);
    }

    private List<Car> newCars(String[] racingCars) {
        return Arrays.stream(racingCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> carMove(List<Car> cars) {
        cars.forEach(car -> car.move(CarUtils.getRandom()));
        return cars;
    }

}
