package racingcar.util;

import racingcar.model.Car;

import java.util.Random;

public class RandomNumberGenerator implements NumberCreator {

    @Override
    public int number(Car car) {
        return new Random().nextInt(10);
    }
}
