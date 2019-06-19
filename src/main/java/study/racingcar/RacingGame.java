package study.racingcar;

import study.racingcar.model.Cars;
import study.racingcar.model.CarsRacingLog;
import study.racingcar.model.Drivers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGame {
    private Drivers drivers;
    private int time;

    public RacingGame(Set<String> driverNames, int time) {
        this.drivers = new Drivers(driverNames);
        this.time = time;
    }

    public List<CarsRacingLog> start() {
        final Cars cars = driversRideRacingCar();
        return runCarsRepeatByTime(cars);
    }

    private List<CarsRacingLog> runCarsRepeatByTime(Cars cars) {
        return IntStream.range(0, time)
                .boxed()
                .map(index -> cars.allRun())
                .collect(Collectors.toList());
    }

    private Cars driversRideRacingCar() {
        return Cars.ride(this.drivers);
    }
}
