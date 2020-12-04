package racingCar.domain;

import racingCar.RacingCarUtils;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars;

    public Racing(int carNums) {
        this.cars = mapCars(carNums);
    }

    private static List<Car> mapCars(int carNums) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNums; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.racing(RacingCarUtils.RandomValueGenerator());
        }
    }

    public List<Car> getRacingCars() {
        return cars;
    }
}
