package study.racingcar.configuration;

import study.racingcar.car.Car;
import study.racingcar.car.moving.CarMovingStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractGameConfiguration implements GameConfiguration {

    protected int numberOfCars;
    protected int numberOfTries;
    protected CarMovingStrategy strategy;

    protected void validate() {

        if (numberOfCars < 1) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
        }

        if (numberOfTries < 1) {
            throw new IllegalArgumentException("최소 1번 이상의 시도를 입력해야합니다.");
        }
    }

    @Override
    public List<Car> initCars() {
        return IntStream.range(0, numberOfCars)
                .mapToObj(i -> new Car(strategy))
                .collect(Collectors.toList());
    }
}
