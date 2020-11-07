package study.racingcar.racingcars;

import study.racingcar.car.Car;

import java.util.List;

public interface RacingCarsExporter<T> {

    void cars(List<Car> cars);

    T build();

}
