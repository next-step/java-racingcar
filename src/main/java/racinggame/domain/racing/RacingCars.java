package racinggame.domain.racing;

import racinggame.domain.car.Car;
import racinggame.util.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. 레이싱을 진행하는 car들의 collection
 * 1. 모든 자동차를 이동
 */
public class RacingCars {
    private static final int RANDOM_BOUND = 10;
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        List<Car> result = new ArrayList<>();

        for (Car car : cars) {
            result.add(new Car(car));
        }

        this.cars = result;
    }

    public RacingCars(RacingCars cars) {
        List<Car> result = new ArrayList<>();

        for (Car car : cars.getCars()) {
            result.add(new Car(car));
        }

        this.cars = result;
    }

    public RacingCars moveCarAll() {
        List<Car> cars = new ArrayList<>();
        for (Car car : this.cars) {
            cars.add(car.moveCar(NumberUtil.createRandomInt(RANDOM_BOUND)));
        }
        return new RacingCars(cars);
    }

    private int getFarthestCarMoveRange() {
        Collections.sort(this.cars);
        return this.cars.get(getCarsLastIndex()).getMoveRange();
    }

    private int getCarsLastIndex() {
        return cars.size() - 1;
    }

    public List<String> findWinner() {
        int range = getFarthestCarMoveRange();
        List<String> result = new ArrayList<>();

        for (Car car : this.cars) {
            if (car.isMovedFarThan(range)) {
                result.add(car.getCarName());
            }
        }

        return result;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
