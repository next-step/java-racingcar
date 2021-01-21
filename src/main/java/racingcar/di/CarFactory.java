package racingcar.di;

import racingcar.domain.Car;

import java.util.List;

public interface CarFactory {
    List<Car> makeCars(String[] names);
}