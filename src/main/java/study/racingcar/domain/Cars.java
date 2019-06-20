package study.racingcar.domain;

import study.racingcar.strategy.MovableStrategy;
import study.racingcar.strategy.RandomMovableStrategy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wyparks2@gmail.com on 2019-06-19
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Cars {
    private Set<Car> cars;

    public Cars(Set<String> carNames) {
        this.cars = carNames.stream()
                .map(carName -> new Car(carName, new RandomMovableStrategy()))
                .collect(Collectors.toSet());
    }

    public Cars(Set<String> carNames, MovableStrategy movableStrategy) {
        this.cars = carNames.stream()
                .map(carName -> new Car(carName, movableStrategy))
                .collect(Collectors.toSet());
    }

    public Cars(List<Car> cars) {
        this.cars = new HashSet<>(cars);
    }

    public CarsRacingLog allRun() {
        CarsRacingLog carsRacingLog = new CarsRacingLog();

        for (Car car : this.cars) {
            car.run();
            carsRacingLog.add(makeCarRacingLog(car));
        }

        return carsRacingLog;
    }

    public Set<Car> getCars() {
        return cars;
    }

    private CarRacingLog makeCarRacingLog(Car car) {
        return new CarRacingLog(car, car.getPosition());
    }
}
