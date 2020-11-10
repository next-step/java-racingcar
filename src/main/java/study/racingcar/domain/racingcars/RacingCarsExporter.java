package study.racingcar.domain.racingcars;

import study.racingcar.domain.car.CarSnapshot;

import java.util.List;

public interface RacingCarsExporter<T> {

    void cars(List<CarSnapshot> carSnapshot);

    T build();

}
