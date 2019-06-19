package study.racingcar.model;

import study.racingcar.strategy.RandomMovableStrategy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * Created by wyparks2@gmail.com on 2019-06-19
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Cars {
    private Set<Car> cars;

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

    private CarRacingLog makeCarRacingLog(Car car) {
        return new CarRacingLog(car, car.getPosition());
    }

    public static Cars ride(Drivers drivers) {
        final List<Car> cars = drivers.getDrivers().stream()
                .map(driver -> new Car(driver, new RandomMovableStrategy()))
                .collect(toList());

        return new Cars(cars);
    }
}
