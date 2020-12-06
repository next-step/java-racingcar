package racingCar.domain;

import racingCar.RacingCarUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static racingCar.RacingCarUtils.checkCarNameRule;

public class Racing {
    private List<Car> cars;
    private MoveStrategy moveStrategy;

    public Racing(String carNames) {
        this.cars = Arrays.stream(splitCarNames(carNames)).map(name -> new Car(name)).collect(Collectors.toList());
        this.moveStrategy = new RandomMoveStrategy();
    }

    public Racing(String carNames, MoveStrategy moveStrategy) {
        this.cars = Arrays.stream(splitCarNames(carNames)).map(name -> new Car(name)).collect(Collectors.toList());
        //this.cars = Stream.generate(() -> new Car()).limit(carNums).collect(Collectors.toList());
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        for (Car car : cars) {
            car.racing(RacingCarUtils.randomValueGenerator(), moveStrategy);
        }
    }

    public String[] splitCarNames(String carNames) {
        String[] cars = carNames.split(",");
        for(String car : cars) {
            checkCarNameRule(car);
        }
        return cars;
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(cars);
    }
}
