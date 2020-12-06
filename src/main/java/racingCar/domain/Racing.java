package racingCar.domain;

import racingCar.RacingCarUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {
    private List<Car> cars;
    private MoveStrategy moveStrategy;

    public Racing(int carNums) {
        this.cars = Stream.generate(() -> new Car()).limit(carNums).collect(Collectors.toList());
        this.moveStrategy = new RandomMoveStrategy();
    }

    public Racing(int carNums, MoveStrategy moveStrategy) {
        this.cars = Stream.generate(() -> new Car()).limit(carNums).collect(Collectors.toList());
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        for (Car car : cars) {
            car.racing(RacingCarUtils.randomValueGenerator(), moveStrategy);
        }
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(cars);
    }
}
