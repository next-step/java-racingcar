package study.racingcar.racingcars;

import study.racingcar.car.Car;
import study.racingcar.car.CarSnapshot;

import java.util.List;

public interface RacingCarsExporter<T> {

    void cars(List<CarSnapshot> carSnapshot);

    T build();

}
