package racinggame.domain.racing;

import racinggame.domain.car.Car;
import racinggame.util.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. 레이싱을 진행하는 car들의 collection
 * 1. 모든 자동차를 이동
 */
public class RacingCars {
    private static final int RANDOM_BOUND = 10;

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public static RacingCars newRacingCarsFrom(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return new RacingCars(cars);
    }

    public RacingCars moveCarAll() {
        List<Car> cars = new ArrayList<>();
        for (Car car : this.cars) {
            cars.add(car.moveCar(NumberUtil.createRandomInt(RANDOM_BOUND)));
        }
        return new RacingCars(cars);
    }

    private int getMaxMoveRange() {
        Car car = Collections.max(cars);
        return car.getMoveRange();
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
