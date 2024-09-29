package racingcar.util;

import racingcar.model.Car;

@FunctionalInterface
public interface NumberCreator {
    int number(Car car);
}
