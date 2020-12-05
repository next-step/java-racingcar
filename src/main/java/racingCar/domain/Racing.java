package racingCar.domain;

import racingCar.RacingCarUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {
    private List<Car> cars;

    public Racing(int carNums) {
        this.cars = Stream.generate(() -> new Car()).limit(carNums).collect(Collectors.toList());
    }

    public void race() {
        for (Car car : cars) {
            car.racing(RacingCarUtils.randomValueGenerator());
        }
    }

    public List<Car> getRacingCars() {
        return cars;
    }
}
