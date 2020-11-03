package study.racingcar.configuration;

import study.racingcar.car.Car;

import java.util.List;

public interface GameConfiguration {

    boolean doMoreTry(int count);

    List<Car> initCars();
}
