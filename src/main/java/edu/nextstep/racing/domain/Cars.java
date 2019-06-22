package edu.nextstep.racing.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 14:33
 */
public class Cars {
    private static final int RANDOM_NUMBER_RANGE = 9;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars doMoveGame() {
        cars.stream()
                .peek(car -> car.carMove(validMoveNumber()))
                .collect(Collectors.toList());

        return new Cars(this.cars);
    }

    public Stream<Car> stream() {
        return this.cars.stream();
    }

    private int validMoveNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
