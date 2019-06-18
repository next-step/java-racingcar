package study.racingcar;

import study.racingcar.creator.RacingCarCreator;
import study.racingcar.model.Car;
import study.racingcar.model.CarRacingLog;
import study.racingcar.model.CarsRacingLog;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGame {
    private final int carCount;
    private final int time;

    public RacingGame(int carCount, int time) {
        this.carCount = carCount;
        this.time = time;
    }

    public List<CarsRacingLog> start() {
        List<Car> cars = makeRacingCar();
        return runCarsRepeatByTime(cars);
    }

    private List<CarsRacingLog> runCarsRepeatByTime(List<Car> cars) {
        return IntStream.range(0, time)
                .boxed()
                .map(index -> this.runCars(cars))
                .collect(Collectors.toList());
    }

    private CarsRacingLog runCars(List<Car> cars) {
        CarsRacingLog carsRacingLog = new CarsRacingLog();

        for (Car car : cars) {
            car.run();
            carsRacingLog.add(makeCarRacingLog(car));
        }
        return carsRacingLog;
    }

    private CarRacingLog makeCarRacingLog(Car car) {
        return new CarRacingLog(car.getName(), car.getPosition());
    }

    private List<Car> makeRacingCar() {
        return RacingCarCreator.create(this.carCount);
    }
}
