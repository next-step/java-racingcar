package racinggame.domain.racing;

import racinggame.domain.car.Car;

import java.util.List;

/**
 * 1. 레이싱을 진행하는 car들의 collection
 * 1. 모든 자동차를 이동
 */
public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCarAll() {
        for (Car car : this.cars) {
            car.moveCar();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
