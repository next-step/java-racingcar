package racinggame.domain.car;

import racinggame.util.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int RANDOM_BOUND = 10;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public static Cars newRacingCarsFrom(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public Cars moveCarAll() {
        List<Car> cars = this.cars.stream()
                .map(car -> car.moveCar(NumberUtil.createRandomInt(RANDOM_BOUND)))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private int getMaxMoveRange() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Position.ZERO);
    }

    public List<String> findWinner() {
        int range = getMaxMoveRange();
        return cars.stream()
                .filter(car -> car.isMovedFarThan(range))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(this.cars);
    }
}
